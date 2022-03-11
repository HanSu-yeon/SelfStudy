package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    //주문 생성 요청 오면 --> 회원 정보 조회 -->할인 정책에 회원을 넘긴다
    //MemberRepository에서 회원 정보 조회해야함
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //할인 정책  final을 쓰면 무조건 값이 들어가야함
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    /**구체에 의존하지 않고 추상(인터페이스)에만 의존하도록 아래처럼 변경 --> 구현체가 없는데 어떻게 코드 실행할 수 있을까?
      해결방안: 누군가가 클라이언트인 OrderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입해주어야 한다*/
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //Order객체 만들어서 반환해준다
        return new Order(memberId, itemName, itemPrice,discountPrice);
    }
    
    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
