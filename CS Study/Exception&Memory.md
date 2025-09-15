# Exception & Memory

## 예외(Exception)
 + 프로그램 실행 중 **비정상적 상황**을 의미
 + 발생하면 해당 코드 이후 로직이 정상적으로 실행되지 않을 수 있음 => 예외 처리를 통해 안정성 확보
 + 예외 발생 시 , **JVM은 해당 스레드의 스택(stack) 정보를 이용해 예외 발생 위치를 추적**
 + 예외 처리를 하지 않으면 **스택 메모리에 쌓인 호출 정보(stack trace)가 남고, 프로그램은 비정상 종료**


### Error
 + **JVM레벨에서 발생하는 심각한 문제**
 + 애플리케이션 코드로는 복구 불가능
 + 보통 프로그램이 그대로 종료되거나, 프로세스를 재시작해야 함
 + ex : `OutOfMemoryError`, `StackOverflowError`, `InternalError`
 
 + `Exception과` 차이 정리 : Error는 JVM 내부의 심각한 문제로 개발자가 직접 복구하기 어렵고, Exception은 프로그램 실행 중 발생하는 예외 상황으로 애플리케이션 차원에서 처리 가능


### 종류
 1. **Checked Exception**
    > + 컴파일 시 처리 강제 -> 처리하지 않으면 컴파일 실패
    > + **외부 환경과 관련된 예외**
    > + **발생하면 컴파일 단계에서 문제를 잡아야 실행 가능**
    > + Checked Exception은 스프링 같은 프레임워크는 대부분 Checked -> Unchcked 변환해서 던지기 때문에 불필요하게 try-catch가 강제되지 않도록 RuntimeException으로 감쌈
    > + ex : `IOException`, `SQLException`
 
 2. **Unchecked Exception** (RuntimeExecption 계열)
    > + 런타임 시 발생 -> 컴파일러가 체크하지 않음
    > + **프로그래밍 오류로 인한 예외**
    > + **발생해도 컴파일은 통과, 런타임 시점에서 해당 예외가 발생하면 그 시점 이후 코드 실행 중단**
    > + ex : `NullPointerException`, `ArithmeticException`


### 예외 처리 방법
 1. **`try-catch`**
     + **예외가 발생할 가능성이 있는 코드 블록에서 즉시 처리**
     + 예외 발생 시 catch 블록으로 넘어가고, 이후 프로그램이 정상적으로 계속 실행 가능
    > ```java
    > try {
    >     int a = 10 / 0;
    > } catch(ArithmeticException e) {
    >     System.out.println("0으로 나눌 수 없습니다.");
    > }
    > ```

 2. **`throws`**
     + 예외를 **자신이 처리하지 않고 호출한 쪽으로 위임**
     + 메서드 선언에 작성 -> 호출자가 반드시 처리하거나 또 throws로 위임
     + main에서 throws문 작성시 JVM에게 예외 위임
    > ```java
    > public void readFile() throws IOException {
    >     FileReader fr = new FileReader("test.txt");
    > }
    > ```

 3. **`try-with-resources`**
     + **자원을 자동으로 닫아주고, 예외가 발생해도 안전하게 처리**
     + `AutoCloaseable` 구현 객체에 적용 -> finally 없이 자동 close
     + 컴파일러가 `close()` 호출을 try-finally로 변환해서 처리
    > ```java
    > try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
    >     String line = br.readLine();
    > } catch (IOException e) {
    >     e.printStackTrace();
    > }
    > ```


### 스택(Stack)과 예외 처리
 + **메서드 호출 시 지역변수, 매개 변수, 임시 값이 stack에 저장**
 + 예외 발생 시 **`stack trace`**는 **어떤 메서드에서 호출**되었는지를 보여줌
 + stack은 LIFO 구조 -> 가장 최근 호출한 메서드부터 추적
 
 + 예시
    > ```java
    > void methodA() { methodB(); }
    > void methodB() { int x = 1 / 0; }
    > ```
    >> + `ArithmeticException`발생 -> JVM이 stack trace를 통해 `methodB -> methodA` 호출 경로를 표시

 + **`stack trace`**
    > + 예외가 발생했을 때, JVM이 스택에 쌓인 호출 정보를 순서대로 보여주는 것
    > + **예외 발생 위치(라인), 메서드 호출 순서, 클래스 정보** 등이 포함

