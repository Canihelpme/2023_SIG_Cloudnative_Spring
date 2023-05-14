package com.myProject.demo.dIscountPolicy;

import com.myProject.demo.member.entity.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
