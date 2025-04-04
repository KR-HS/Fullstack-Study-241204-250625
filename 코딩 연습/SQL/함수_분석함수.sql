-- 분석함수
SELECT FIRST_NAME,
       SALARY,
       RANK() OVER(ORDER BY SALARY DESC) 중복등수,
       DENSE_RANK() OVER(ORDER BY SALARY DESC) 중복없는등수,
       ROW_NUMBER() OVER(ORDER BY SALARY DESC) AS 일련번호
FROM EMPLOYEES;