# Java 심화

## 1. Java 컬렉션 & 제네릭

### Java 컬렉션(Collection)
 + 배열(Array)처럼 여러 데이터를 담지만 더 유연하고 다양한 기능을 제공하는 클래스들의 모음

 + **컬렉션 사용 이유**
     + 동적 크기 관리
     + 삽입/삭제/검색 효율적 지원
     + 정렬, 중복 처리, 동기화 등 다양한 기능 제공

 + **Java 컬렉션 구조**
     1. **Collection 인터페이스**
         + List : 순서가 있고 중복 허용
         + Set : 순서가 없고 중복 불가

     2. **Map 인터페이스**
         + Key-Value 저장, Key는 중복 불가
         + Map은 Collection을 상속하지 않음

### List
 + 특징 : **순서가 있고, 중복 허용**
 + 주요 구현체 : `ArrayList` , `LinkedList`
 
 + **검색/삽입/삭제 시간복잡도** 
     + `ArrayList`
     > + `get` : **O(1)** (인덱스로 바로 접근 가능)
     > + `add` : **O(1)** (배열 끝에 추가 가능, 배열 확장 시에는 O(n))
     > + `remove` : **O(n)** (삭제 시 뒤에 있는 요소들을 한 칸씩 이동해야 함)

     + `LinkedList`
     > + `get` : **O(n)** (처음부터 순차 탐색 << 양방향 연결 리스트)
     > + `add/remove` : **O(1)** (노드 앞뒤 연결만 바꾸면 됨)


### Set
 + 특징 : **순서가 없고, 중복 불가**
 + 주요 구현체 : `HashSet` , `TreeSet`, `LinkedHashSet`

 + **검색/삽입/삭제 시간복잡도**
     + `HashSet`
     > + `add`,`remove`,`contains` : **O(1)**
     >> + 해시코드로 버킷 위치 계산 -> 링크드 리스트 또는 트리에서 바로 접근
     >>> + **버킷** : 해시 테이블에서 데이터를 저장하는 칸(슬롯)
     >>>> + **해시 테이블** : 배열의 인덱스를 해시 함수 결과로 결정해서 데이터를 저장/조회

     + `TreeSet`
     > + **O(log n)** (트리 높이에 따라 탐색 << 이진 검색 트리)
     >> + 항상 정렬 상태 유지 때문에 O(log n) 발생


### Map
 + 특징 : Key-Value 쌍으로 이루어진 데이터 집합 (Key는 중복불가, value는 중복허용)
 + 주요 구현체 : `HashMap`, `TreeMap`, `LinkedHashMap`
 + 검색/삽입/삭제 시간복잡도
     + `HashMap`
     > + `get/put` : **O(1)** (key.hashCode()로 버킷접근 -> 충돌 최소화)
 
     + `TreeMap`
     > + **O(log n)** (key 기준으로 탐색, 항상 정렬 유지)


### HashMap/HashSet 내부 구조
 + HashMap : Key를 `hashCode()` -> 해시 버킷(index) -> 링크드 리스트 / 트리 구조 
     + 버킷안에 저장되는 key-value들이 링크드 리스트/트리구조로 저장되는 이유는 key값은 다르나 해시함수를 적용한 해시key값이 같을 경우 링크드 리스트나 트리구조로 연결해주기 위해서
 + HashSet : 내부적으로 ``HashMap`` 사용
     + HashSet에 저장되는 값은 HashMap의 키에 저장되고 value에는 더미 값이 저장됨 -> 실질적으로 HashMap의 키값들이 HashSet의 값들임

 + 충돌 처리
     + Linked List (버킷 충돌 시 연결)
     + Tree (Java 8 이후, 충돌이 8개 이상이면 트리로 변환)
 
 + HashMap 특징
     + Key는 유일해야 함
     + null Key는 1개만 허용, null Value 가능
     + HashMap에 동시 접근 시 `ConcurrentHashMap` 필요


### Comparable / Comparator
 + **ComParable**
     + 목적 : **객체 자체의 기본 정렬 기준**
     + 메서드 : `compareTo(T o)`
     + 사용 : 객체 클래스에 구현
     + 예시 : ``class User implements Comparable<User>``

 + **Comparator**
     + 목적 : **외부에서 정렬 기준 지정**
     + 메서드 : `compare(T o1, T o2)`
     + 사용 : 별도 클래스 또는 람다
         + 단일 표현식
         > + 표현식 하나 -> 결과값 자동 반환
         > + return 필요 없음

         + 블록 표현식
         > + 중괄호({}) 사용 -> 여러 문장 가능
         > + 마지막에 반환값 지정 반드시 return
     + 예시 : ``Comparator<User> byAge = (a,b)-> a.age-b.age;``

---

