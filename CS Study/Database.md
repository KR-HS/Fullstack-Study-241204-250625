# 데이터베이스(Database)

## 1. 관계형 DB

### 1-1. 테이블 설계
 + 데이터를 행과 열로 구조화하여 저장

 + 원리
     + **행(Row)** : 하나의 데이터 단위
     + **열(Column)** : 데이터 속성, 타입 지정
 + **사용 이유 / 사용 시점** : 정형화된 데이터 저장, 구조화된 검색 필요할 때

 > ```sql
 > CREATE TABLE users (
 >   id INT PRIMARY KEY,
 >   name VARCHAR(50),
 >   email VARCHAR(100) UNIQUE,
 >   created_at TIMESTAMP
 > );
 > ```

 + **PK(Primary Key)**
     + 테이블에서 각 행을 고유하게 식별하는 컬럼
     + 중복 불가, NULL 불가
     + 유일성, 무결성

     > ```sql
     > id INT PRIMARY KEY
     > ```

 + **FK(Foreign Key)**
     + 다른 테이블의 PK를 참조 -> 관계 표현
     + 데이터 무결성 확보

     > ```sql
     > user_id INT,
     > FOREIGN KEY (user_id) REFERENCES users(id)
     > ```

 + **제약조건**
     + **UNIQUE** : 중복 방지
     + **NOT NULL** : 필수 값 보장
     + **CHECK** : 특정 조건 제한

 + **무결성(Integrity)**
     + 데이터의 정확성과 일관성이 항상 유지되는 성질

     + **종류** : 
         1. **개체 무결성(Entity Integrity)**
             + 각 행이 고유하게 식별 가능해야 함
             + PK가 이 역할 수행
             
         2. **참조 무결성(Referential Integrity)**
             + FK로 다른 테이블 참조 시, 참조가 올바르게 유지되는 것

         3. **도메인 무결성(Domain Integrity)**
             + 컬럼 값이 허용된 타입과 범위 내에 있어야 함

         4. **사용자 정의 무결성(User-defined Integrity)**
             + CHECK, 트리거 등을 활용해 특정 규칙 준수


