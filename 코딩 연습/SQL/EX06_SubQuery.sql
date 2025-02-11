--문제 1.
--EMPLOYEES 테이블에서 모든 사원들의 평균급여보다 높은 사원들을 데이터를 출력 하세요 ( AVG(컬럼) 사용)
--EMPLOYEES 테이블에서 모든 사원들의 평균급여보다 높은 사원들을 수를 출력하세요
--EMPLOYEES 테이블에서 job_id가 IT_PFOG인 사원들의 평균급여보다 높은 사원들을 데이터를 출력하세요.
SELECT *
FROM EMPLOYEES
WHERE SALARY>(SELECT AVG(SALARY) FROM EMPLOYEES);

SELECT COUNT(*) 사원수
FROM EMPLOYEES
WHERE SALARY>(SELECT AVG(SALARY) FROM EMPLOYEES);

SELECT *
FROM EMPLOYEES
WHERE SALARY>(SELECT AVG(SALARY) FROM EMPLOYEES WHERE JOB_ID='IT_PROG');


--문제 2.
--DEPARTMENTS테이블에서 manager_id가 100인 사람의 department_id(부서아이디) 와
--EMPLOYEES테이블에서 department_id(부서아이디) 가 일치하는 모든 사원의 정보를 검색하세요.
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE MANAGER_ID=100);

--문제 3.
--EMPLOYEES테이블에서 “Pat”의 manager_id보다 높은 manager_id를 갖는 모든 사원의 데이터를 출력하세요
SELECT * 
FROM EMPLOYEES 
WHERE MANAGER_ID > (SELECT MANAGER_ID FROM EMPLOYEES WHERE FIRST_NAME='Pat');
--EMPLOYEES테이블에서 “James”(2명)들의 manager_id와 같은 모든 사원의 데이터를 출력하세요.
SELECT * 
FROM EMPLOYEES 
WHERE MANAGER_ID IN (SELECT MANAGER_ID FROM EMPLOYEES WHERE FIRST_NAME='James');
--Steven과 동일한 부서에 있는 사람들을 출력해주세요.
SELECT * 
FROM EMPLOYEES 
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE FIRST_NAME='Steven');
--Steven의 급여보다 많은 급여를 받는 사람들은 출력하세요.
SELECT * 
FROM EMPLOYEES 
WHERE SALARY > ANY (SELECT SALARY FROM EMPLOYEES WHERE FIRST_NAME='Steven');


--문제 4.
--EMPLOYEES테이블 DEPARTMENTS테이블을 left 조인하세요
--조건) 직원아이디, 이름(성, 이름), 부서아이디, 부서명 만 출력합니다.
--조건) 직원아이디 기준 오름차순 정렬
SELECT E.EMPLOYEE_ID 직원아이디, CONCAT(FIRST_NAME,CONCAT(' ',LAST_NAME)) 이름, D.DEPARTMENT_ID 부서아이디, DEPARTMENT_NAME 부서명
FROM EMPLOYEES E
LEFT JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
ORDER BY 직원아이디;
--
--문제 5.
--문제 4의 결과를 (스칼라 쿼리)로 동일하게 조회하세요
SELECT E.EMPLOYEE_ID 직원아이디,
       CONCAT(FIRST_NAME,CONCAT(' ',LAST_NAME)) 이름,
       E.DEPARTMENT_ID 부서아이디,
       (SELECT DEPARTMENT_NAME 부서명 FROM DEPARTMENTS D WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID) 부서명
FROM EMPLOYEES E
ORDER BY 직원아이디;

--
--문제 6.
--DEPARTMENTS테이블 LOCATIONS테이블을 left 조인하세요
--조건) 부서아이디, 부서이름, 스트릿_어드레스, 시티 만 출력합니다
--조건) 부서아이디 기준 오름차순 정렬

SELECT DEPARTMENT_ID 부서아이디, DEPARTMENT_NAME 부서명, STREET_ADDRESS 스트릿_어드레스,CITY 시티
FROM DEPARTMENTS D
LEFT JOIN LOCATIONS L
ON D.LOCATION_ID = L.LOCATION_ID
ORDER BY DEPARTMENT_ID;

--
--문제 7.
--문제 6의 결과를 (스칼라 쿼리)로 동일하게 조회하세요
SELECT DEPARTMENT_ID 부서아이디,
       DEPARTMENT_NAME 부서명,
       (SELECT STREET_ADDRESS FROM LOCATIONS L WHERE L.LOCATION_ID = D.LOCATION_ID)스트릿_어드레스,
       (SELECT CITY FROM LOCATIONS L WHERE D.LOCATION_ID = L.LOCATION_ID) 시티
FROM DEPARTMENTS D
ORDER BY DEPARTMENT_ID;
--
--문제 8.
--LOCATIONS테이블 COUNTRIES테이블을 스칼라 쿼리로 조회하세요.
--조건) 로케이션아이디, 주소, 시티, country_id, country_name 만 출력합니다
--조건) country_name기준 오름차순 정렬
--

SELECT LOCATION_ID,STREET_ADDRESS, CITY,COUNTRY_ID,(SELECT COUNTRY_NAME FROM COUNTRIES C WHERE L.COUNTRY_ID = C.COUNTRY_ID) COUNTRY_NAME
FROM LOCATIONS L
ORDER BY COUNTRY_NAME;

----------------------------------------------------------------------------------------------------
--문제 9.
--EMPLOYEES테이블 에서 first_name기준으로 내림차순 정렬하고, 41~50번째 데이터의 행 번호, 이름을 출력하세요
SELECT 행번호,이름
FROM (SELECT ROWNUM 행번호,FIRST_NAME 이름
      FROM (SELECT FIRST_NAME
            FROM EMPLOYEES
            ORDER BY FIRST_NAME DESC))
WHERE 행번호>40 AND 행번호<=50;
--
--문제 10.
--EMPLOYEES테이블에서 hire_date기준으로 오름차순 정렬하고, 31~40번째 데이터의 행 번호, 사원id, 이름, 번호, 
--입사일을 출력하세요.
SELECT 행번호,사원ID,이름,번호,입사일
FROM (SELECT ROWNUM 행번호,사원ID,이름,번호,입사일
      FROM (SELECT EMPLOYEE_ID 사원ID,FIRST_NAME 이름,ROWNUM 번호,HIRE_DATE 입사일
            FROM EMPLOYEES
            ORDER BY HIRE_DATE DESC))
WHERE 행번호>30 AND 행번호<=40;


--
--문제 11.
--COMMITSSION을 적용한 급여를 새로운 컬럼으로 만들고, 이 데이터에서 10000보다 큰 사람들을 뽑아 보세요. (인라인뷰를 쓰면 됩니다)
SELECT *
FROM (SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,
             SALARY+SALARY*NVL(COMMISSION_PCT,0) 새급여,
             COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID
      FROM EMPLOYEES) 
WHERE 새급여>10000;


