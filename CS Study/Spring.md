# Spring 핵심 개념

## Spring
 + **Java 기반의 경량 애플리케이션 프레임워크**
 + 애플리케이션 개발 시 반복되는 **객체 생성, 관리, 트랜잭션 처리, 공통 관심사 처리** 등을 쉽게 해줌
 + 개발자가 직접 "객체 생성, 의존성 관리, 트랜잭션 관리, AOP 등"을 구현할 필요 없이 Spring이 대신 처리

 + **Spring이 제공하는 핵심기능**
     > 1. **IoC/DI** : 객체 생성과 의존성 주입을 자동화
     > 2. **AOP**(Aspect-Oriented Programming) : 로깅, 트랜잭션, 보안 등 공통 관심사 분리
     > 3. **트랜잭션 관리** : 선언적 트랜잭션(@Transactional)
     > 4. **MVC 웹 프레임워크** : Spring MVC
     > 5. **데이터 접근 편의** : Spring Data, JDBC Template
     > 6. **테스트 지원** : Mock Bean 주입, 단위 테스트 용이

 + **Spring 사용 이유**
     > 1. **객체 관리와 결합도 낮추기**
     >> + 전통적인 Java는 `new`로 직접 객체 생성 -> 의존성 강함 -> 테스트 어려움, 유지보수 힘듬
     >> + Spring은 IoC/DI로 객체 생성/주입을 Spring이 담당하기 때문에 **클래스 간 결합도가 낮음**

     > 2. **반복 코드 최소화**
     >> + 트랜잭션, 예외 처리, 로깅 등을 매번 작성하지 않아도 됨 -> 코드 간결
     
     > 3. **확장성과 테스트 용이성**
     >> + DI 덕분에 Mock 객체 주입 가능 -> 단위 테스트 편리
     >> + AOP 덕분에 공통 로직 쉽게 적용 -> 기능 추가/ 변경 유연
     
     > 4. **유지보수 & 재사용성**
     >> + Bean과 공통 로직 분리 -> 기능 확장, 코드 재사용 간단

## IoC / DI

### IoC(Inversion of Control, 제어 역전)
 + 객체가 자**기 스스로 다른 객체를 생성하고 관리**하면, 객체 간 **결합도가 높아지고 테스트/확장이 어려워짐.** (최적은 결합도가 낮고, 응집도가 높은것을 목표로 함)
 + IoC는 `누가 객체를 만들고 관리할지`를 **프레임워크에 맡기는 것**
 + 객체가 스스로 의존성을 찾지 않고, 필요한 것을 외부에서 받게 됨
 + **객체 생성의 주체를 개발자가 아니라 Spring이 갖게 되는것**

