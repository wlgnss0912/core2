package hello.core2.discount;

import hello.core2.annotation.MainDiscountPolicy;
import hello.core2.member.Grade;
import hello.core2.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class FixDiscountPolicy implements DiscountPolicy{

    final int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){//enum type은 == 사용
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
