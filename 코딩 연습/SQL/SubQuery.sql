-- 단일행 서브쿼리 : SELECT한 결과가 1행인 서브쿼리
-- 서브쿼리는 ()로 묶는다. 연산자보다는 오른쪽에 나옴

SELECT * 
FROM EMPLOYEES 
WHERE SALARY >= (SELECT SALARY FROM EMPLOYEES WHERE FIRST_NAME= 'Nancy');