# 테이블생성
## 유저 테이블(기사, 학부모)
CREATE TABLE USER (
	USER_KEY	INT	PRIMARY KEY AUTO_INCREMENT,
	USER_ID	VARCHAR(20)	UNIQUE,
	USER_PW	VARCHAR(20)	NOT NULL,
	USER_NAME	VARCHAR(30)	NOT NULL,
	USER_BIRTH	VARCHAR(30)	NOT NULL,
	USER_POSTCODE	VARCHAR(100) NOT NULL, # USER_TYPE에 따라 유치원주소, 거주지주소로 쓰임
	USER_ADDRESS	VARCHAR(1000) NOT NULL,
	USER_ADDRESS_DETAIL	VARCHAR(1000),
	USER_TYPE	CHAR NOT NULL CHECK(USER_TYPE IN('U','D')),
	USER_PHONE	VARCHAR(100),
    USER_REGDATE TIMESTAMP DEFAULT NOW()
);


## 자녀 테이블
CREATE TABLE CHILDREN (
	CHILD_KEY	INT	PRIMARY KEY AUTO_INCREMENT,
	CHILD_NAME	VARCHAR(30)	NOT NULL,
	CHILD_BIRTH	VARCHAR(30)	NOT NULL,
	CHILD_GENDER CHAR NOT NULL CHECK(CHILD_GENDER IN ('M','F')),
	PARENT_KEY	INT	NOT NULL  # 부모 테이블의 유저키
);



#유치원 테이블
CREATE TABLE KINDER (
	KINDER_KEY	INT PRIMARY KEY AUTO_INCREMENT,
	KINDER_NAME	VARCHAR(100) NOT NULL,
    KINDER_PHONE VARCHAR(100) NOT NULL,
    KINDER_POSTCODE VARCHAR(50) NOT NULL,
	KINDER_ADDRESS	VARCHAR(500) NOT NULL,
	KINDER_OPEN_TIME	VARCHAR(20)	,
	KINDER_CLOSE_TIME	VARCHAR(20)	,
	KINDER_WEEKEND_OPEN	CHAR DEFAULT 'N' CHECK(KINDER_WEEKEND_OPEN IN('Y','N')),
    KINDER_NIGHT_OPEN CHAR DEFAULT 'N' CHECK(KINDER_NIGHT_OPEN IN ('Y','N')),
    KINDER_CAPACITY INT
);


#파일 테이블
CREATE TABLE FILES (
	FILE_KEY	INT	PRIMARY KEY AUTO_INCREMENT,
	FILE_NAME	VARCHAR(1000) NOT NULL,
    FILE_PATH 	VARCHAR(1500) NOT NULL,
    FILE_UUID	VARCHAR(1500) NOT NULL,
	FILE_REGDATE	TIMESTAMP	NULL,
	CHILD_KEY	INT	, # 자녀 아이디
	KINDER_KEY	INT	, # 어린이집 아이디
	USER_KEY	INT	# 유저 아이디
);

# 어린이집, 자녀 매칭 테이블 (어떤 아이가 어떤 유치원에 다니고있는가)
CREATE TABLE KINDERMATCH(
	KM_KEY INT PRIMARY KEY AUTO_INCREMENT,
    KM_PICKUP CHAR default 'Y' CHECK(KM_PICKUP IN ('Y','N')),
    CHILD_KEY INT NOT NULL,
    KINDER_KEY INT NOT NULL default 1
);


# 운행정보 테이블
CREATE TABLE RECORD(
	RECORD_KEY INT PRIMARY KEY AUTO_INCREMENT,
    RECORD_NAME VARCHAR(100),
    RECORD_CAR_NAME VARCHAR(100),
    RECORD_START_TIME TIMESTAMP DEFAULT NOW(), # 운행시작시간
    RECORD_END_TIME TIMESTAMP , # 운행종료시간
    RECORD_STATE CHAR DEFAULT 'P' CHECK(RECORD_STATE IN ('P','S','E')), # P = 예정(PLAN), S = 진행중(START), E = 종료(END)
    DRIVER_KEY INT NOT NULL
);


# 운행정보 -  (어린이집, 자녀 매칭 테이블) 매칭 테이블
CREATE TABLE RECORDMATCH(
	RM_KEY INT PRIMARY KEY AUTO_INCREMENT,
    KM_KEY INT NOT NULL,
    RECORD_KEY INT NOT NULL
);


CREATE TABLE LOCATION(
	LOCATION_KEY INT PRIMARY KEY AUTO_INCREMENT,
    LATITUDE VARCHAR(200) NOT NULL,
    LONGITUDE VARCHAR(200) NOT NULL,
    LOCATION_REGTIME TIMESTAMP DEFAULT NOW(),
    RECORD_KEY INT,
    USER_KEY INT,
    KINDER_KEY INT
);
select * from kinder;

select * from location;




	
#-----------------------------------------------------------------------------------------------------------------
# 테이블삭제
## 유저테이블삭제
DROP TABLE USER;
## 자녀 테이블삭제
DROP TABLE CHILDREN;
## 유치원 테이블 삭제
DROP TABLE KINDER;
## 파일 테이블 삭제
DROP TABLE FILES;
## 자녀- 유치원 매치 테이블 삭제
DROP TABLE KINDERMATCH;
## 운행정보 테이블삭제
DROP TABLE RECORD;
## 운행정보 -  (어린이집, 자녀 매칭 테이블) 매칭 테이블 삭제
DROP TABLE RECORDMATCH;
## 위치 테이블 삭제
DROP TABLE LOCATION;



