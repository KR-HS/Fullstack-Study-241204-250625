--문제 1.
--사원 테이블에서 JOB_ID별 사원 수를 구하세요.
SELECT JOB_ID, COUNT(*) 사원수 
FROM EMPLOYEES 
GROUP BY JOB_ID;

--사원 테이블에서 JOB_ID별 월급의 평균을 구하세요. 월급의 평균 순으로 내림차순 정렬하세요.
SELECT JOB_ID, AVG(SALARY) 월급평균 
FROM EMPLOYEES 
GROUP BY JOB_ID 
ORDER BY 월급평균 DESC;

--시원 테이블에서 JOB_ID별 가장 빠른 입사일을 구하세요. JOB_ID로 내림차순 정렬하세요.
SELECT JOB_ID,MIN(HIRE_DATE) 
FROM EMPLOYEES 
GROUP BY JOB_ID 
ORDER BY JOB_ID DESC;

--
--문제 2.
--사원 테이블에서 입사 년도 별 사원 수를 구하세요.
SELECT TO_CHAR(HIRE_DATE,'YYYY"년"') 입사년도, COUNT(*) 사원수 
FROM EMPLOYEES
GROUP BY TO_CHAR(HIRE_DATE,'YYYY"년"');
--
--
--문제 3.
--급여가 1000 이상인 사원들의 부서별 평균 급여를 출력하세요. 단 부서 평균 급여가 2000이상인 부서만 출력
SELECT DEPARTMENT_ID,AVG(SALARY) "평균 급여"
FROM EMPLOYEES
WHERE SALARY>=1000
GROUP BY(DEPARTMENT_ID)
HAVING AVG(SALARY)>=2000;
--
--문제 3.
--부서아이디가 NULL이 아니고, 입사일은 05년도 인 사람들의 부서 급여평균과, 급여합계를 평균기준 내림차순 조회하세요.
----조건은 급여평균이 10000이상인 데이터만.
SELECT DEPARTMENT_ID,AVG(SALARY) 급여평균,SUM(SALARY) 급여합계 
FROM EMPLOYEES 
WHERE DEPARTMENT_ID IS NOT NULL AND TO_CHAR(HIRE_DATE,'YY')='05'
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY)>=10000
ORDER BY 급여합계;



--
--문제 4.
--사원 테이블에서 commission_pct(커미션) 컬럼이 null이 아닌 사람들의
--department_id(부서별) salary(월급)의 평균, 합계, count를 구합니다.
--조건 1) 월급의 평균은 커미션을 적용시킨 월급입니다.
--조건 2) 평균은 소수 2째 자리에서 절삭 하세요.
SELECT DEPARTMENT_ID,
       TRUNC(AVG(SALARY+SALARY*NVL(COMMISSION_PCT,0)),2) AS 월급평균,
       SUM(SALARY) AS 월급합계,
       COUNT(*) 사원수
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL
GROUP BY DEPARTMENT_ID;
--
--문제 5.
--부서아이디가 NULL이 아니고, 입사일은 05년도 인 사람들의 부서 급여평균과, 급여합계를 평균기준 내림차순합니다
--조건) 평균이 10000이상인 데이터만
SELECT AVG(SALARY) 급여평균,SUM(SALARY) 급여합계
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL AND TO_CHAR(HIRE_DATE,'YY')='05'
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY)>=10000
ORDER BY 급여평균 DESC;
--
--문제 6.
--직업별 월급합, 총합계를 출력하세요
SELECT DECODE(GROUPING(JOB_ID),1,'총합계',0,JOB_ID), SUM(SALARY) 월급합  
FROM EMPLOYEES
GROUP BY ROLLUP(JOB_ID);
--
--문제 7.
--부서별, JOB_ID를 그룹핑 하여 토탈, 합계를 출력하세요.
--GROUPING() 을 이용하여 소계 합계를 표현하세요
SELECT DECODE(GROUPING(DEPARTMENT_ID),1,'총합계',0,DEPARTMENT_ID)DEPARTMENT_ID,
       DECODE(GROUPING(JOB_ID),1,'소계',0,JOB_ID)JOB_ID,
       COUNT(*) AS TOTAL,
       SUM(SALARY) 월급합  
FROM EMPLOYEES
GROUP BY ROLLUP(DEPARTMENT_ID,JOB_ID)
ORDER BY 월급합;



SELECT CASE WHEN GROUPING(DEPARTMENT_ID)=1 AND GROUPING(JOB_ID)=1 THEN '총계'
            WHEN GROUPING(DEPARTMENT_ID)=1 THEN '소계'
            ELSE TO_CHAR(DEPARTMENT_ID)
        END 부서
       ,CASE WHEN GROUPING(DEPARTMENT_ID)=1 AND GROUPING(JOB_ID)=1 THEN ' ' 
             WHEN GROUPING(JOB_ID)=1 THEN '소계'
             ELSE TO_CHAR(JOB_ID)
        END 직무
       ,SUM(SALARY) 월급합  
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY CUBE(DEPARTMENT_ID,JOB_ID)
ORDER BY DEPARTMENT_ID,JOB_ID;