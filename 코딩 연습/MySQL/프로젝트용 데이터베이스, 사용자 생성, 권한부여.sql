# 모든 IP 접속 허용
CREATE USER 'project'@'%' IDENTIFIED BY 'project';

#사용자 계정조회
SELECT user, host FROM mysql.user;

# 스키마생성(데이터베이스)
CREATE SCHEMA `project` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

# 권한부여
GRANT ALL PRIVILEGES ON project.* TO 'project'@'%';