# 웹(Web)

## 1. HTTP(Hypertext Transfer Protocol)
 + 클라리언트와 서버가 데이터를 주고받는 **규약(프로토콜)**

 + 특징 : 
     + **요청(Request)**와 **응답(Response)** 기반
     + 상태 비저장(stateless)
         + 요청 간 상태를 저장하지 않기 때문에, 서버는 클라이언트의 이전 요청을 기억하지 않아서 **매 요청마다 필요한 정보를 클라이언트가 함께 전송**해야 함
     + TCP/IP 위에서 동작
         + HTTP는 메시지 형식/규칙을 정의하고, 실제 메시지 전달은 TCP/IP가 담당

 + 구성 : 
     + **Request**
         + **시작 라인(Request Line)** : 
             ```php
             <HTTP 메서드><요청 대상 경로(URL)><HTTP 버전> 
             ```
             + `GET /users/1 HTTP/1.1`
         
         + **헤더(Header)** : 
             + 요청에 대한 추가 정보를 전달하는 영역
             + 요청자(클라이언트)의 **환경, 인증 정보, 데이터 형식, 본문 크기** 등을 서버에게 알려줌
             + `key: value` 형태로 구성
             ```
             Host: www.example.com
             User-Agent: Mozilla/5.0
             Accept: text/html
             Content-Type: application/json
             Content-Length: 123
             Authorization: Bearer <토큰>
             ```

         + **바디(Body)** : 
             + 실제 전송할 데이터가 들어가는 공간
             + POST, PUT 요청 시 본문 데이터를 담음
             + 보통 JSON, XML, form-data 형식이 들어감
             ```json
             {
               "username": "hyoensu",
               "password": "1234"
             }
             ```

         + **HTTP 요청 전체 예시**  
         > ```sql
         > POST /login HTTP/1.1       <-- 시작줄
         > Host: www.example.com      <-- 헤더 시작
         > Content-Type: application/json
         > Content-Length: 48
         > Authorization: Bearer abc123
         > 
         > {                          <-- 빈 줄 이후부터 바디 시작
         >   "username": "hyoensu",
         >   "password": "1234"
         > }
         > ```

     + **Response**
         + **상태줄(Status Line)** :
             ```php
             <HTTP 버전> <상태 코드> <상태 메시지>
             ``` 
             + `HTTP/1.1 200 OK`
             
             + 대표 상태 코드  :
                 + **200 OK** : 정상 응답
                 + **201 Created** : 자원 생성 성공
                 + **400 Bad Request** : 잘못된 요청
                 + **401 Unauthorized** : 인증 실패
                 + **403 Forbidden** : 권한 없음
                 + **404 Not Found** : 리소스 없음
                 + **500 Internal Server Error** : 서버 내부 오류

         + **헤더(Header)** : 응답에 대한 정보 제공
         > ```yaml
         > Content-Type: application/json
         > Content-Length: 178
         > Set-Cookie: sessionId=abc123; HttpOnly
         > Cache-Control: no-cache
         > ```

         + **바디(Body)** : HTML, JSON 등의 형태로 클라이언트가 요청한 데이터가 들어감

 + 장점/단점 : 
     + 장점 : 단순, 구현 용이, 대부분 브라우저/서버 지원
     + 단점 : 평문 통신 -> 데이터 도청/변조 가능

 + HTTP **메서드**  
     + **GET**
         + 역할 : **조회**
         + 특징 : 안전, Idempotent
         + 예시 : `/users/1`

     + **POST**
         + 역할 : **생성**
         + 특징 : 서버 상태 변경, 바디 필요
         + 예시 : `/users` + `{name:"홍길동"}`

     + **PUT**
         + 역할 : **전체 수정**
         + 특징 : 기존 데이터를 전체 교체
         + 예시 : `/users/1` + `{name:"이순신}`

     + **PATCH**
         + 역할 : **부분 수정**
         + 특징 : 일부 필드만 수정
         + 예시 : `/users/1` + `{age:30}`

     + **DELETE**
         + 역할 : **삭제**
         + 특징 : Idempotent
         + 예시 : `/users/1`

 + **Safe / Idempotent**
     + Safe : 서버 상태 변경 X
     + Idempotent(멱등성) : 같은 요청을 여러 번 보내도 결과가 같게 유지되는 성질 (GET, PUT, DELETE)
         + **네트워크 장애** 등으로 요청이 중복될 될 수 있는데 **멱등성을 보장**하면 **서버 상태가 꼬이지 않음**


 + **상태코드**
     + **1xx (정보, Informational)** : 
         + 요청을 받았고, 계속 진행 중이라는 의미
         + 예시 :
             + `100 Continue` : 요청의 일부만 받고 계속 진행
             + `101 Switching Protocols` : 프로토콜 전환 (ex : HTTP -> WebSocket)

     + **2xx (성공, Success)** :
         + 요청이 정상적으로 처리됨
         + 예시 : 
             + `200 OK` : 성공(GET,PUT,DELETE 등)
             + `201 Created` : 리소스가 성공적으로 생성됨 (POST 성공시 자주 사용)
             + `204 No Content` : 성공했지만 응답 본문 없음 (DELETE 성공 시 주로 사용)

     + **3xx(리다이렉션, Redirection)** :
         + 요청한 리소스가 다른 곳에 있음을 알려줌
         + 예시 : 
             + `301 Moved Permanently` : 요청한 자원이 영구적으로 다른 위치로 이동
             + `302 Found` : 일시적 리다이렉션
             + `304 Not Modified` : 캐시 사용 (변경 없음)

     + **4xx(클라이언트 오류, Client Error)** :  
         + 클라이언트의 잘못된 요청
         + 예시
             + `400 Bad Reqeust` : 잘못된 요청(파라미터 문제 등)
             + `401 Unauthorized` : 인증 필요(로그인 필요)
             + `403 Forbidden` : 권한 없음(인증은 했지만 접근 불가)
             + `404 Not Found` : 요청한 자원 없음
             + `409 Conflict` : 리소스 충돌

     + **5xx(서버 오류, Server Error)** : 
         + 서버에서 요청을 처리하다가 문제 발생
         + 예시 :
             + `500 Internal Server Error` : 일반적 서버 오류
             + `502 Bad Gateway` : 게이트웨이/프록시 서버가 잘못된 응답 받음
             + `503 Server Unavailable` : 서버 과부하/점검 중
             + `504 Gateway Timeout` : 게이트웨이/프록시가 응답을 기다리다 시간 초과

