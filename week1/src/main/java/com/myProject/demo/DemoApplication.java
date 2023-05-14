package com.myProject.demo;

import com.myProject.demo.Enum.Grade;
import com.myProject.demo.Order.Order;
import com.myProject.demo.Order.OrderService;
import com.myProject.demo.Order.OrderServiceImpl;
import com.myProject.demo.member.entity.Member;
import com.myProject.demo.member.service.MemberService;
import com.myProject.demo.member.service.MemberServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		memberapp();
		orderapp();
	}

	public static void memberapp() {

		MemberService memberService = new MemberServiceImpl();

		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println("MemberApp 결과:");

		System.out.println("new member = " + member.getName());
		System.out.println("find Member = " + findMember.getName());

	}

	public static void orderapp() {

		MemberService memberService2 = new MemberServiceImpl();
		OrderService orderService = new OrderServiceImpl();
		long memberId = 1L;
		Member member2 = new Member(memberId, "memberA", Grade.VIP);
		memberService2.join(member2);
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("");
		System.out.println("OrderApp 결과:");
		System.out.println("order = " + order);

	}


}