### DI(Dependency Injection, 의존성 주입)
 + IoC의 구체적인 방법 중 하나로, **필요한 객체를 외부에서 주입하는 것**
 + ex :
    > ```java
    > @Service
    > public class UserService {
    >     private final UserRepository userRepository;
    > 
    >     @Autowired  // DI: Spring이 UserRepository를 넣어줌
    >     public UserService(UserRepository userRepository) {
    >         this.userRepository = userRepository;
    >     }
    > }
    > ```
 
 + **주입 방식**
     > + **생성자 주입** -> 가장 권장, 불변성을 보장하고 테스트 용이
      >> + 예시 
       >>> ```java
       >>> @Service
       >>> public class UserService {
       >>>     private final UserRepository userRepository;
       >>> 
       >>>     // 생성자를 통해 의존성 주입
       >>>     @Autowired  // Spring 4.3 이후 생략 가능, 단 생성자가 하나일 경우
       >>>     public UserService(UserRepository userRepository) {
       >>>         this.userRepository = userRepository;
       >>>     }
       >>> }
       >>> ```
      >> + **특징** : 
      >>> + **불변성 보장** : final 필드 사용 가능
      >>> + **테스트 용이** : Mock 주입 가능
      >>> + **순환 의존성 발생 시 컴파일 시점에서 오류**
      >> +  **동작** :
      >>> 1. Spring이 `UserRepository` Bean을 찾아 생성
      >>> 2. `UserService` 생성자 호출 시 자동으로 주입
      >>> 3. `UserService` 완전 초기화

     > + **필드 주입** -> 편리하지만 테스트가 어려움
      >> + 예시
       >>> ```java
       >>> @Service
       >>> public class UserService {
       >>>     @Autowired
       >>>     private UserRepository userRepository;  // Spring이 직접 주입
       >>> }
       >>> ```
      >> + **특징** 
       >>> + 코드가 간단 : 선언만 하면 됨
       >>> + 테스트가 어려움 : private 필드이므로 Mock 주입 시 Reflection 필요
       >>> + 순환 의존성 해결 어려움
       >>> + **`@PostConstruct`가 선언된 메서드 이후부터는 필드 사용 가능**
      >> + **동작**
       >>> 1. Spring이 Bean 생성 후 Reflection을 통해 필드에 의존성 주입
       >>> 2. 생성자에서는 아직 주입되지 않음 -> 초기화 시점 주의 필요

     > + **Setter 주입** -> 선택적 의존성 주입 가능
      >> + 예시
       >>> ```java
       >>> @Service
       >>> public class UserService {
       >>>     private UserRepository userRepository;
       >>> 
       >>>     @Autowired
       >>>     public void setUserRepository(UserRepository userRepository) {
       >>>         this.userRepository = userRepository;
       >>>     }
       >>> }
       >>> ```
      >> + **특징** 
       >>> + 선택적 의존성 주입 가능 (null 허용)
       >>> + 테스트 용이 : Mock 주입 가능
       >>> + 순환 의존성 일부 해결 가능
      >> + **동작** 
       >>> 1. Spring이 Bean 생성
       >>> 2. Setter 메서드를 호출하며 의존성 주입

