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

--문제 12.
--조인의 최적화
--SELECT CONCAT(FIRST_NAME, LAST_NAME) AS NAME,
--       D.DEPARTMENT_ID
--FROM EMPLOYEES E
--JOIN DEPARTMENTS D
--ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
--WHERE EMPLOYEE_ID = 200;
--
--이론적으로 위 구문의 실행방식은 EMPLOYEES - DEPARTMENTS 테이블을 먼저 조인하고, 후에 WHERE조건을 실행하게 됩니다.
--항상 이런것은 아닙니다. (이것은 데이터베이스 검색엔진(옵티마이저)에 의해 바뀔 수도 있습니다)
--그렇다면 SUBQUERY절로 WHERE구문을 작성하고, JOIN을 붙이는 것도 가능하지 않을까요?
--
--=> 부서아이디가 200인 데이터를 인라인뷰로 조회한 후에 JOIN을 붙여보세요.
SELECT NAME,
       D.DEPARTMENT_ID
FROM (SELECT EMPLOYEE_ID,CONCAT(FIRST_NAME, LAST_NAME) AS NAME,DEPARTMENT_ID
      FROM EMPLOYEES
      WHERE EMPLOYEE_ID = 200) E
JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;

--문제13
--EMPLOYEES테이블, DEPARTMENTS 테이블을 left조인하여, 입사일 오름차순 기준으로 10-20번째 데이터만 출력합니다.
--조건) rownum을 적용하여 번호, 직원아이디, 이름, 입사일, 부서이름 을 출력합니다.
--조건) hire_date를 기준으로 오름차순 정렬 되어야 합니다. rownum이 망가지면 안되요.
SELECT *
FROM (SELECT ROWNUM NO,
             EMPLOYEE_ID,
             CONCAT(FIRST_NAME,CONCAT(' ',LAST_NAME)) NAME,
             HIRE_DATE,
             DEPARTMENT_NAME
      FROM (SELECT *
            FROM EMPLOYEES E
            LEFT JOIN DEPARTMENTS D
            ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
            ORDER BY HIRE_DATE)
)
WHERE NO BETWEEN 10 AND 20;

--문제14
--SA_MAN 사원의 급여 내림차순 기준으로 ROWNUM을 붙여주세요.
--조건) SA_MAN 사원들의 ROWNUM, 이름, 급여, 부서아이디, 부서명을 출력하세요.

SELECT ROWNUM,
       NAME,
       SALARY,
       DEPARTMENT_ID,
       DEPARTMENT_NAME
FROM (SELECT CONCAT(FIRST_NAME,CONCAT(' ',LAST_NAME))NAME,
             SALARY,
             DEPARTMENT_ID,
             (SELECT DEPARTMENT_NAME 
              FROM DEPARTMENTS D 
              WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID) DEPARTMENT_NAME
      FROM EMPLOYEES E
      WHERE JOB_ID='SA_MAN'
      ORDER BY SALARY DESC
);
--문제15
--DEPARTMENTS테이블에서 각 부서의 부서명, 매니저아이디, 부서에 속한 인원수 를 출력하세요.
--조건) 인원수 기준 내림차순 정렬하세요.
--조건) 사람이 없는 부서는 출력하지 뽑지 않습니다.
--힌트) 부서의 인원수 먼저 구한다. 이 테이블을 조인한다.
SELECT D.DEPARTMENT_NAME,MANAGER_ID,사원수 
FROM DEPARTMENTS D,
     (SELECT DEPARTMENT_NAME,COUNT(*) 사원수
      FROM (SELECT *
            FROM DEPARTMENTS D
            LEFT JOIN EMPLOYEES E
            ON E.DEPARTMENT_ID = D.DEPARTMENT_ID)
      WHERE EMPLOYEE_ID IS NOT NULL
      GROUP BY DEPARTMENT_NAME) N
WHERE D.DEPARTMENT_NAME= N.DEPARTMENT_NAME
ORDER BY 사원수 DESC;

--문제16
--부서에 모든 컬럼, 주소, 우편번호, 부서별 평균 연봉을 구해서 출력하세요.
--조건) 부서별 평균이 없으면 0으로 출력하세요
SELECT * FROM LOCATIONS;
SELECT D.DEPARTMENT_ID,
       DEPARTMENT_NAME,
       MANAGER_ID,
       D.LOCATION_ID,
       STREET_ADDRESS,
       POSTAL_CODE,
       NVL(평균연봉,0) 평균연봉
FROM DEPARTMENTS D
LEFT JOIN (SELECT DEPARTMENT_ID,
                  TRUNC(AVG(NVL(SALARY,0)),2) 평균연봉
           FROM EMPLOYEES
           GROUP BY DEPARTMENT_ID) N
ON D.DEPARTMENT_ID = N.DEPARTMENT_ID
LEFT JOIN LOCATIONS L
ON D.LOCATION_ID = L.LOCATION_ID;


--문제17
--문제 16결과에 대해 DEPARTMENT_ID기준으로 내림차순 정렬해서 ROWNUM을 붙여 1-10데이터 까지만
--출력하세요
SELECT ROWNUM,
       DEPARTMENT_ID,
       DEPARTMENT_NAME,
       MANAGER_ID,
       LOCATION_ID,
       STREET_ADDRESS,
       POSTAL_CODE,
       평균연봉
FROM (SELECT D.DEPARTMENT_ID DEPARTMENT_ID,
             DEPARTMENT_NAME,
             MANAGER_ID,
             D.LOCATION_ID LOCATION_ID,
             STREET_ADDRESS,
             POSTAL_CODE,
             NVL(평균연봉,0) 평균연봉
      FROM DEPARTMENTS D
      LEFT JOIN (SELECT DEPARTMENT_ID,
                        TRUNC(AVG(NVL(SALARY,0)),2) 평균연봉
                 FROM EMPLOYEES
                 GROUP BY DEPARTMENT_ID) N
      ON D.DEPARTMENT_ID = N.DEPARTMENT_ID
      LEFT JOIN LOCATIONS L
      ON D.LOCATION_ID = L.LOCATION_ID
      ORDER BY DEPARTMENT_ID)
WHERE ROWNUM BETWEEN 1 AND 10;