---

## 2. HTTPS(HTTP Secure)
 + HTTP + TLS/SSL로 암호화된 통신

 + **구성**
     + **TLS/SSL** : 인터넷에서 데이터를 안전하게 주고받게 해주는 프로토콜
         + 특징 : 
             1. **암호화 (Encryption)**
                 + 데이터를 평문(plain text) 대신 암호화된 상태로 전송
                 + 중간에서 패킷을 가로채도 내용을 볼 수 없음
                 + 예: 비밀번호, 카드번호 보호

             2. **무결성 (Integrity)**
                 + 전송 중에 데이터가 변조되지 않았음을 보장
                 + 해시(MAC, HMAC)를 사용 → 받은 데이터가 원본 그대로인지 확인

             3. **인증 (Authentication)**
                 + 서버(그리고 필요하면 클라이언트) 신원을 보장
                 + 인증서(Certificate)를 통해 내가 접속한 서버가 진짜 서버인지 확인

         + **동작 방식 (Handshake)**
             1. **클라이언트 -> 서버**
                 + HTTPS 연결을 위해 접속 시도

             2. **서버 -> 클라이언트**
                 + 인증서와 공개키 전달
                 + 서버 인증서 안에 서버 공개키 포함

             3. **클라이언트 인증서 검증**
                 + 유효한 CA(인증기관)에서 발급되었는지 확인

             4. **키 교환(대칭키 공유)**
                 + 공개키 암호화(RSA, ECDHE 등)를 이용해서 비밀키(대칭키) 안전하게 교환

             5. **대칭키 암호화 통신 시작**
                 + 빠른 대칭키 암호화(AES 등)를 사용해서 모든 데이터를 암호화

---

## 3. REST(Representational State Transfer)
 + HTTP를 기반으로 **자원(Resource)**을 URI로 표현하고, CRUD를 HTTP 메서드로 처리하는 아키텍쳐 스타일
 + HTTP를 이용하는 규칙

 + 특징 :
     + stateless
     + URI로 자원표현
     + HTTP 메서드로 CRUD
     + JSON/XML 데이터 주로 사용

 + 예시 :
     + GET `/users/1` -> 사용자 조회
     + POST `/users` -> 사용자 생성
     + PUT `/users/1` -> 사용자 전체 수정
     + DELETE `/users/1` -> 사용자 삭제


 + **JSON** 
     + 키-값 쌍으로 데이터를 표현하는 텍스트 포맷
     
     + 특징:
         + 가벼움, 가독성 좋음
         + 언어 독립적
         + API 요청/응답 표준
     
     + 예시
     > ```json
     >{
     >  "id": 1,
     >  "name": "홍길동",
     >  "email": "hong@test.com"
     >}
     > ```

     + Spring 예시 : `@RequestBody`, `@ResponseBody` -> JSON 직렬화/역직렬화
         + **`@RequestBody`**   
             + 클라이언트가 보낸 HTTP요청의 Body를 자바 객체로 변환해주는 역할
             > ```java
             > @PostMapping("/users")
             > public ResponseEntity<String> createUser(@RequestBody User user) {
             >     // 클라이언트가 보낸 JSON → User 객체로 변환
             >     userService.save(user);
             >     return ResponseEntity.ok("User created");
             > }
             > ```

         + **`@ResponseBody`**
             + 컨트롤러에서 반환하는 자바 객체를 HTTP 응답의 Body로 변환
             > ```java
             > @GetMapping("/users/{id}")
             > @ResponseBody
             > public User getUser(@PathVariable Long id) {
             >     // DB에서 조회한 User 객체를 JSON으로 반환
             >     return userService.findById(id);
             > }
             > ```

 + **REST API**
     + REST 원칙을 따르는 API
     + HTTP를 기반으로 데이터를 주고받는 모든 API를 REST라고 부를 수 있음
     + 꼭 모든 REST 제약 조건을 지킬 필요는 없음

 + **RESTful API**
     + REST 원칙을 실제로 구현한 API
     + 웹에서 데이터를 주고받을 때 REST 아키텍쳐 규칙을 지킨 API
     > ```java
     > @RestController
     > @RequestMapping("/users")
     > public class UserController {
     > 
     >     @GetMapping("/{id}")
     >     public User getUser(@PathVariable int id) {
     >         return userService.getUser(id);
     >     }
     > 
     >     @PostMapping
     >     public User createUser(@RequestBody User user) {
     >         return userService.createUser(user);
     >     }
     > 
     >     @PutMapping("/{id}")
     >     public User updateUser(@PathVariable int id, @RequestBody User user) {
     >         return userService.updateUser(id, user);
     >     }
     > 
     >     @DeleteMapping("/{id}")
     >     public void deleteUser(@PathVariable int id) {
     >         userService.deleteUser(id);
     >     }
     > }
     > ```

     + 주요 특징 
         + **자원 중심 설계**
             + URI는 명사로, 행위는 HTTP 메서드로 표현 

         + **HTTP 메서드 적절히 사용**
             + GET: 조회, POST: 생성, PUT/PATCH: 수정, DELETE: 삭제

         + **상태 비저장**
             + 서버가 클라이언트 상태를 저장하지 않음
             + 요청마다 인증 정보 포함

         + **표준 상태 코드 활용**
             + 200, 201, 204, 400, 404, 500 등

         + **표현 사용**
             + JSON, XML 등 표준 형식으로 데이터 교환