### 1-2. 정규화(Normalization)
 + **중복 데이터 제거 및 이상현상(Anomaly) 방지**를 위해 테이블 구조 최적화

 + **원리** : 
     + **1NF** : 원자값, 중복 컬럼 제거(도메인이 원자값)
     + **2NF** : 부분 종속 제거 (복합 PK인 경우)
     + **3NF** : 이행 종속 제거
     + **BCNF** : 결정자가 후보키가 아닌 함수 종속 제거(모든 결정자가 후보키 집합에 속함)
     + **4NF** : `다치 종속` 제거 
         + 같은 테이블 내의 독립적인 두 개 이상의 컬럼이 또 다른 컬럼에 종속되는 것
         + A → B 인 의존성에서 단일 값 A와 다중 값 B가 존재한다면 다치 종속(A ↠ B로 표시)
     + **5NF** : `조인 종속` 제거
         + 하나의 릴레이션을 여러개의 릴레이션으로 분해하였다가, 다시 조인했을 때 데이터의 손실이 없고 필요없는 데이터가 생기는 것

 + **사용 이유 / 사용 시점** : 데이터 무결성 확보, 유지보수 용이

 + **장점** : 
     + 데이터 중복 최소화 : 저장 공간 효율적
     + 데이터 무결성 유지 : 업데이트 시 오류 감소
 
 + **단점** :  
     + JOIN이 많아짐 -> 조회 성능 저하
     + 대규모 트랜잭션에서 다중 JOIN 시 속도 느림

 + **반정규화(Denormalization)**
     + 정규화로 나눈 테이블을 일부러 합치거나 중복 데이터를 허용하여, 조회 성능을 높이는 설계 방법

     + JOIN 횟수를 줄여 조회 속도를 개선하고, 일부 컬럼 중복 허용을 통해 조회에 피룡한 데이터를 한 번에 가져옴

 + (참고 링크)[https://velog.io/@wisdom-one/%EC%A0%95%EA%B7%9C%ED%99%94Normalization]


### 1-3. SQL 쿼리 작성
 + **SELECT**
     > ```sql
     > SELECT name, email FROM users WHERE id = 1;
     > ```

 + **JOIN**
     + 여러 테이블 연결
     
     + **사용 시점** : 
         + 서로 관련된 데이터를 한 번에 조회할 때
         + 테이블 간 관계가 명확할 때
         + 성능이 중요할 때 -> 대부분 DB에서 JOIN이 서브쿼리보다 최적화가 잘 되어 있음

     + **종류** : 
         + **INNER JOIN** : 양쪽 모두 존재할 떄 조회
         + **LEFT/RIGHT JOIN** : 한쪽 테이블 기준으로 모두 조회
         + **FULL OUTER JOIN** : 양쪽 모두 포함, 존재하지 않으면 NULL 반환

     > ```sql
     > SELECT u.name, d.department_name
     > FROM users u
     > JOIN departments d ON u.department_id = d.id;
     > ```

 + **서브쿼리(Subquery)**
     + 사용 시점 : 조건이 복잡할 때 -> 특정 조건에 맞는 데이터만 먼저 추출하고, 그 결과로 필터링

     > ```sql
     > SELECT name FROM users WHERE id IN (SELECT user_id FROM orders WHERE price>100);
     > ```


### 1-4. 인덱스(Index)
 + **검색 속도 향상을 위한 데이터 구조**
 + 특정 컬럼의 **값을 빠르게 찾기 위해 미리 정렬/구조화**

 + **원리** :
     + **B+Tree Index** : 
         + 균형 잡힌 다중 자식 트리
         + 정렬된 트리 구조 -> 범위 검색 O(log n)
         + 범위 검색과 정렬된 데이터 빠른 탐색
         
         + **특징** : 
             + 모든 리프 노드가 같은 레벨 -> 균형 트리
             + 하나의 노드가 여러 개 키와 자식을 가질 수 있음 -> 다중 자식
             + 내부 노드 : 탐색용 키만 저장
             + 리프 노드 : 실제 데이터 또는 레코드 포인터
             + 리프 노드끼리 연결 -> 범위 검색, 순차 스캔 효율적

         + **B-Tree**와 차이점 : B-Tree는 내부노드에 탐색용 키, 실제 데이터가 저장될 수 있음

     + **Hash Index** : 
         + 정확한 값 검색 O(1), 범위 검색 불가
     
     + **Composite Index** : 
         + 여러 컬럼 결합
         + 순서 중요(WHERE 조건 순서와 일치해야 활용) 
     
     + **Unique Index** : 
         + 중복 방지 + 검색 속도 향상
        
 + **쓰기 성능 저하 이유**
     1. **INSERT 시점**
         + 테이블에 데이터 추가 + 인덱스에 데이터 추가
         + 인덱스 구조 유지 위해 정렬/균형 조정 필요
         
     2. **UPDATE 시점**
         + 인덱스 컬럼을 수정하면 인덱스에서 값 삭제 후 다시 삽입
         + 인덱스 구조 재정렬 필요 -> CPU/IO 비용 증가

     3. **DELETE 시점**
         + 데이터 삭제 + 인덱스에서 해당 키 제거
         + 인덱스 균형 유지를 위해 재배치 필요
        

 + **사용 이유 / 사용 시점** : 조회 빈도가 높고 조건절이 많은 컬럼

 > ```sql
 > CREATE INDEX idx_user_email ON users(email);
 > ```


### 1-5. 트랜잭션(ACID)
 + **데이터 무결성을 보장하는 단위 작업**
 + **원리** : 
     + **Atomicity(원자성)** : 전체 실행 / 전체 롤백
     + **Consistency(일관성)** : 트랜잭션 전후 데이터 무결성 유지
     + **Isolation(격리성)** : 동시성 문제 방지
     + **Durability(지속성)** : 커밋 후 데이터 손실 방지
 
 > ```sql
 > BEGIN TRANSACTION;
 > UPDATE accounts SET balance=balance-100 WHERE id=1;
 > UPDATE accounts SET balance=balance+100 WHERE id=2;
 > COMMIT;
 > ```

 + **고립 단계(Isolation Level)**
     + 고립 : 한 트랜잭션이 처리 중인 데이터가 다른 트랜잭션에 의해 영향을 받지 않도록 하는 정도
     + 여러 트랜잭션이 동시에 실행될 때 데이터 일관성을 보장하기 위한 수준 정의
     
     + 단계 : 
         + `READ UNCOMMITED` : 
             + 다른 트랜잭션이 아직 커밋하지 않은 데이터도 읽기 가능
             + Dirty Read 발생 가능
                 + `Dirty Read` : 다른 트랜잭션이 아직 커밋하지 않은 데이터를 읽는 것

         + `READ COMMITED` : 
             + Commit된 데이터만 읽기 허용
             + Dirty Read 방지

         + `REPEATABLE READ` : 
             + 같은 데이터 반복 읽기 시 항상 같은 값 보장
             + Non-Repeatable Read 방지
                 + `Non-Repeatable Read(반복 불가능한 읽기)` : 같은 트랜잭션이 같은 데이터를 두 번 읽었는데, 중간에 다른 트랜잭션이 **수정해서 값이 달라지는 현상**

         + `SERIALIZABLE` : 
             + 완전 직렬화 -> 트랜잭션이 순차적으로 실행되는 것과 동일
             + Phantom Read 방지
                 + `Phantom Read` : 트랜잭션이 같은 조건으로 데이터를 두 번 조회했는데, 중간에 다른 트랜잭션이 **새로운 행을 삽입/삭제해서 결과가 달라지는 현상**

 + **교착상태(Deadlock)**
     + 두 트랜잭션이 서로가 가진 자원을 기다리는 상황
     + 해결 : 타임아웃, 자원 순서 통일, Lock 최소화

---
## 2. 비관게형 DB(NoSQL)
 + Not Only SQL
 + 전통적 관계형 DB(RDBMS)와 달리 스키마 고정 없이 데이터 저장/조회 가능
 + 대규모, 분산 환경에서 성능과 확장성을 중점적으로 설계
 + 특징: 유연한 데이터 모델, 수평 확장성, 빠른 조회/쓰기

 + **종류** :
     1. **Key-Value Store**
         + 키와 값으로 단순 저장
         + 용도 : 캐시, 세션 저장, 빠른 조회
         + 예: Redis, DynamoDB

     2. **Document Store**
         + JSON/BSON 문서 단위 저장
             + JSON(Javascript Object Notation) : 데이터를 문자열로 표현하는 표준 방식
         + 유연한 구조, 필드 추가 자유로움
         + 예 : MongoDB, CouchDB

     3. **Column Family Store**
         + 행 단위, 컬럼 그룹별 저장
         + 분석용 대용량 데이터 최적화
         + 예: Cassandra, HBase

     4. **Graph DB**
         + 정점과 간선으로 저장
         + 관계형 데이터 탐색 최적화
         + 예 : Neo4j, JanusGraph

 + DB + 캐시조합 : 캐시는 메모리 기반으로 빠른 조회, DB(RDBMS)는 영속성을 보장하므로 둘 조합시 **실시간 데이터 처리 및 안정성 확보 가능**

### 2-1. Redis
 + **인메모리 키-값 구조 DB**
 + 메모리(RAM, 휘발성 메모리)에 데이터 저장 -> 서버가 꺼지거나 재시작하면 기본적으로 메모리 데이터는 사라짐
 + 필요시 디스크에 영속성 저장(AOF, RDB) 옵션 설정 가능
     + RDB : 일정 시점마다 스냅샷 저장
         + 스냅샷 : 시점에 저장된 데이터 전체 상태를 그대로 복사한 것
     + AOF : 모든 쓰기 명령 기록 -> 재시작 시 복원

 + **원리** : 
     + 메모리 기반 : 매우 빠른 읽기/쓰기
     + 데이터 구조 : String, List, Set, Sorted Set, Hash

 + **장점** : 
    + 메모리 기반 -> 초고속 읽기/쓰기
    + Pub/Sub, Sorted Set 지원 -> 실시간 처리 가능

 + **단점** : 
     + 데이터 용량 제한 -> 메모리 부족 시 삭제 정책 필요

 + **TTL(Time To Live)**
     + 만료 시간 설정 -> 캐시 자동 삭제
     + 캐싱 전략 : LRU(Least Recently Used), LFU(Least Frequently Used), FIFO(First In First Out)

 + **사용 이유 / 사용 시점** : 캐싱, 세션관리, 실시간 통계

 > ```java
 > // Java + Jedis 사용 예시
 > Jedis jedis = new Jedis("localhost");
 > 
 > // 캐시 저장
 > jedis.set("user:1001", "{'name':'홍길동','age':25}");
 > jedis.expire("user:1001", 3600); // 1시간 후 만료
 > 
 > // 캐시 조회
 > String userData = jedis.get("user:1001");
 > ```

### 2-2. Key-Value 구조
 + Key로 Value조회
 
 + **원리** : 해시테이블 또는 트리 기반

 + **사용 이유 / 사용 시점** : 빠른 조회 필요, 단순 데이터 저장

 > ```json
 > {
 >   "user:1": {"name": "Alice", "age": 30}
 > }
 > ```


---
## 3. DB 연동

### 3-1. JDBC
 + **Java와 DB 연결 표준 API**

 + **원리** : `DriverManager` -> `Connection` -> `Statement/PreparedStatement` -> `ResultSet`
     + **PreparedStatement**
         + SQL Injection 방지
             + 쿼리구조와 데이터를 분리하여, 입력받은 값이 데이터로 처리됨 -> 쿼리구조가 바뀌지 않음
         + 파라미터 바인딩 -> 반복 쿼리 효율적
         + Statment와 다른점은 print, printf와 같이 문자열로 쿼리문을 작성하는지, 포맷형식으로 쿼리문을 작성하는지의 차이
         > ```java
         > // Statement (취약 예시)
         > Statement stmt = conn.createStatement();
         > String userId = "1001 OR 1=1"; // SQL Injection 위험
         > ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id=" + userId);
         > 
         > // PreparedStatement (안전)
         > String sql = "SELECT * FROM users WHERE id = ?";
         > PreparedStatement pstmt = conn.prepareStatement(sql);
         > pstmt.setInt(1, 1001); // 파라미터 바인딩
         > ResultSet rs2 = pstmt.executeQuery();
         > ```

     + **Connection Pool**
         + DB 연결(Connection) 객체를 미리 생성해 풀(Poll)로 관리
         + 필요할 때 가져다 쓰고, 사용 후 반환 -> 매번 새 연결 생성 비용 제거
         + 리소스를 미리 만들어두고 재사용
         + 예시 : **Hikari CP**(Connetino Pool)
             + Java에서 많이 쓰이는 고성능 JDBC Connection Pool
             + Spring Boot에서는 기본적으로 HikariCP를 사용 
         > ```java
         > HikariConfig config = new HikariConfig();
         > config.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
         > config.setUsername("user");
         > config.setPassword("pass");
         > config.setMaximumPoolSize(10); // 최대 10개 연결
         > 
         > HikariDataSource ds = new HikariDataSource(config);
         > 
         > // 커넥션 사용
         > try (Connection conn = ds.getConnection()) {
         >     PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE id=?");
         >     pstmt.setInt(1, 1001);
         >     ResultSet rs = pstmt.executeQuery();
         >     // 결과 처리
         > }
         > ```
         

 > ```java
 > Connection conn = DriverManager.getConnection(url, user, pwd);
 > PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id=?");
 > ps.setInt(1, 1);
 > ResultSet rs = ps.executeQuery();
 > ```

### 3-2. Repository 패턴
 + DB 접근 추상화, 도메인 중심 개발
 
 + **원리** : DAO(Data Access Object)개선, 인터페이스 기반

 > ```java
 > public interface UserRepository extends JpaRepository<User, Integer> {
 >     List<User> findByName(String name);
 > }
 > ```

### 3-3. Lazy / Eager Loading, N+1 문제
 + **Lazy Loading** : 필요한 시점에 데이터 조회 -> 초기 로딩 가벼움
 
 + **Eager Loading** : 미리 JOIN하여 모두 조회 -> 한번에 처리, 초기 비용 높음
 
 + **N+1 문제** : Lazy 로딩 반복 -> 쿼리 N+1번 발생
 + 예시 : Order 10개 조회시 -> Users 1번 쿼리 + Orders 10번 쿼리 = 총 11번 쿼리
 > ```java
 > @OneToMany(fetch = FetchType.LAZY)
 > private List<Order> orders;
 > ```