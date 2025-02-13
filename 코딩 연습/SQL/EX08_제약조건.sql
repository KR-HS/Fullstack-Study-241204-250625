--문제1.
--
--다음과 같은 테이블을 생성하고 데이터를 insert해보세요.
--테이블 제약조건은 아래와 같습니다. 
--조건) M_NAME 는 가변문자형 20byte, 널값을 허용하지 않음
--조건) M_NUM 은 숫자형 5자리, PRIMARY KEY 이름(mem_memnum_pk) 
--조건) REG_DATE 는 날짜형, 널값을 허용하지 않음, UNIQUE KEY 이름:(mem_regdate_uk)
--조건) SALARY 숫자형 10자리, CHECK제약 (0 보다 크다)
--조건) LOCA 숫자형 4자리, FOREIGN KEY – 참조 locations테이블(location_id) 이름:(mem_loca_loc_locid_fk)
--
CREATE TABLE MEMBER(
    M_NAME VARCHAR2(20) NOT NULL,
    M_NUM NUMBER(5),
    REG_DATE DATE NOT NULL,
    SALARY NUMBER(10),
    LOCA NUMBER(4),
    CONSTRAINT MEM_MEMNUM_PK PRIMARY KEY(M_NUM),
    CONSTRAINT MEM_REGDATE_UK UNIQUE(REG_DATE),
    CONSTRAINT MEM_SALARY_CK CHECK(SALARY>0),
    CONSTRAINT MEM_LOCA_LOC_LOCID_FK FOREIGN KEY(LOCA) REFERENCES LOCATIONS(LOCATION_ID)
);

INSERT INTO MEMBER
VALUES('AAA',10,SYSDATE,100000,(SELECT LOCATION_ID FROM LOCATIONS WHERE CITY='ROMA'));




--문제2.
--도서테이블, 도서 대여 이력 테이블을 생성하려 합니다.
--도서 테이블은
--도서번호(문자) PK, 도서명(문자), 출판사(문자), 입고일(날짜)
--도서 대여 이력 테이블은
--대여번호(숫자) PK, 도서번호(문자) FK, 대여일(날짜), 반납일(날짜), 반납여부(Y/N)
--를 가집니다.
--적절한 테이블을 생성해 보세요.