---

## 4. 클라이언트/서버 상태 관리
 + **쿠키(Cookie)** : 클라이언트 저장, 요청마다 서버 전송
 + **세션(Session)** : 서버 저장, 쿠키/URL로 식별
     + 주로 쿠키는 세션아이디를 저장하는 용도로 쓰이며, 이 세션아이디를 서버에서 조회해 실제 데이터를 얻는 형식으로 사용함
 + **JWT(JSON Web Token)** : 토큰 기반, stateless 인증


---

# 서버(Server / WAS)

## 1. 웹 서버(Web Server)
 + HTTP 요청 처리 + 정적 컨텐츠 제공
 
 + **예시** : Apache, Nginx
 
 + **역할**
     1. HTTP 요청 수신
     2. 정적 파일 제공
     3. 요청 로그 기록
     4. WAS와 연동(프록시 역할)

---

## 2. WAS(Web Application Server)
 + 동적 컨텐츠 처리 + 비즈니스 로직 수행
 
 + **예시** : Tomcat, Jetty, JBoss
 
 + **역할**
     1. HTTP 요청을 서블릿(Servlet) 실행
     2. DB 연동, 트랜잭션 처리
     3. Java EE(Web + EJB) 지원
 
 + **요청 흐름**
     ```css
     클라이언트 요청 → 웹서버 → WAS → 컨트롤러 → 서비스 → DAO/Repository → DB → 응답 JSON/HTML
     ```

 + **톰캣(Tomcat) 구조**
     + **서블릿 컨테이너** : Java 기반 WAS
     + **구성 요소**
         1. **Connector** : 
             + 클라이언트(웹 브라우저)와 톰캣 서버 간의 통신 담당
             + 기능 : 
                 + HTTP 요청 수신
                 + 요청을 Request 객체로 변환
                 + Resposne 객체로 응답 반환
                 
         2. **Engine** : 
             + 톰캣의 핵심 처리 장치, 전체 요청 처리 흐름 관리
             + 기능 : 
                 + 여러 Host(도메인) 관리
                 + 요청을 Host 단위로 라우팅

         3. **Host** : 
             + 도메인 단위 컨텍스트 관리
             + 기능 : 
                 + 도메인 이름을 기준으로 Context(웹 애플리케이션) 라우팅
                 + 여러 도메인 관리 기능

         4. **Context** : 
             + 웹 애플리케이션 단위 관리 (`WEB-INF/web.xml`)
             + 기능 : 
                 + 특정 URL 패턴과 Servlet 매핑
                 + 해당 애플리케이션의 설정 관리

         5. **Servlet** : 
             + 실제 비즈니스 로직 처리
             + 기능 : 
                 + 클라이언트 요청을 받아 처리
                 + Response 생성
                 + JSP/HTML 출력 가능

         6. **Session 관리** : HttpSession 제공, 상태 관리

 + **프론트엔드 연계**
     + **REST API 호출** : fetch, Axios, jQuery, AJAX
     
     + **JSON 데이터 송수신**
     > ```javascript
     > fetch('/users/1')
     >   .then(res => res.json())
     >   .then(data => console.log(data));
     > ```

     + **상태 관리**
         + 쿠키, 세션, JWT 비교 및 특징 이해