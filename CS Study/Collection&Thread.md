# 1. Collection & Thread

---

## <1> 자바 컬렉션 프레임워크(Java Collection Framework)
 + **정의** : 여러 데이터를 효율적으로 **저장, 조회 수정, 삭제** 할 수 있도록 만든 객체들의 집합

 + **목적** : 배열보다 유연하고 편리하게 데이터 관리 가능, 자료구조를 추상화

 + **기본 구조**
  > + `Collection` 인터페이스 > `List`, `Set` 등
  > + `Map` 인터페이스 (Key-Value 구조)

### Collection 인터페이스 종류
 #### 1. **List**
 + **정의** : **순서가 있는** 데이터 저장, **중복 허용**

 + **대표 구현체** : `ArrayList`, `LinkedList`, `Vector`

 + 특징 
   > + **`ArrayList`** : 내부 배열 기반, **인덱스로 접근 가능**, 검색 빠름, 삽입/삭제 느림 -> 조회가 많을 때 사용
   > + **`LinkedList`** : 양방향 연결 리스트 기반, **노드가 데이터와 다음/이전 주소 저장**, 삽입/삭제 빠름, 검색 느림 -> 삽입/삭제가 많을 때 사용
   > + **`Vector`** : ArrayList와 유사, **동기화 지원**

 + 예시
  > ```java
  > List<String> list = new ArrayList<>();
  > list.add("A");
  > list.add("B");
  > list.add("A"); // 중복 허용
  > System.out.println(list.get(0)); // A
  > ```
 
 #### 2. **Set**
 + **정의** : **순서 없음**, **중복 데이터 허용 안 함**, **인덱스로 조회 불가능**
 + **대표 구현체** : `HashSet`, `LinkedHashSet`, `TreeSet`
 + 특징
   > + **`HashSet`** : 해시 기반, 순서 없음, 검색/삽입 빠름
   > + **`LinkedHashSet`** : 입력 순서 유지
   > + **`TreeSet`** : **정렬된 상태 유지**, 범위 검색 가능

 + 예시
   > ```java
   > Set<String> set = new HashSet<>();
   > set.add("A");
   > set.add("B");
   > set.add("A"); // 무시됨
   > ```

 + **해시(Hash)**
   > + 임의 크기의 데이터를 **고정 크기 값(숫자 등)으로 변환**하는 것
   > + 변환된 값을 배열 인덱스처럼 활용해서 데이터를 빠르게 찾는 것

 + **HashSet**
   > + HashSet은 내부적으로 HashMap사용
   > + HashMap의 key들이 HashSet의 요소
   > + HashMap의 value에는 dummy값 저장
   >
   > + 예시
   >> ```java
   >> HashSet<String> set = new HashSet<>();
   >> set.add("A");
   >> set.add("B");
   >> ```
   > 
   > + 내부 구조
   >> ```text
   >> HashMap: { "A"=PRESENT, "B"=PRESENT }
   >> ```


 #### 3. **Map**
 + **정의** : **Key-Value 쌍으로 데이터 저장**, Key는 중복 불가, Value는 중복 가능

 + **대표 구현체** : `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable`

 + 특징
   > + **`HashMap`** : Key 해시 기반, null Key 1개 가능, null Value 여러 개 가능
   > + **`LinkedHashMap`** : 삽입 순서 유지
   > + **`TreeMap`** : Key 오름차순 정렬
   > + **`Hashtable`** : HashMap과 유사, **동기화 지원**

 + 예시
   > ```java
   > Map<String, Integer> map = new HashMap<>();
   > map.put("Alice", 25);
   > map.put("Bob", 30);
   > map.put("Alice", 28); // 덮어쓰기
   > System.out.println(map.get("Alice")); // 28
   > ```

---
## <2> Thread
 + **정의** : 프로그램에서 독립적으로 실행되는 작업의 단위

 + **목적** : 멀티 태스크 처리, CPU 자원 효율적 활용

 + **관련 용어** 
   > + **프로세스(Process)** : 운영체제에서 실행 중인 프로그램의 단위
   >> + **독립된 메모리 공간과 자원**을 가짐
   >> + 서로 **다른 프로세스**끼리는 **메모리 공유 불가**
   >
   > + **스레드(Thread)** : 프로세스 내에서 실제 작업을 수행하는 흐름의 단위
   >> + 같은 프로세스 내 Heap 메모리 공유, Stack은 별도
   >> + 독립적으로 실행되지만, 프로세스와 자원을 공유
   >> + 멀티스레딩 가능 -> CPU자원 효율적 활용  

 + **Heap 메모리**
 > + 객체 저장
 > + 모든 스레드가 공유
 > + new Object()로 생성한 객체

 + **Stack 메모리**
 > + 메서드 호출, 지역변수 저장, 참조 변수 저장 (Heap에 저장된 객체의 주소)
 > + 스레드별 독립적
 > + int x = 10; 같은 지역변수


