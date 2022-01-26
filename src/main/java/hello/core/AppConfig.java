package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//애플리케이션의 실제 동작에 필요한 '구현 객체를 생성'한다. => '기획자'

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){ //클라이언트

        return  new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){ //주문 서비스 역할

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemoryMemberRepository memberRepository() { //회원 저장소 역할
        return new MemoryMemberRepository();
    }


    @Bean
    public DiscountPolicy discountPolicy() { //할인 정책 역할

        return  new RateDiscountPolicy(); // <- 구현 클래스
    }
}