---

## 메모리(Memory)

### JVM 메모리 구조
 1. **Stack(스택)**
    > + **메서드 호출 시 생성되는 메모리 영역**
    > + **지역변수, 매개 변수, 임시 값, 객체 주소** 저장
    > + 각 스레드마다 독립적으로 존재
    > + LIFO 구조 : 마지막 호출한 메서드가 가장 먼저 반환
    > + 예외 발생 시 **stack trace** 기록 -> 어디서 예외 발생했는지 추적 가능
    > + 자동 해제 : 메서드 종료 시 스택 프레임 제거
 
 2. **Heap(힙)**
    > + **동적 메모리 영역**
    > + **객체, 배열, 컬렉션** 등 저장
    > + 여러 스레드가 **공유** 가능
    > + `new`키워드로 객체 생성 시 할당
    > + 예외 발생 시에도 힙 메모리는 유지 -> GC 필요
    > + 참조가 남아있다면 객체는 삭제되지 않고 메모리 누수 가능

 3. **Method Area(메소드 영역)**
    > + 클래스 정보, 상수, static 변수, 메서드 코드 등 저장 공간
    > + JVM이 프로그램 실행 시 클래스 로딩 시점에 생성
    > + JVM 종료시 자동 제거, 개발자가 직접 삭제 불가
    > + 내부에 **Runtime Constant Pool** 존재
         > + **문자열 리터럴과 상수를 저장**하는 공간
         > + 같은 내용의 문자열이나 상수는 한 번만 저장되고, 여러 곳에서 공유 가능 => **같은 문자열을 반복 생성해도 실제 메모리는 한 개만 쓰고 주소만 공유**

### Heap 내부 세분화
 1. **Young Generation**
     + **Eden 영역** : 새로 생성된 **객체가 처음 할당되는 영역**
      > + 대부분의 객체가 여기서 생성-> 긍방 사라지는 객체 많음
    
     + **Survivor 영역(S0,S1)** : **Eden에서 살아남은 객체를 잠시 저장**
      > + GC이후 Eden에서 살아남은 객체를 한 쪽 Survivor로 이동
      > + 두 영역은 번갈아가며 사용
     
     + 특징 : Minor GC 자주 발생, GC 비용 낮음

 2. **Old Generation**
     + Young Gen에서 오래 살아남은 객체가 이동
     + GC 발생 빈도 낮음 -> Major GC
     + Major GC 비용 큼, 멈춤 시간(Stop-The-World) 길어짐 

 3.  **Permanent Generation / Metaspace**
     + 클래스 정보, 메서드 코드, static 변수, 런타임 상수 풀 저장
     + Java 8 이전 : Permanent Generation
     + Java 8 이후 : Metaspace(네이티브 메모리 사용)

### Runtime Constant Pool
 + 문자열 리터럴, 상수 등 관리



