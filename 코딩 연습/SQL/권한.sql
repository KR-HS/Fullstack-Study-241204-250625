SELECT * FROM HR.EMPLOYEES;


-- 사용자 계정 확인
SELECT * FROM ALL_USERS;

-- 현재 사용자의 권한 확인
SELECT * FROM USER_SYS_PRIVS;

-- 사용자 계정을 생성 (관리자만 할 수 있음)
CREATE USER USER01 IDENTIFIED BY USER01;

-- 데이터 베이스에 접속하려면 접속권한
-- 테이블을 생성하려면 테이블 생성권한
-- 뷰생성을 하려면 뷰 생성권한
-- 시퀀스를 생성하려면 시퀀스 생성권한
-- 프로시저 생성하려면 프로시저 생성권한

-- GRANT 권한명 TO 계정명;
GRANT CREATE SESSION,CREATE TABLE, CREATE VIEW, CREATE SEQUENCE,CREATE PROCEDURE
TO USER01;

-- 테이블 스페이스 - 테이블에 데이터가 저장되는 물리적인 공간
ALTER USER USER01 DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

-- 권한 회수 : REVOKE ~ FROM
REVOKE CREATE SESSION FROM USER01;

DROP USER USER01 CASCADE; -- 계정이 테이블과 데이터를 가지고 있으면 , 테이블 포함해서 삭제가 일어남