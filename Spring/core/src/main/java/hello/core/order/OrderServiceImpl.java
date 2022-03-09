package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    //주문 생성 요청 오면 --> 회원 정보 조회 -->할인 정책에 회원을 넘긴다
    //MemberRepository에서 회원 정보 조회해야함
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //할인 정책
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //Order객체 만들어서 반환해준다
        return new Order(memberId, itemName, itemPrice,discountPrice);
    }
}
