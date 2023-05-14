package com.myProject.demo.dIscountPolicy;

import com.myProject.demo.Enum.Grade;
import com.myProject.demo.member.entity.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        } }
}
