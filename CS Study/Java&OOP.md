# 1. Java & Spring

## <1> Java 기본 & OOP

### (1) Java
+ **정의** : 객체 지향 기반 범용 프로그래밍 언어

+ **특징** : 안정적, 메모리 관리 자동(GC) , 풍부한 라이브러리, 멀티플랫폼 지원

+ **자바 컴파일 과정**
> 1. 개발자가 ``.java``파일 작성
> 2. **javac 컴파일러**가 코드 분석
>> + 문법체크, 타입 검사 등
> 3. **.class 파일(바이트코드) 생성**
>> + ``CPU/OS에 종속적이지 않은(독립적)`` 중간 언어
>> + JVM이 읽을 수 있는 명령어 집합


+ **WORA(Write Once, Run Anywhere)**
> + **의미** : 한 번 작성한 코드가 여러 플랫폼에서 그대로 실행 가능 (플랫폼 독립적)
> + **가능한 이유** : 
>> + Java코드는 ``바이트코드(.class)``로 **컴파일**됨
>> + JVM이 ``OS와 CPU환경에 맞게`` 기계어로 변환
>> + JIT(Just-In-Time) Complier 사용 -> 성능 향상
> + **예시** : "Hello World"코드 -> JVM -> CPU에 맞는 기계어 -> 화면 출력 

+ **JVM 동작원리**
> + **Class Loader** : ``.class 파일`` 메모리 **로딩**
> + **ByteCode Verifier** : 유효성 검사(타입체크, 메모리 안전) -> **안전성 확인**
> + **Execution Engine** : **바이트 코드 실행**
>> + **InterPreter** : 한 줄씩 실행 ->  느림
>> + **JIT Compiler** : Host Spot 코드 -> 기계어 최적화 -> 빠름
>>> + Just-In-Time 컴파일러
>>> + 반복 실행되는 Hot Spot 코드를 런타임에 기계어로 변환
>>>> + **Hot Spot 코드** = 프로그램 실행 중 자주 반복해서 실행되는 코드
>>> + 성능 최적화 : 인라인, 루프 최적화, 레지스터 활용
> + **RunTime Data Area** : Mehtod Area, Heap, Stack, PC Register, Native Method Stack
>> + **Method Area** : 클래스별 정보와 메서드 코드, 상수 static변수 등을 저장
>> + **Stack** : 메서드 호출, 지역변수 관리
>> + **Heap** : 객체 저장
>> + **PC Register** : 현재 실행 위치 추적
>> + **Native Method Stack** : 네이티브 코드 호출
> + **GC** : Heap관리, 사용하지 않는 객체 제거 -> **메모리 효율적으로 관리**

+ **GC(Garbage Collector)**
 1. **GC정의**
 > + JVM이 **Heap에 있는 사용하지 않는 객체를 자동으로 제거**하여 메모리를 효율적으로 관리하는 기능
 > + 수동으로 메모리를 해제할 필요가 없음

 2. **GC 동작 방식**
 > 1. **Mark & Sweep**
 >> + **Mark** : 도달 가능한 객체 표시
 >> + **Sweep** : 표시되지 않은 객체 제거
 >
 > 2. **Generational GC**
 >> + 객체의 생존 기간에 따라 영역 분리
 >>> + **Young Generation** : 새로 생성된 객체로 ``Minor GC`` 발생 
 >>> + **Old Generation** : 오래 살아남은 객체로 ``Major GC`` 발생
 >> + 새로 생성된 객체 대부분 금방 사라지므로, Young 영역만 자주 GC가 발생하여 효율적임

 > 3. **GC Algorithm**
 >> + **Serial GC** : 단일 스레드, 작은 앱에 적합
 >> + **Parallel GC** : 멀티스레드, CPU 활용 -> 서버 환경
 >> + **Concurrent Mark Sweep (CMS)** : 애플리케이션과 동시에 GC 수행
 >> + **G1 GC** : 영역 기반, 대규모 Heap에 최적화, Predictable pause time
 
 3. GC 특징
 > + Stack에 참조되는 객체는 GC 대상에서 제외
 > + GC 발생 시 애플리케이션 일시 정지 기능(Stop-the-world)
 > + 강제로 GC호출 : ``System.gc()`` 가능하지만 권장하지 않음

 4. 효율적 관리
 > + 객체 재사용,, 불필요 객체 생성 최소화 -> GC 부담 감소
 > + JVM 옵션으로 GC 튜닝 가능 (``-Xmx``,``-Xms``,GC 종료 지정)
 > + 메모리 누수 확인 : 프로파일러 사용(VisualVM, Jprofiler 등)