## 2. 멀티스레드 & 동시성

+ 멀티스레드
 + **Thread** : 직접 상속 -> run()구현 -> start()호출
 + **Runnable** : 인터페이스 구현 -> 스레드에 전달 -> start()
 + **ExecutorService** : 스레드 풀 관리, 재사용 가능, 스레드 생성/종료 비용 절감
     + 스레드 풀 관리 객체
     + **스레드 생성/관리 자동화** -> 재사용 가능
     + **작업 제출** -> Runnable/Callable 실행
     + **동시성 제어** -> 동시에 실행될 스레드 수 제한 가능
     + **종료 관리 기능**
 > ```java
 > import java.util.concurrent.*;
 > public class ExecutorExample {
 >     public static void main(String[] args) {
 >         ExecutorService executor = Executors.newFixedThreadPool(3); // 3개 스레드 풀
 > 
 >         Runnable task = () -> {
 >             System.out.println(Thread.currentThread().getName() + " 실행");
 >         };
 > 
 >         for (int i = 0; i < 10; i++) {
 >             executor.submit(task); // 작업 제출
 >         }
 > 
 >         executor.shutdown(); // 작업 끝나면 스레드 풀 종료
 >     }
 > }
 > ```


+ 동기화
 + **synchronized** : 블록/메서드 동기화, 한 번에 한 스레드만 접근
     + 목적: 임계 영역(Critical Section) 보호 → 여러 스레드가 동시에 접근하면 안 되는 코드 블록을 잠금
 + **volatile** : 변수 값 메인 메모리에 직접 반영, 원자적 연산 X
     + 목적 : 한 스레드가 바꾼 값이 다른 스레드에서 바로 보이도록 하는 것
 + **Lock** : 더 세밀한 제어 가능
     + Lock/...Unlock 필요, try-finally 패턴 사용 권장


+ **Concurrent 컬렉션**
 + **ConcurrentHashMap** : 내부 Segment(HashMap조각 + Lock(보호장치)) 단위 락 -> 높은 동시성
 + **CopyOnWriteArrayList** : 쓰기 시 기존 배열을 복사해서 새 배열 생성 후 기존 개별의 값 반영 후 참조 교체, 읽기 다중 스레드 안전 
     + 주의 : 쓰기 비용이 크므로 읽기 위주 환경에서 사용


+ 문제발생
 + **ThreadPool** : 스레드 재사용, 작업 큐, ExecutorService
 + **Deadlock** : 서로가 가진 자원을 기다리면서 무한 대기하는 상태, 상호 Lcck 획득 대기 -> 교착
 + **Race Condition** : 동시 접근 시 예상치 못한 결과 -> 실행 순서에 따라 결과가 달라짐
 + **방지** : synchronized, Lock, Atomic 변수 사용

---

## 3. Stream API & 람다
+ **Stream API**
 + **중간 연산 (Intermediate Operations)**
     + 스트림을 **변환/필터링/가공**할 때 사용
     + 여러 개 연속 호출 가능
     + Lazy evaluation -> 최종 연산 전까지 실행 안됨
     + 예시
     > + `map` : 각 요소를 변환 (예 : String -> 대문자)
     > + `filter` : 조건에 맞는 요소만 선택
     > + `distinct` : 중복 제거
     > + `sorted` : 정렬
     > + `limit` : 지정 개수만큼 자르기
     > + `skip` : 지정 개수만큼 건너뛰기
     > + `flatMap` : 스트림 내부 요소를 평탄화
     > + `boxed` : 기본형(primitive) -> 참조형(Wrapper)로 변환 , StreamAPI에서 객체 메서드(Comparator, collect 등)를 쓰기 위해 필요

 + **최종 연산 (Terminal Operations)**
     + 스트림을 **실제로 소비** 할 때 사용
     + Stream 사용 후에는 다시 사용할 수 없음
     + 예시
     > + `reduce` : 요소를 하나로 합침
     > + `collect` : 스트림 -> 컬렉션/Map으로 변환
     > + `forEach` : 각 요소 순회
     > + `count` : 요소 개수 계산
     > + `anyMatch` / `allMatch` / `noneMatch` : 조건 만족 여부 확인
     > + `min` / `max` : 최소/최대값 계산



 + **map, filter, reduce, collect**
     ```java
     List<String> list = List.of("a","b","c");
     list.stream()
         .filter(s -> s != "b")
         .map(String::toUpperCase)
         .collect(Collectors.toList());
     ```

+ **Lazy evalutaion** : 중간 연산(map, filter) -> 최종 연산(collect) 실행 시 처리
    
+ **Parallel Stream** : `.parallelStream()` -> 병렬 처리, CPU 코어 활용
     + 주의 : 상태 공유/순서에 민감한 작업 피해야 함