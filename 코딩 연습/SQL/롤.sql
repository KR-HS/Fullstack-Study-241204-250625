-- 롤을 이용한 권한부여
CREATE USER USER01 IDENTIFIED BY USER01;
GRANT RESOURCE, CONNECT TO USER01; // 리소스롤 (테이블 ,뷰 시퀀스, 프로시저 등의 권한 그룹);
ALTER USER USER01 DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

DROP USER USER01K;

-----------------------------------------
 -- 계정 생성과 권한부여를 마스크로
 -- 보기 탭 - DBA클릭