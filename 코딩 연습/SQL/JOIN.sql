-- INNER JOIN(내부조인)
SELECT * FROM INFO;
SELECT * FROM AUTH;
SELECT * FROM INFO INNER JOIN AUTH ON INFO.AUTH_ID = AUTH.AUTH_ID; -- 붙을 수 없는 데이터는 안나옴


-- 컬럼 지정 : AUTH_ID는 양쪽에 다 있기 때문에, 출력시 테이블명.컬럼명으로 지정해야 함
SELECT ID , TITLE, CONTENT, AUTH.AUTH_ID, NAME, JOB
FROM INFO INNER JOIN AUTH ON INFO.AUTH_ID = AUTH.AUTH_ID;

-- 테이블 ALIAS
SELECT *
FROM INFO I
INNER JOIN AUTH A
ON I.AUTH_ID = A.AUTH_ID;

-- USING절 : 양쪽 테이블에 동일 키 이름으로 연결할 떄 사용 가능
SELECT *
FROM INFO I
INNER JOIN AUTH A
USING (AUTH_ID);

---------------------------------------------------------------
-- 외부조인이라고 부름
-- LEFT OUTER JOIN : 왼쪽 테이블이 기준이 되고, 왼쪽 테이블은 다 나옴
SELECT *
FROM INFO I
LEFT OUTER JOIN AUTH A
ON I.AUTH_ID = A.AUTH_ID;

-- RIGHT OUTER JOIN : 오른쪽 테이블이 기준이 되고, 오른쪽 테이블은 다나옴