### 1. Thread 생성방법
 #### (1) Thread 상속
   > ```java
   > class MyThread extends Thread {
   >  public void run() {
   >      System.out.println("Thread 실행");
   >  }
   > }
   > MyThread t = new MyThread();
   > t.start(); // run() 호출 X, start() 호출 O
   > ```

 #### (2) Runnable 구현
   > ```java
   > class MyRunnable implements Runnable {
   >  public void run() {
   >      System.out.println("Runnable Thread 실행");
   >  }
   > }
   > Thread t = new Thread(new MyRunnable());
   > t.start();
   > ```

 #### (3) 차이점
  + **Thread 상속**
   > + Thread 클래스 확장해서 run()구현
   > + 단일 상속 제한 때문에 다른 클래스를 동시에 상속 불가
   > + 각각 생성한 Thread 객체는 독립적 -> 서로의 자원이 독립적(공유하지 않음)
   > + 예
   >> ```java
   >> MyThread t1 = new MyThread();
   >> MyThread t2 = new MyThread();
   >> // t1,t2는 별도의 객체, 공유 자원 없음
   >> ```

  + Runnable 구현
   > + Runnable 인터페이스를 implements해서 run()구현
   > + 다른 클래스를 상속 가능 -> 다중 상속 효과
   > + 하나의 Runnable 객체를 여러 Thread에 전달 가능 -> Thread 간 Runnable객체의 자원 공유 가능
   >> ```java
   >> class MyRunnable implements Runnable {
   >>     private int count = 0; // Runnable 객체 내부 필드  >> 
   >>     @Override
   >>     public void run() {
   >>         for(int i = 0; i < 1000; i++) {
   >>             count++;
   >>         }
   >>         System.out.println(Thread.currentThread().getName() + ": " + count);
   >>     }
   >> }  
   >> 
   >> public class Main {
   >>     public static void main(String[] args) throws InterruptedException {
   >>         MyRunnable r = new MyRunnable();  
   >>         Thread t1 = new Thread(r, "Thread1");
   >>         Thread t2 = new Thread(r, "Thread2");  
   >>         t1.start();
   >>         t2.start();   
   >>         t1.join();
   >>         t2.join();   
   >>         System.out.println("최종 count: " + r.count);
   >>     }
   >> }
   >> ```

### 2. Thread 동작 원리
 + **상태(State)**
   > 1. **`New`** : Thread 객체 생성
   >> ```java
   >> Thread t = new Thread(()->System.out.println("Hello Thread"));
   >> // t 상태는 New
   >> ```
   > 
   > 2. **`Runnable`** : 실행 준비, 스케줄링 대기
   >> ```java
   >> Thread t = new Thread(() -> System.out.println("Hello Runnable"));   
   >> t.start(); // Runnable 상태, 스케줄러 대기
   >> ```
   > 
   > 3. **`Running`** : CPU할당, 실행 중
   >> ```java
   >> Thread t = new Thread(() -> {
   >>     for(int i = 0; i < 5; i++) {
   >>         System.out.println(Thread.currentThread().getName() + " 실행 중: " + i);
   >>     }
   >> });
   >> t.start(); // Runnable -> Running 상태로 CPU가 할당될 때
   >> ```
   > 
   > 4. **`Waiting/Blocked`** : 다른 스레드 완료 대기
   >> ```java
   >> // Waiting 예시
   >> synchronized(obj) {
   >>  obj.wait(); // 다른 스레드 notify() 호출 전까지 대기
   >> }
   >>
   >> // Blocked 예시
   >> synchronized(obj) {
   >>  // 이미 다른 스레드가 synchronized 사용 중이면 Blocked 상태로 대기
   >> }
   >> ```
   > 
   > 5. **`Terminated`** : 실행 완료
   >> ```java
   >> Thread t = new Thread(() -> System.out.println("종료"));
   >> t.start();
   >> t.join(); // t 스레드 종료까지 기다림
   >> // t 상태는 Terminated
   >> ```

 + `run()` 메서드
   > + Thread를 상속하거나 Runnable을 구현할 때 실제 실행할 작업 내용을 정의하는 메서드
   > + run()을 직접 호출하면 새로운 스레드가 아닌, 현재 스레드에서 그냥 메서드 호출처럼 실행됨
   > + start()호출없이 run()만 실행하게 되면 순차적으로 실행됨 -> 병렬적 실행 x
   >> ```java
   >> MyThread t = new MyThread();
   >> t.run(); // 새로운 스레드 생성 X, 현재 스레드에서 실행
   >> ```

 + `start()` 메서드
   > + 새로운 스레드를 생성하고 스케줄러에 등록
   > + JVM이 스케줄링하여 CPU를 할당하면, 해당 스레드에서 자동으로 run()이 호출
   > + start()명령을 호출하면 스레드를 스케줄러에 등록을 하고, 이후 스케줄러 정책에 따라 CPU가 스레드를 배정이하면 JVM이 자동적으로 run()을 실행
   >> ```java
   >> MyThread t = new MyThread();
   >> t.start(); // 새로운 스레드 생성, run() 자동 호출
   >> ```


