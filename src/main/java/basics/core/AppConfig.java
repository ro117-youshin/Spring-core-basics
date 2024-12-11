package basics.core;

import basics.core.discount.FixDiscountPolicy;
import basics.core.member.MemberService;
import basics.core.member.MemberServiceImpl;
import basics.core.member.MemoryMemberRepository;
import basics.core.order.OrderService;
import basics.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
