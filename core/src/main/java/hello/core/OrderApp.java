package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppCofing appCofing = new AppCofing();
//        MemberService memberService = appCofing.memberService();
//        OrderService orderService = appCofing.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppCofing.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);     // 회원가입

        Order order = orderService.createOrder(memberId, "itmeA", 20000);

        System.out.println("order = " + order);;
        System.out.println("order = " + order.calculaterPrice());;
    }
}