### 가비지 컬렉션(GC)
 + 힙에 있는 사용하지 않는 개체 자동 제거
 
 + 목적 : 메모리 누수 방지, OOM 방지
 
 + 주요 방식
    > 1. **Mark & Sweep**
        > 1. **Mark 단계** : 현재 사용중인(참조가 있는) 객체를 표시
        > 2. **Sweep 단계** : 표시되지 않은(참조되지 않은) 객체 제거
        > + 장점 : 단순하고 안정적
        > + 단점 : Heap이 파편화(fragmentation)될 수 있음
    
    > 2. **Generational GC** 
        > + 객체의 생존 기간에 따라 영역을 나누어 관리
        > 1. **Young 영역** : 새로 생성된 객체, GC가 자주 일어남
        > 2. **Old 영역** : 오래 살아남은 객체, GC 발생 빈도 낮음

 + `try-with-resources`는 명시적으로 자원을 해제해 참조를 줄여주기 때문에 GC가 불필요하게 객체를 오래 유지하지 않아도 됨

 + **OOM(Out of Memory)**
     + **메모리가 부족한 상태**
     + JVM이 힙 영역에 객체를 할당하려고 하는데, 힙에 여유 공간이 없어서 더 이상 객체를 생성할 수 없는 상태

 + **GC 동작**
     1. **Stop-The-World**
         + **GC가 실행**될 때 **모든 애플리케이션 스레드를 일시 정지**
         + GC가 객체를 검사, 이동, 제거하는 동안 안전하게 Heap을 관리하기 위함
         + Minor GC : 짧은 정지 시간
         + Major GC : 정지 시간이 길어 애플리케이션 성능에 약함

     2. **Minor GC**
         + Young Gen(Eden + Survivor)에서 발생
         + 짧고 자주 발생
         + 애플리케이션이 잠시 멈춤 

     3. **Major GC**
         + Old Gen에서 발생
         + 느리고 비용이 높음
         + 애플리케이션이 긴 시간 멈춤

     4. 튜닝포인트
         + **Young Gen 크기 조절 -> Minor GC 빈도 조절**
         + **Old Gen 크기 조절 -> Major GC 발생 최소화**
         + GC 로그분석, GC 정책(G1, CMS 등) 선택


### 예외와 메모리 연결
 + 예외 발생 -> 스택에 예외 정보 기록
 + 예외 처리 실패 -> 스택 unwind -> 힙 객체는 남아 있음
 + 참조가 없으면 GC 대상 -> 메모리 안전
 + 객체가 계속 참조되면 OOM 발생 가능


### 메모리 누수(Memory Leak) 케이스
 1. **컬렉션에 객체 계속 추가하고 제거 안함**
     + `List`, `Map` 같은 컬렉션은 참조를 계속 유지
     + GC는 참조가 없는 객체만 회수 가능 -> 컬렉션에 남아있는 객체는 절대 해제되지 않음
     + 결과적으로 JVM의 힙 점유가 늘어나고 OOM 발생
     + 예시
        > ```java
        > List<byte[]> list = new ArrayList<>();
        > while(true) {
        >     list.add(new byte[1024*1024]); // 계속 객체 생성, 참조 유지
        > }
        > ```
    
 2. **Static 변수에 객체 계속 참조**
     + `static` 변수는 클래스가 로딩되어 있는 동안 메모리에 상주 -> 프로그램 종료 전까지 GC가 회수하지 못함
     + 결과적으로 캐시에 불필요한 데이터가 남아 메모리 누수 발생
     + 예시
        > ```java
        > static Map<Integer, String> cache = new HashMap<>();
        > cache.put(1, "data"); // 계속 참조 유지
        > ```

 3. **Listener / Callback해제 안함**
     + **Listener**
         + **이벤트를 감지하고 처리**하는 객체
         + 주료 GUI 프로그램, 버튼 클릭, 마우스/키보드 이벤트에서 사용
         + 발신자(이벤트 발생 객체)가 수신자(리스너 객체)를 참조하여 이벤트 발생 시 메서드 호출

     + **Callback**
         + 특정 이벤트나 작업이 끝난 후 **호출되는 메서드**를 담고 있는 객체

     + GUI, 이벤트 시스템에서 리스너 등록 시 **발신자 객체가 수신자 객체를 참조** -> 수신자 객체가 더 이상 필요해도 발신자 객체가 참조를 끊지 않으면 GC 못함
     + 오래 실행되는 프로그램에서 누적 가능
     + 예시
        > ```java
        > button.addActionListener(myListener); // button이 myListener 참조
        > // button.dispose() 후에도 myListener 참조 유지
        > ```
    
 4. **Inner Class/ Anonymous Class**
     + **내부 클래스는 외부 클래스 객체 참조를 자동**으로 가지고 있기 때문에 **내부 클래스 인스턴스가 계속 참조되면 외부 클래스 객체도 GC 회수 불가**
     + 예시
        > ```java
        > class Outer {
        >     class Inner { }
        > }
        > 
        > Outer o = new Outer();
        > Outer.Inner i = o.new Inner(); // i가 참조되는 동안 o도 GC 불가
        > ```