### Bean
 + **Spring 컨테이너가 관리하는 객체**
 + Spring이 **생성, 초기화, 의존성 주입, 소멸까지 관리하는 객체**
 + `@Component`, `@Service`, `@Repository`, `@Controller` 등 어노테이션을 통해 Bean 등록
 + Spring이 컨테이너 시작 시 이 클래스 객체를 생성하고 관리 
 
 + **Bean 등록 방법**
     > 1. 어노테이션 기반
      >> ```java
      >> @Component
      >> @Service
      >> @Repository
      >> @Controller
      >> ```
     > 2. Java Config
      >> ```java
      >> @Configuration
      >> public class AppConfig {
      >>     @Bean
      >>     public UserService userService() {
      >>         return new UserService(userRepository());
      >>     }
      >> 
      >>     @Bean
      >>     public UserRepository userRepository() {
      >>         return new UserRepository();
      >>     }
      >> }
      >> ```
     > 3. XML 기반 (과거)
      >> ```xml
      >> <bean id="userService" class="com.example.UserService"/>
      >> ```

 + Bean 특징
     > + **싱글톤 기반** : 동일한 Bean을 여러 곳에서 공유
     > + **Spring이 생성/소멸 관리**
      >> + 초기화 시점 : 생성 -> 의존성 주입 -> `@PostConstruct` 호출
       >>> + `@PostConstruct` : Spring Bean이 생성되고 의존성(DI)를 모두 주입 받은 직후 호출
      >> + 소멸 시점 : `@PreDestroy` 호출
       >>> + `@PreDestroy` : Spring 컨테이너가 종료될 떄 자동 호출되며, Bean이 컨테이너에서 제거되기 직전 호출.
     > + **DI가능** : 다른 Bean을 의존성으로 주입 받을 수 있음
 
 #### 빈 컨테이너(Bean Container)
  + **Spring이 Bean을 생성, 관리, 소멸, 의존성 주입(DI)까지 담당하는 객체 저장소**
  + Spring이 모든 Bean을 모아두고 관리하는 공간
  
  + 역할
   > 1. Bean의 생성, 초기화, 소멸 관리
   > 2. 의존성 주입(DI)
   > 3. Bean 검색/조회
   > 4. Bean Scope 관리 (Singleton, Prototype 등)
  
  + **종류**
   > 1. **BeanFactory**
    >> + Spring의 최초 Bean 컨테이너
    >> + 지연 로딩(Lazy Loading) 방식
     >>> + Bean 을 실제로 요청할 때 생성
    >> + 단순하고 가볍지만, 많은 기능이 부족
    >> + 거의 직접 사용하지 않고, 내부적으로 ApplicationContext가 BeanFactory 기능을 포함 
   > 2. **ApplicationContext**
    >> + BeanFactory를 확장한 완전한 컨테이너
    >> + 즉시 로딩(Eager Loading) 방식
     >>> + 컨테이너 시작 시점에 Bean 생성 
    >> + 애플리케이션 전체 기능 제공 (이벤트, 메시지, AOP 지원 등)
 
  + **특징**
   > + **싱글톤 기본** : ApplicationContext는 기본적으로 Singleton Bean관리
   > + **DI 지원** : 컨테이너가 필요한 Bean을 자동으로 주입
   > + **생명주기 관리** : Bean 생성 -> DI -> @PostConstruct -> 사용 -> @PreDestroy
   > +  **Bean Scope관리** : Singleton, Prototype, Request, Session 등

 #### Bean Scope
 + Bean의 생존 주기와 공유 범위
     > + `싱글톤(Singleton)` : 컨테이너 당 1개만 생성 (기본값)
     >> + 컨테이너 종료 시 destroy 호출
     > + `프로토타입(Prototype)` : 요청 시마다 각 새 객체 생성
     >> + Spring이 생성만 하고 관리하지 않기 때문에 destroy메서드 호출 안됨 -> 직접 정리 필요
     > + `요청(Request)` : HTTP 요청 시마다 새 객체 (웹전용)
     > + `세션(Session)` : HTTP 세션 당 객체 하나 (웹전용)

 #### Bean Lifecycle
  1. Spring이 Bean생성
  2. 의존성 주입(DI)
  3. 초기화 (`@PostConstruct` 또는 `InitializingBean`)
  4. 사용
  5. 소멸 (`@PreDestroy` 또는 `DisposableBean`)


