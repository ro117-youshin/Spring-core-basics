# Spring-core-basics
스프링 핵심 원리

## Index
* [Intro 좋은 객체 지향 프로그래밍? 다형성, SOLID](https://github.com/ro117-youshin/Spring-core-basics?tab=readme-ov-file#intro)
* [관심사의 분리](https://github.com/ro117-youshin/Spring-core-basics?tab=readme-ov-file#관심사의-분리)
* [IoC, DI 그리고 컨테이너](https://github.com/ro117-youshin/Spring-core-basics?tab=readme-ov-file#IoC,-DI,-그리고-컨테이너)

---

### Intro

#### 💡 객체 지향 특징
* 추상화
* 캡슐화
* 상속
* **다형성**

#### 💡 객체 지향 프로그래밍
* 객체 지향 프로그래밍은 컴퓨터 프로그래밍을 명령어의 목록으로 보는 시각에서 벗어나 여러 개의 독립된 단위, 즉 **"객체"** 들의 **모임** 으로 파악하고자 하는 것이다. 각각의 **객체** 는 **메시지** 를 주고받고, 데이터를 처리할 수 있다. **(협력)**
* 객체 지향 프로그래밍은 프로그램을 **유연** 하고 **변경** 이 용이하게 만들기 때문에 대규모 소프트웨어 개발에 많이 사용된다.

#### 💡 다형성
다형성의 실세계 비유
* 실세계와 객체 지향을 1:1로 매칭할 수 없지만 그래도 실세계의 비유로 이해하기 좋음
* **역할** 과 **구현** 으로 세상을 구분

역할과 구현을 분리
* **역할** 과 **구현** 으로 구분하면 세상이 **단순** 해지고, **유연** 해지며 **변경** 도 편리해진다.
* 장점
  * **클라이언트**는 대상의 역할(인터페이스)만 알면 된다.
  * **클라이언트**는 구현 대상의 **내부 구조를 몰라도** 된다.
  * **클라이언트**는 구현 대상의 **내부 구조가 변경** 되어도 영향을 받지 않는다.
  * **클라이언트**는 구현 **대상 자체를 변경** 해도 영향을 받지 않는다.

역할과 구현을 분리 - Java
* Java 언어의 다형성을 활용
  * 역할 = Interface
  * 구현 = Interface를 구현한 Class, 구현 객체
* 객체를 설계할 때 **역할**과 **구현**을 명확히 분리
* 객체 설계시 역할(Interface)을 먼저 부여하고, 그 역할을 수행하는 구현 객체 만들기

#### 💡 객체의 협력이라는 관계부터 생각
* 혼자 있는 객체는 없다.
* 클라이언트: 요청, 서버: 응답
* 수 많은 객체 클라이언트와 객체 서버는 서로 협력 관계를 가진다.

#### 💡 Java 언어의 다형성
* **오버라이딩**을 떠올려보자.
* 다형성으로 인터페이스를 구현한 객체를 실행 시점에 유연하게 변경할 수 있다.
* 물론 클래스 상속 관계도 다형성, 오버라이딩 적용가능.

<p align="center">
  <img src="https://github.com/ro117-youshin/Spring-core-basics/blob/main/img/polymorphism_in_java.png" width="600" height="350"/>
</p>

<p align="center">
  <img src="https://github.com/ro117-youshin/Spring-core-basics/blob/main/img/polymorphism_in_java_2.png" width="600" height="200"/>
</p>

```java
public class MemberService {
    
    private MemberRepository memberRepository = new MemoryMemberRepository();
    ...
}
```

```java
public class MemberService {
    
    // private MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository = new JdbcMemberRepository();
    ...
}
```

<p align="center">
  <img src="https://github.com/ro117-youshin/Spring-core-basics/blob/main/img/polymorphism_in_java_3.png" width="600" height="350"/>
</p>

#### 💡 다형성의 본질
* Interface를 구현한 객체 인스턴스를 **실행 시점**에 **유연**하게 **변경**할 수 있다.
* 다형성의 본질을 이해하려면 **협력**이라는 객체사이의 관계에서 시작해야함
* **클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있다.**

#### 💡 역할과 구현을 분리
* 실세계의 역할과 구현이라는 편리한 컨셉을 다형성을 통해 객체 세상으로 가져올 수 있음
* 유연하고, 변경이 용이
* 확장 가능한 설계
* 클라이언트에 영향을 주지 않는 변경 가능
* Interface를 안정적으로 잘 설계하는 것이 중요

#### 💡 역할과 구현 분리의 한계
* 역할(Interface) 자체가 변하면, 클라이언트, 서버 모두에 큰 변경이 발생한다.
* 설계할 때, Interface를 안정적으로, 즉 가장 변화가 없게 잘 설계하는 것이 제일 중요하다.
  * 비단 Java Interface 뿐만 아니라 Server to Server에서 API를 잘 설계하는 것이 중요.

#### 💡 스프링과 객체 지향
* 다형성이 가장 중요, 객체 지향의 꽃.
* Spring은 다형성을 극대화해서 이용할 수 있게 도와준다.
* Spring에서 이야기하는 IoC(제어의 역전), DI(의존관계 주입)은 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 지원한다.
* Spring을 사용하면 마치 레고 블럭 조립하듯, 공연 무대의 배우를 선택하듯, 구현을 편리하게 변경할 수 있다.

### 🏛️ SOLID - 좋은 객체 지향 설계의 5가지 원칙

#### 1. Single Responsibility Principle, 단일 책임 원칙
* 한 클래스는 하나의 책임만 가져야 한다.
* 하나의 책임이라는 것은 모호하다.
  * 클 수도 있고, 작을 수도 있다. 문맥과 상황에 따라 다르다.
* **중요한 기준은 변경**이다. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것.
* ex) UI 변경, 객체의 생성과 사용을 분리.

#### 2. Open/Closed Principle, 개방-폐쇄 원칙
* 소프트웨어 요소는 **확장에는 열려** 있으나 **변경에는 닫혀** 있어야 한다.
* 확장을 하려면 당연히 기존 코드를 변경해야 한다? -> **다형성**을 활용해보자.
* Interface를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현.
* 위 '역할과 구현의 분리'를 생각해볼 것.

```java
public class MemberService {
//    private MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository = new JdbcMemberRepository();
}
```

_문제점_
* `MemberService` 클라이언트가 구현 클래스를 직접 선택.
  * `private MemberRepository memberRepository = new MemoryMemberRepository();` - 기존 코드
  * `private MemberRepository memberRepository = new JdbcMemberRepository();` - 변경 코드
* **구현 객체를 변경하려면 클라이언트 코드를 변경해야 한다.**
* **분명 다형성을 사용했지만 OCP 원칙을 지킬 수 없다.**
* 어떻게 해결해야 할까? 객체를 생성하고, 연관관계를 맺어주는 별도의 조립, 설정자가 필요하다.

#### 3. Liskov Substitution Principle, 리스코프 치환 원칙
* 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
* 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다는 것, 다형성을 지원하기 위한 원칙, 인터페이스를 구현한 구현체는 믿고 사용하려면, 이 원칙이 필요하다.
* 단순히 컴파일에 성공하는 것을 넘어서는 이야기.
* ex) 자동차 인터페이스의 엑셀은 앞으로 가라는 기능, 뒤로 가게 구현하면 LSP 위반, 느리더라도 반드시 앞으로 가야함.

#### 4. Interface Segregation Principle, 인터페이스 분리 원칙
* 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
* 자동차 인터페이스 -> 운전 인터페이스, 정비 인터페이스로 분리.
* 사용자 클라이언트 -> 운전자 클라이언트, 정비사 클라이언트로 분리.
* 분리하면 정비 인터페이스 자체가 변해도 운전자 클라이언트에 영향을 주지 않음.
* 인터페이스가 명확해지고, 대채 가능성이 높아짐.

#### 5. Dependency Inversion Principle, 의존관계 역전 원칙
* 프로그래머는 "추상화에 의존해야지, 구체화에 의존하면 안된다." 의존성 주입은 이 원칙을 따르는 방법 중 하나다.
* 쉽게 말해, 구현 클래스에 의존하지 말고, Interface에 의존하라는 뜻.
* 위에서 얘기한 **역할(Role)에 의존하게 해야 한다는 것과 같다.** 객체 세상도 클라이언트가 인터페이스에 의존해야 유연하게 구현체를 변경할 수 있다. 구현체에 의존하게 되면 변경이 아주 어려워진다.

```java
public class MemberService {
    
    private MemberRepository memberRepository = new MemoryMemberRepository();
    
    ...
}
```
* 위의 `MemberService`는 인터페이스(`MemberRepository`)에 의존하지만, 구현 클래스(`MemoryMemberRepository`)도 동시에 의존한다.
* **DIP 위반**

---

### 관심사의 분리
* 애플리케이션을 하나의 공연이라고 했을때, 각각 Interface를 배역(배우 역할)이라 생각하자. 그런데 실제 배역을 맡을 배우는 누가 선택하는가?
* 공연의 주연, 조연을 정하는 것은 배우가 아니다. 만약 그렇다면 남자 주연을 맡은 배우는 공연도 하고 상대 여자 주연 배우도 직접 초빙해야 하는 **다양한 책임**을 갖고 있다.

* DIP 위반 -> 추상에만 의존하도록 변경(Interface에만 의존)
* 즉, **Interface**에만 의존하도록 설계를 변경하자.

```java
public class OrderServiceImpl implements OrderService {
    // private final DiscountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;
    
    // 생성자를 통한 의존관계 주입
    public OrderServiceImpl(..., DiscountPolicy discountPolicy) {
        ...
        this.discountPolicy = discountPolicy;
    }
}
```

#### 💡 관심사를 분리하자.
* 배우는 본인의 역할인 배역을 수행하는 것에만 집중해야 한다.
* 남자 배우는 어떤 여자 배우가 와도 똑같이 공연할 수 있어야 한다.
* 공연을 구성하고, 담당 배우를 섭외하고, 역할에 맞는 배우를 지정하는 책임을 담당하는 별도의 **공연 기획자**가 나올시점이다.
* 공연 기획자를 만들고, 배우와 공연 기확자의 책임을 확실히 분리하자.

---

### IoC, DI, 그리고 컨테이너

#### 💡 제어의 역전 IoC(Inversion of Control)
* 기존 프로그램은 클라이언트 구현 객체가 스스로 필요한 서버 구현 객체를 생성하고, 연결하고 실행했다. 한마디로 구현 객체가 프로그램의 제어 흐름을 스스로 조종했다. 개발자 입장에서는 자연스러운 흐름이다.
* 반면에 `AppConfig`가 등장한 이후에 구현 객체는 자신의 로직을 실행하는 역할만 담당한다. 프로그램의 제어 흐름은 이제 `AppConfig`가 가져간다. ex) `OrderServiceImpl`은 필요한 Interface들을 호출하지만 어떤 구현 객체들이 실행될지 모른다.
* 프로그램에 대한 제어 흐름에 대한 권한은 모두 `AppConfig`가 가지고 있다. 심지어 `OrderServiceImpl`도 `AppConfig`가 생성한다. 그리고 `AppConfig`는 `OrderServiceImpl`이 아닌 `OrderService` Interface의 다른 구현 객체를 생성하고 실행 할 수도 있다. 그런 사실도 모른체 `OrderServiceImpl`은 자신의 로직을 실행할 뿐이다.
* 이렇듯 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전(IoC)이라 한다.

