package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixdiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
              // Enum 타입은 == 를 사용하는 것이 맞음
            return discountFixAmount;
        }
        else return 0;
    }
}
