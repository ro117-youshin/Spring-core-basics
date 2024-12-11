# Spring-core-basics
스프링 핵심 원리

## Index
* [Intro 좋은 객체 지향 프로그래밍?](https://github.com/ro117-youshin/Spring-core-basics?tab=readme-ov-file#intro)
* [관심사의 분리](https://github.com/ro117-youshin/Spring-core-basics?tab=readme-ov-file#관심사의분리)

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