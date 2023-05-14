package com.myProject.demo.Order;

import com.myProject.demo.dIscountPolicy.DiscountPolicy;
import com.myProject.demo.dIscountPolicy.FixDiscountPolicy;
import com.myProject.demo.member.entity.Member;
import com.myProject.demo.member.repository.MemberRepository;
import com.myProject.demo.member.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