### 3. Thread 종류
 + **사용자(User) Thread**
   > + 애플리케이션 실행 완료까지 계속 실행
   > + 사용자가 보통 만드는 일반적인 스레드
   > + 프로그램의 실행 흐름 담당

 + **데몬(Daemon) Thread**
   > + 백그라운드에서 실행
   > + 모든 사용자 Thread 종료 시 자동 종료
   > + ex : GC 스레드

 + 차이점
   > + `사용자 스레드`는 **메인 작업을 담당하고 foreground 실행**이지만, `데몬 스레드`는 **보조 작업을 담당하고 background실행**
   > + `사용자 스레드`는 **작업이 끝날 때까지 실행**을 보장하지만, `데몬 스레드`는 모든 **사용자 스레드가 종료되면 자동으로 종료**됨.


### 4. Thread 안전(Thread Safety)
 + **문제 상황** : 여러 **스레드가 동시에 공유 자원 접근**
 + **문제 발생** : **데이터 불일치**
 + **해결 방법** 
   > + `synchronized` 키워드 : **메서드/블록 동기화** -> 한 스레드가 synchronized 블록에 들어가면, 같은 객체에 대해 다른 스레드는 그 블록에 접근 불가 / 다른 객체나 synchronized 없는 코드는 접근 가능
   >> ```java
   >> class Counter {
   >>    private int count = 0;
   >> 
   >>    public synchronized void increment() {
   >>        count++;  // 동기화된 영역
   >>    }
   >> 
   >>    public int getCount() {
   >>        return count;  // 동기화 안 됨
   >>    }
   >> }
   >> 
   >> public class Main {
   >>     public static void main(String[] args) {
   >>         Counter c = new Counter();
   >>       Thread t1 = new Thread(() -> {
   >>             for(int i=0; i<1000; i++) c.increment();
   >>         });
   >> 
   >>       Thread t2 = new Thread(() -> {
   >>             for(int i=0; i<1000; i++) c.increment();
   >>         });
   >> 
   >>       t1.start();
   >>       t2.start();
   >>       // t1이 실행 중일 때 t2에서 increment()에 접근 불가, getCount()는 접근 가능
   >>     }
   >> }
   >> ```
   > + `Lock` 인터페이스 : ReentrantLock 등 -> 사용자가 락,해제 시점을 설정 가능
   > + `Concurrent` 컬렉션 : `ConcurrentHashMap`, `CopyOnWriteArrayList`


 + **Synchronized vs Lock**
   > + `Synchronized`는 **JVM이 자동으로 락을 걸고 해제**
   > + `Lock`인터페이스는 프로그래머가 **직접 언제 락(lock())을 걸고, 언제 해제(unlock())할지 결정**
   >> ```java
   >> lock.lock();   // 락 걸기
   >> // 임계영역 코드
   >> lock.unlock(); // 락 해제
   >> ```

 + **Concurrent**
  > + **멀티스레드 환경에서도 안전하게 동작하도록 설계된 컬렉션**
  > + 스레드 안전하게 구현되어 있어서, 별도의 synchronized없이 여러 스레드가 동시에 읽고/쓰기 가능
  > + 기존 `HashMap`, `ArrayList` 등은 여러 스레드가 동시에 접근하면 데이터가 꼬일 수 있음 -> 동기화 필요
  >> ex : `ConcurrentHashMap`, `CopyOnWriteArrayList`, `CopyOnWriteArraySet`