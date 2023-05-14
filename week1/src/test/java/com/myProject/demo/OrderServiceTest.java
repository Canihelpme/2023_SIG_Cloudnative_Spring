package com.myProject.demo;

import com.myProject.demo.Enum.Grade;
import com.myProject.demo.Order.Order;
import com.myProject.demo.Order.OrderService;
import com.myProject.demo.Order.OrderServiceImpl;
import com.myProject.demo.member.entity.Member;
import com.myProject.demo.member.service.MemberService;
import com.myProject.demo.member.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