+ **프로파일러(Profiler)**
 + 프로그램을 실행하면서 **성능, 메모리, CPU 사용량, 객체 생성/소멸 등을 분석**하는 도구
 + **목적** : 병목 구간 찾기, 메모리 누수 탐지, 성능 최적화
 + **종류**
 > + **VisualVM** : JVM 내장, Heap/Thread/CPU 분석 가능
 > + **JProfiler** : 상용, 상세 분석, 실시간 모니터링
 > + YourKit : 상용, 성능 분석 강력
 > + Flight Recorder/ Mission Control : Java11이상, 실시간 분석


+ **JDK / JRE / JVM**
> + JDK : 개발 키트, 컴파일러 포함
> + JRE : Java 실행 환경
> + JVM : 바이트코드를 기계어로 변환해 실행

---

### (2) OOP (객체지향 프로그래밍)
+ **정의** : 프로그램을 **객체 단위로 설계하고 구현**하는 프로그래밍 패러다임

+ **객체** = ``데이터(속성) + 기능(메서드)``을 함께 가짐

+ **장점** : 코드 재사용, 유지보수 용이, 현실 세계 모델링

+ **4대 원칙**
 + 1. **캡슐화(Encapsulation)**
    > + 객체 내부 상태를 보호하고 외부 접근 제한
    > (ex) : ``private`` 필드 + ``getter/setter``

 + 2. **상속(Inheritance)**
    > + 기존 클래스 기능을 재사용하고 확장
    > + ``extends``
    > (ex) : ``class Admin extends Uses { } ``

 + 3. **다형성(Polymorphism)**
    > + 같은 타입으로 여러 객체를 처리 가능
    > (ex) : ``User u = new Admin();`` ``u.login();``

 + 4. **추상화(Abstraction)**
    > + 구체적 구현을 숨기고 기능만 제공
    > + ``implements``는 추상화 구현
    > (ex) ``abstract class User`` / ``interface Loginable``

+ **클래스 & 객체**
 + **클래스**
    > + 설계도, 객체 생성 템플릿
    > (ex) ``class User { String name; void login(){} }``
 + **객체**
    > + 메모리에 생성된 인스턴스
    > (ex) ``User u = new User() ; u.login();``

+ **추상클래스 & 인터페이스**
 + **추상클래스**
    > + 일부 구현 가능, 상태 필드 가짐, 단일 상속

 + **인터페이스**
    > + 구현 없는 메서드 선언, 다중 상속 가능, 설계 표준화

+ **메서드 오버로딩 & 오버라이딩**
 + **오버로딩(Overloading)**
    > + 같은 이름의 메서드를 **매개변수 타입이나 개수로 구분**하여 여러개 정의
    > + 호출할 메서드를 컴파일 시점에 결정 -> 컴파일 타임 다형성
    > + 반환 타입만 다른 경우는 불가
    >> ```java
    >>    class Calculator {
    >>      int add(int a, int b) { return a + b; }
    >>      double add(double a, double b) { return a + b; }
    >>      int add(int a, int b, int c) { return a + b + c; }
    >>    }
    >> ```
 
 + **오버라이딩(Overriding)**
    > + 상속받은 부모 클래스 메서드를 **자식 클래스에서 재정의**
    > + 런타임 시 실제 객체 타입에 따라 메서드 호출 -> 런타임 다형성
    > + ``super``키워드로 부모 메서드 호출 가능
    >> ```java
    >> class User {
    >> void login() { System.out.println("User 로그인"); }
    >> }
    >> 
    >> class Admin extends User {
    >>     @Override
    >>     void login() { System.out.println("Admin 로그인"); }
    >> }
    >> 
    >> User u = new Admin();
    >> u.login(); // Admin 로그인 출력 (런타임 다형성)
    >> ```


+ **접근 제어자**
 + **캡슐화 구현의 핵심** : 객체 내부 데이터보호, 외부 접근 제한
 
 + **종류**
    > + **``private``**
    >> + 같은 클래스 내에서만 접근 가능
    > + **``default``**
    >> + 접근 제어자 미설정 시 적용
    >> + 같은 패키지 내에서 접근 가능
    > + **``protected``**
    >> + 같은 클래스, 같은 패키지, 상속받은 자식 클래스에서 접근 가능
    > + **``public``**
    >> + 모든 곳에서 접근 가능