-- 인덱스 ( 검색을 빠르게 하는 힌트 역할)

-- INDEX의 종류로는 고유인덱스, 비고유인덱스가 있음
-- 고유인덱스(PK,UK)를 만들 때 자동으로 생성되는 인덱스
-- 비고유인덱스는 일반컬럼에 지정해서 조회를 빠르게 할 수 있는 인덱스
-- 단, INDEX는 조회를 빠르게 하지만, 무작위하게 많이 사용되면 오히려 성능저하를 나타낼 수도 있음
-- 주로 사용되는 컬럼에서 SELECT절이 속도저하가 있으면, 일단 먼저 고려해볼 사항이 인덱스.

DROP TABLE EMPS;
CREATE TABLE EMPS AS (SELECT * FROM EMPLOYEES);

--
SELECT * FROM EMPS WHERE FIRST_NAME = 'Nancy';

-- FIRST_NAME컬럼에 인덱스 부착
CREATE INDEX EMPS_IDX ON EMPS(FIRST_NAME);
SELECT * FROM EMPS WHERE FIRST_NAME = 'Nancy';

-- 인덱스 삭제 ( 삭제 하더라도 테이블에 영향을 미치지 않음)
DROP INDEX EMPS_IDX;

-- 결합 인덱스( 여러 컬럼을 묶어서 생성할 수 있음)
CREATE INDEX EMPS_IDX ON EMPS(FIRST_NAME,LAST_NAME);

SELECT * FROM EMPS WHERE FIRST_NAME ='Nancy'; -- 인덱스 힌트를 받음
SELECT * FROM EMPS WHERE FIRST_NAME = 'Nancy' AND LAST_NAME = 'Greenberg'; -- 인덱스 힌트를 받음
SELECT * FROM EMPS WHERE LAST_NAME = 'Greenberg'; -- 인덱스 힌트를 못받음

-- 고유 인덱스
CREATE UNIQUE INDEX 인덱스명 ON 테이블명(부착할 컬럼) ; -- PK,UK만들때 자동 생성(PK,UK 기반으로 조회할 때 인덱스 효과를 받음)

SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = 100;