#---------------------------------------------------------------------------------------------------------------------
# 데이터삽입 
## 유저테이블
INSERT INTO USER(USER_ID,USER_PW,USER_NAME,USER_BIRTH,USER_POSTCODE,USER_ADDRESS,USER_ADDRESS_DETAIL,USER_TYPE,USER_PHONE)
VALUES('aaa123','aaa123','관리자','1998-10-30','13333','서울시 강남구 강남대로','세부주소임','U','01012345678');

## 자녀테이블
insert into CHILDREN(child_name, child_birth,child_gender,parent_key)
VALUES('푸름','2008-03-20','F',1);
insert into CHILDREN(child_name, child_birth,child_gender,parent_key)
VALUES('하얀','2004-03-20','M',1);


## 유치원 테이블
INSERT INTO KINDER (
    KINDER_NAME, KINDER_PHONE,KINDER_POSTCODE, KINDER_ADDRESS,
    KINDER_OPEN_TIME, KINDER_CLOSE_TIME,
    KINDER_WEEKEND_OPEN, KINDER_NIGHT_OPEN,KINDER_CAPACITY
) VALUES
('햇살유치원','02-1234-5869', '04524', '서울 중구 다산로 123', '08:00', '18:00', 'N', 'N',100),

('무지개유치원','02-1234-4442', '05555', '서울 송파구 올림픽로 321', '07:30', '19:00', 'Y', 'Y',50),

('별빛유치원','02-1234-3928', '06110', '서울 강남구 테헤란로 45', '09:00', '17:30', 'N', 'Y',30),

('하늘유치원','02-1234-1728', '04098', '서울 마포구 월드컵북로 100', '08:30', '18:30', 'Y', 'N',38),

('푸른숲유치원','02-1234-4756', '08826', '서울 관악구 관악로 204', '07:50', '18:10', 'N', 'N',49);

## 유치원- 자녀 매칭테이블
### 푸름 - 별빛유치원
INSERT INTO KINDERMATCH(KM_PICKUP,CHILD_KEY,KINDER_KEY)
VALUES('Y',1,3);
INSERT INTO KINDERMATCH(KM_PICKUP,CHILD_KEY,KINDER_KEY)
VALUES('N',2,4);





#------------------------------------------------------------------------------------------------------
# 중복체크
## 유저테이블
select count(*) from user where user_id='aaa123';

#--------------------------------------------------------------------------------------------------------------
# 전체조회
## 유저테이블
select * from user;
select * from children;
select * from files;
# 부분조회
## 자녀 조회( 유치원 정보 합쳐서)
select c.*,k.*
        from children c
        left join kindermatch km
        on c.child_key=km.child_key
        left join kinder k
        on km.kinder_key=k.kinder_key
        where c.parent_key=1;

select * from kinder;






#---------------------------------
#--------------------------------------

INSERT INTO CHILDREN (CHILD_KEY, CHILD_NAME, CHILD_BIRTH, CHILD_GENDER, PARENT_KEY) VALUES
(1, '푸름', '2008-03-20', 'F', 1),
(2, '하얀', '2004-03-20', 'M', 1),
(3, '미니종범', '2025-04-02', 'M', 3),
(4, '메롱이', '2004-03-20', 'M', 4),
(5, '손유경', '2004-03-20', 'F', 5),
(6, '박종범', '2004-03-20', 'M', 2);


INSERT INTO RM (RM_KEY, KM_KEY, RECORD_KEY, DROP_STATE) VALUES
(1, 3, 2, '하차완료'),
(2, 1, 2, '하차완료'),
(3, 4, 2, '하차완료'),
(4, 5, 3, '하차완료'),
(5, 6, 3, '하차'),
(6, 2, 1, '하차');

INSERT INTO RECORD (RECORD_KEY, RECORD_NAME, RECORD_CAR_NAME, RECORD_START_TIME, RECORD_END_TIME, RECORD_STATE, DRIVER_KEY) VALUES
(1, '오전 동대문구 1노선', '123가 3000 금왕이차량', '2025-04-21 15:19:15', NULL, 'E', 2),
(2, '오전 동대문구 2노선', '123가 4000 고양이차량', '2025-04-21 15:19:15', NULL, 'S', 2),
(3, '오후 동대문구 3노선', '123가 5000 벤츠차량', '2025-04-21 15:19:15', NULL, 'P', 2);



INSERT INTO KINDERMATCH (KM_KEY, KM_PICKUP, CHILD_KEY, KINDER_KEY) VALUES
(1, 'Y', 1, 2),
(2, 'N', 2, 4),
(3, 'Y', 3, 2),
(4, 'Y', 4, 2),
(5, 'Y', 5, 5),
(6, 'Y', 6, 5);

INSERT INTO USER (
    USER_KEY, USER_ID, USER_PW, USER_NAME, USER_BIRTH, USER_POSTCODE,
    USER_ADDRESS, USER_ADDRESS_DETAIL, USER_TYPE, USER_PHONE, USER_REGDATE
) VALUES
(1, 'aaa123', 'aaa123', '관리자', '1998-10-30', '13333', '서울 송파구 장지동 362-2', '서울송례초등학교', 'U', '01012345678', '2025-04-21 09:48:10'),
(2, 'aaa', '123', '박종범', '960226', '13839', '경기 하남시 위례순환로 310', '204동', 'D', '01093007221', '2025-04-21 09:49:40'),
(3, 'qwer', '1234', '박종범', '960226', '13839', '경기 하남시 위례순환로 310', '204동', 'U', '01093007221', '2025-04-21 09:54:51'),
(4, 'qqqq', 'qwer', '박종범', '2025-04-02', '13543', '경기 하남시 위례순환로 53', '위례초본관 53', 'U', '01093007221', '2025-04-21 10:21:14'),
(5, 'driver01', 'driver01', 'driver01', '2025-04-10', '25464', '서울특별시 강남구 밤고개로 99', '수서역', 'U', '01011111111', '2025-04-21 10:56:05');