#### 프레임워크 vs 라이브러리
* 프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 그것은 프레임워크가 맞다.(JUnit)
* 반면에 내가 작성한 코드가 직접 제어의 흐름을 담당한다면 그것은 프레임워크가 아니라 라이브러리다.

#### 💡 의존관계 주입 DI(Dependency Injection)
* `OrderServiceImpl`은 `DiscountPolicy` Interface에 의존한다. 실제 어떤 구현 객체가 사용될지는 모른다.
* 의존 관계는 **_정적인 클래스 의존 관계_** 와, **실행 시점에 결정되는 _동적인 객체(인스턴스) 의존 관계_** 둘을 분리해서 생각해야 한다.

**_정적인 클래스 의존 관계_**

&nbsp; 클래스가 사용하는 `import` 코드만 보고 의존관계를 쉽게 판단할 수 있다. 정적인 애플리케이션을 실행하지 않아도 분석할 수 있다.
클래스 다이어그램을 보면 `OrderServiceImpl`은 `MemberRepository`, `DiscountPolicy`에 의존한다는 것을 알 수 있다.
그런데 이러한 클래스 의존 관계 만으로는 실제 어떤 객체가 `OrderServiceImpl`에 주입 될지 알 수 없다.

<p align="center">
  <img src="https://github.com/ro117-youshin/Spring-core-basics/blob/main/img/orderserviceA_class_diagram.png" width="600" height="350"/>
</p>

**_동적인 객체 인스턴스 의존 관계_**

&nbsp; 애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 의존 관계다.

<p align="center">
  <img src="https://github.com/ro117-youshin/Spring-core-basics/blob/main/img/orderserviceA_object_diagram.png" width="600" height="200"/>
</p>

* 애플리케이션 **실행 시점(런타임)** 에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존 관계가 연결 되는 것을 **의존 관계 주입** 이라 한다.
* 객체 인스턴스를 생성하고, 그 참조값을 전달해서 연결된다.
* 의존관계 주입을 사용하면 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다.
* 의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.

#### 💡 IoC 컨테이너, DI 컨테이너
* `AppConfig` 처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것을 IoC 컨테이너 또는 **DI 컨테이너** 라고 한다.
* 의존관계 주입에 초점을 맞추어 최근에는 주로 DI 컨테이너라 한다.
* 또는 어셈블러, 오브젝트 팩토리 등으로 불리기도 한다.



