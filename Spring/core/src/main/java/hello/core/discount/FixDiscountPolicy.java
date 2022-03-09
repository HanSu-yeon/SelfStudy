package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

//고정 할인
public class FixDiscountPolicy implements  DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        //조건- 등급이 VIP이어야 함
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
