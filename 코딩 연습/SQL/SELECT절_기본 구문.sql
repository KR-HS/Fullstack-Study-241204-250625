SELECT * FROM EMPLOYEES;

SELECT * FROM DEPARTMENTS;
SELECT * FROM LOCATIONS;
SELECT * FROM JOBS;
-- 특정 컬럼만 조회하려면, 나열
SELECT EMPLOYEE_ID, FIRST_NAME,PHONE_NUMBER FROM EMPLOYEES; 
-- 문자, 날짜는 왼쪽으로 표시, 숫자는 오른쪽에 나타남
SELECT FIRST_NAME,HIRE_DATE,SALARY,COMMISSION_PCT FROM EMPLOYEES;
-- 숫자컬럼은 * / + - 가 됨
SELECT FIRST_NAME ,SALARY, SALARY + SALARY*0.1 AS NEW_SALARY FROM EMPLOYEES;
-- 컬럼 별칭 ALIAS
SELECT FIRST_NAME AS 이름 , SALARY 급여, SALARY + SALARY*0.1 "최종 급여" FROM EMPLOYEES;
-- 문자열 붙이기
SELECT first_name || ' ' || last_name || '''s salary is $' || salary FROM EMPLOYEES;
-- DISTINCT - 중복제거
SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES;
SELECT DISTINCT FIRST_NAME, DEPARTMENT_ID FROM EMPLOYEES; -- 조회된 데이터 기준으로 중복 제거
-- ROWID(데이터 주소), ROWNUM(데이터 조회된 순서)
SELECT EMPLOYEE_ID, FIRST_NAME, ROWID, ROWNUM FROM EMPLOYEES;