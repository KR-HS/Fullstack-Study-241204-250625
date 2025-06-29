# 공통
+ Inbound 규칙에 사용할 DB 포트(5432-postgre)(서버는 필요없음), HTTP(80), HTTPS(443), SSH(22)포트 및 EC2 ipv4 추가
+ nginx설정 후 도메인 연결 필요  
  [참고 사이트](https://jun-codinghistory.tistory.com/651)

<details>
<summary>nginx 설정 예시 보기</summary>

> 코드 안의 `bidcast.kro.kr` 부분을 본인 도메인에 맞게 수정하고,  
> `upstream app` 안의 포트번호를 본인 프로젝트의 포트번호로 변경하세요.

```bash
user www-data;
worker_processes auto;
pid /run/nginx.pid;
include /etc/nginx/modules-enabled/*.conf;
 
events {}

    http {
      upstream app {
        server 127.0.0.1:8888;
      }
    
      underscores_in_headers on;
      # Redirect all traffic to HTTPS
      server {
        listen 80;
        return 301 https://$host$request_uri;
      }
    
      server {
        listen 443 ssl;
        ssl_certificate /etc/letsencrypt/live/bidcast.kro.kr/fullchain.pem;
        ssl_certificate_key /etc/letsencrypt/live/bidcast.kro.kr/privkey.pem;
    
        # Disable SSL
        ssl_protocols TLSv1 TLSv1.1 TLSv1.2 TLSv1.3;
    
        # 통신과정에서 사용할 암호화 알고리즘
        ssl_prefer_server_ciphers on;
        ssl_ciphers ECDH+AESGCM:ECDH+AES256:ECDH+AES128:DH+3DES:!ADH:!AECDH:!MD5;
    
        # Enable HSTS
        # client의 browser에게 http로 어떠한 것도 load 하지 말라고 규제합니다.
        # 이를 통해 http에서 https로 redirect 되는 request를 minimize 할 수 있습니다.
        add_header Strict-Transport-Security "max-age=31536000" always;
    
        # SSL sessions
        ssl_session_cache shared:SSL:10m;
        ssl_session_timeout 10m;
    
        location / {
          proxy_pass http://app;
        }
      }
    }
```
</details>

---
# Bidcast 서버

<details>
<summary>deploy.sh 파일 예시보기</summary>

> EC2화면을 종료하더라도 서버가 실행중이라면 백그라운드에서 동작함

```bash
#!/bin/bash

APP_DIR=server           # Node.js 파일이 위치한 폴더
APP_NAME=index.js       # 실행할 Node.js 파일 이름
FULL_PATH=$APP_DIR/$APP_NAME
CURRENT_PID=$(pgrep -f $FULL_PATH)

echo "> Node.js 서버 배포 시작"
echo "> 현재 구동 중인 애플리케이션 PID 확인"
echo "> pid: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
    echo "> 현재 동작 중인 애플리케이션이 없습니다."
else
    echo "> kill -9 $CURRENT_PID"
    kill -9 $CURRENT_PID
    sleep 5
fi

echo "> 새 애플리케이션 배포를 시작합니다"
echo "> 실행 파일: $FULL_PATH"

nohup node $FULL_PATH > output.log 2>&1 &

echo "> 배포 완료. 로그는 output.log에서 확인 가능"
```
</details>

+ 자동화 서버파일 실행
> ``sh deploy.sh``

+ 로그확인
> ``tail -f output.log``

---
# Bidcast 클라이언트
+ Jenkins 이용을 위해 Inbound에 Jenkins 포트(8080) 추가
+ Jenkins 빌드 유저 권한 확인 및 sudo 설정 필요 (특히 정적 파일 복사 및 서비스 재시작 권한)
+ Jenkins 빌드 시 ubuntu와 jenkins 그룹 권한 문제 해결 위해 사용자 그룹 조정 또는 권한 부여 필요

<details>
<summary>🔧 Jenkins - Ubuntu 사용자 그룹 권한 설정 방법</summary>

1. **현재 그룹 확인**
```bash
groups ubuntu
groups jenkins
```
2. **사용자 그룹에 상대방 추가**
```bash
sudo usermod -aG jenkins ubuntu
sudo usermod -aG ubuntu jenkins
```
3. **변경 사항 적용 (재로그인 또는 재부팅 필요)**
```bash
sudo reboot
```
4. **권한 부여 (파일 및 폴더 그룹 소유권 및 권한)**
```bash
sudo chown -R ubuntu:jenkins /home/ubuntu/BidCast
sudo chown -R ubuntu:jenkins /var/www/html
sudo chmod -R 775 /home/ubuntu/BidCast
sudo chmod -R 775 /var/www/html
```
</details>

---

## 1. Jenkins 설치 (EC2 Ubuntu)
> ```
> sudo apt update
> sudo apt install -y openjdk-17-jdk
> wget -q -O - https://pkg.jenkins.io/debian/jenkins.io.key | sudo tee /usr/share/keyrings/jenkins-keyring.asc > /dev/null
> echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null
> sudo apt update
> sudo apt install -y jenkins
> sudo systemctl enable jenkins
> sudo systemctl start jenkins
> ```

## 2. Jenkins 초기 설정 및 Git 플러그인 설치
+ Jenkins 웹 접속 → 관리자 계정 생성
+ ``추천 플러그인 설치``
+ 플러그인 확인: Git, Pipeline, Blue Ocean 등이 설치되어야 함

## 3. EC2에 Node.js, Nginx 설치 (Vite 빌드용)
> ```
> curl -fsSL https://deb.nodesource.com/setup_20.x | sudo -E bash -
> sudo apt install -y nodejs
> npm install -g pnpm # pnpm 쓰면 빠름
> 
> sudo apt install nginx -y
> ```

## 4. GitHub 연동
+ Jenkins → 새로운 Item → 프리스타일 프로젝트 생성
+ 소스 코드 관리 → Git 선택 → GitHub 주소 입력
+ Credentials 등록 (개인 액세스 토큰 권장)

## 5. 빌드 및 배포 자동화 스크립트
+ Jenkins 프로젝트 설정 > 빌드 단계(Execute shell)에 아래 스크립트 입력

> ```
> #!/bin/bash
> set -e
> 
> PROJECT_DIR=/home/ubuntu/BidCast
> REACT_DIR=$PROJECT_DIR/src/main/react
> STATIC_OUTPUT=$PROJECT_DIR/src/main/resources/static/bundle
> NGINX_ROOT=/var/www/html
> LOG_FILE=$PROJECT_DIR/app.log
> 
> echo "== 1. 소스 업데이트 =="
> cd "$PROJECT_DIR"
> git reset --hard
> git pull origin main
> 
> echo "== 2. React 빌드 =="
> cd "$REACT_DIR"
> export NODE_OPTIONS=--max-old-space-size=1024
> npm run build
> 
> echo "== 3. 정적 파일 복사 준비 =="
> if [ -d "$STATIC_OUTPUT" ] && [ "$(ls -A $STATIC_OUTPUT)" ]; then
>   echo "   복사 대상: $STATIC_OUTPUT"
> else
>   echo "❌ 정적 빌드 결과가 없습니다: $STATIC_OUTPUT"
>   exit 1
> fi
> 
> echo "== 4. 정적 파일 복사 =="
> sudo -n cp -r "$STATIC_OUTPUT"/* "$NGINX_ROOT"/
> 
> echo "== 5. Spring Boot 빌드 및 재시작 =="
> cd "$PROJECT_DIR"
> chmod +x gradlew
> 
> export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
> export PATH=$JAVA_HOME/bin:$PATH
> 
> ./gradlew bootJar -x test
> 
> JAR=$(ls build/libs/*.jar | head -n1)
> if [ -z "$JAR" ]; then
>   echo "❌ 빌드된 JAR을 찾을 수 없습니다!"
>   exit 1
> fi
> 
> echo "✅ 빌드 완료. 생성된 JAR 파일: $JAR"
> 
> #pkill -f "$JAR" || true
> #sleep 2
> 
> #echo "== 6. Spring Boot 실행 =="
> #nohup java -jar "$JAR" > app.log 2>&1 &
> 
> #echo "== 배포 완료 =="
> #echo "  • Static: $STATIC_OUTPUT → $NGINX_ROOT"
> #echo "  • JAR: $JAR"
> #echo "  • 로그: $LOG_FILE"
> 
> sudo systemctl restart bidcast.service
> ```

## 6. Spring Boot 서비스 등록 (bidcast.service)
+ /etc/systemd/system/bidcast.service 파일 생성
> ```
> [Unit]
> Description=Bidcast Spring Boot Application
> After=syslog.target
> 
> [Service]
> User=ubuntu
> Group=ubuntu
> ExecStart=/usr/bin/java -jar /home/ubuntu/BidCast/build/libs/your-app.jar #실제 빌드된 JAR경로로 수정
> SuccessExitStatus=143
> Restart=always
> RestartSec=10
> 
> [Install]
> WantedBy=multi-user.target
> ```

+ 서비스 등록 및 실행
> ```
> sudo systemctl daemon-reload
> sudo systemctl enable bidcast.service
> sudo systemctl start bidcast.service
> sudo systemctl status bidcast.service
> ```

## 7. GitHub 웹훅 연동
Github에 push시 자동으로 Jenkins빌드 실행됨

+ GitHub → Repository → Settings → Webhooks
+ URL: http://<EC2_IP>:8080/github-webhook/
+ Content type: application/json
