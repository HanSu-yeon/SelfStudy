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
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ap = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ap.getBean("memberService", MemberService.class);
        OrderService orderService = ap.getBean("orderService", OrderService.class);

        Long memberId =1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        //주문 생성
        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        //최종 결과
        System.out.println("order = " + order.calculatePrice());

    }
}