### 트랜잭션(Transaction)
 + **DB 작업을 하나의 원자적 단위로 묶어서 처리**
 + 여러 작업을 하나로 묶어서 **모두 성공하거나 모두 실패하도록 처리**
 + 실패 시 **모든 작업 롤백 가능** -> 데이터 일관성 유지
 + **ACID**
     > + `Atomicity(원자성)` : 모든 작어비 성공하거나 실패
     > + `Consistency(일관성)` : 트랜잭션 수행 후 데이터 무결성 보장
     > + `Isolation(독립성)` : 동시에 수행되는 트랜잭션간 간섭 방지
     > + `Durability(지속성)` : 커밋 후 데이터는 영구 저장
 
 + **트랜잭션 처리 방법**
     > 1. **선언전 트랜잭션**
      >> 예시
       >>> ```java
       >>> @Service
       >>> public class UserService {
       >>> 
       >>>     @Transactional
       >>>     public void registerUser(User user) {
       >>>         userRepository.save(user);
       >>>         mailService.sendWelcomeEmail(user); 
       >>>     }
       >>> }
       >>> ```
      >> + ``@Transactional``을 붙이면 Spring이 AOP를 이용해 트랜잭션 처리
      
      >> + 장점
       >>> 1. 코드 간결 -> 트랜잭션 시작/커밋/롤백 자동 처리
       >>> 2. 비즈니스 로직에 집중 가능
      
      >> + **Rollback 정책**
       >>> + 기본 : Unchecked Exception(RuntimeException, Error) 발생 시 롤백
       >>> + Checked Exception도 롤백 가능 : `@Transactional(rollbackFor = Exception.class)`

     > 2. **전파(Propagation)**
      >> + 전파 : **트랜잭션이 다른 트랜잭션 안에서 호출**될 때 동작 방식
       >>> + `REQUIRED` : 기존 트랜잭션이 있으면 참여, 없으면 새로 생성
       >>> + `REQUIRES_NEW` : 항상 새 트랜잭션 생성, 기존 트랜잭션과 독립
       >>> + `SUPPORTS` : 트랜잭션이 있으면 참여, 없으면 그냥 실행
       >>> + `NOT_SUPPORTED` : 트랜잭션 있으면 잠시 중단 후 실행
       >>> + `MANDATORY` : 트랜잭션 있어야 함, 없으면 예외
       >>> + `NEVER` : 트랜잭션 있으면 제외
       >>> + `NESTED` : 기존 트랜잭션 내에서 중첩 트랜잭션 실행 가능

 + **트랜잭션 동작 원리(Spring)**
     > 1. @Transactional 적용 메서드 호출
     > 2. AOP 프록시가 트랜잭션 시작
     > 3. 메서드 실행
      >> + 정상 종료 -> Commit
      >> + 예외 발생 -> Rollback (Unchecked Exception 기본)
     > 4. 트랜잭션 종료

 + **Spring 트랜잭션 특징**
     > + **DB 작업뿐만 아니라 다른 리소스 연계 가능**
      >> + JMS, 메시지 큐, 파일 작업 등도 트랜잭션으로 묶어서 처리 가능
     
     > + **프록시 기반 동작**
      >> + JDK 동적 프록시 : 인터페이스 기반, 인터페이스 타입으로 Bean 호출해야 AOP적용
      >> + CGLIB : 클래스 상속 기반, 클래스 타입으로 호출 가능(인터페이스 필요 없음)

     > + **프로그래밍 방식(직접 트랜잭션 관리) vs 선언전 트랜잭션**
      >> + 선언적(`@Transactional`) 권장, 코드가 간결하고 유지보수 용이
     
     > + **내부 호출은 같은 트랜잭션 안에서는 실행됨** 
      >> + 별도의 트랜잭션 적용이 안 됨

 + **프록시(Proxy)**
     > + **대상 객체(실제 객체)를 감싸는 대리 객체**
     > + 대리 객체를 토앻 원래 객체의 메서드를 호출하면서 추가 기능 수행 가능

     > + Spring 트랜잭션과 프록시
      >> + `@Transactional` 붙은 메서드를 호출하면 Spring이 프록시 객체 생성
      >> + **실제 호출 흐름**
       >>> 1. 클라이언트 -> 프록시 호출
       >>> 2. 프록시 -> 트랜잭션 시작
       >>> 3. 실제 Bean 메서드 호출
       >>> 4. 메서드 정상 종료 -> 커밋
       >>> 5. 예외 발생 -> 롤백

     > + 주의점
      >> 1. 같은 클래스 내부 호출 시 프록시를 거치지 않음
       >>> ```java
       >>> @Transactional
       >>> public void methodA() {
       >>>     methodB(); // 같은 클래스 내부 호출 → 트랜잭션 적용 안 됨
       >>> }
       >>> ```

      >> 2. 프록시 객체로 호출해야 `@Transactional`이 정상 동작

### AOP (Aspect Oriented Programming)
 + **공통 관심사항을 비지니스 로직과 분리**
 + 예 : 로깅, 트랜잭션, 인증/인가, 성능 모니터링

 + **동작 원리**
     > 1. Spring이 **Proxy 객체 생성**
      >> + **JDK Proxy** : 인터페이스 기반
      >> + **CHLIB** : 클래스 기반 (인터페이스 없어도 가능)
     > 2. **Advice** : 공통로직 **코드**
     > 3. **JoinPoint** : 공통로직 **적용 위치**
     > 4. **Pointcut** : 공통로직 **적용 조건**

 + Proxy기반에서는 클래스 내부 메서드 호출은 AOP 적용 안됨
     > + 자기 자신 메서드 호출은 프록시를 거치지 않아서 AOP적용 안됨