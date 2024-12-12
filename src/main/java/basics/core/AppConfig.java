package basics.core;

import basics.core.discount.DiscountPolicy;
import basics.core.discount.FixDiscountPolicy;
import basics.core.discount.RateDiscountPolicy;
import basics.core.member.MemberRepository;
import basics.core.member.MemberService;
import basics.core.member.MemberServiceImpl;
import basics.core.member.MemoryMemberRepository;
import basics.core.order.OrderService;
import basics.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
