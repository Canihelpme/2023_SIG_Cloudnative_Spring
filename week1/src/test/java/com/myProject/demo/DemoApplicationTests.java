package com.myProject.demo;

import com.myProject.demo.Enum.Grade;
import com.myProject.demo.member.entity.Member;
import com.myProject.demo.member.service.MemberService;
import com.myProject.demo.member.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	MemberService memberService = new MemberServiceImpl();

	@Test
	void join() {

	//given
		Member member = new Member(1L, "memberA", Grade.VIP);

	//when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);

	//then
		Assertions.assertThat(member).isEqualTo(findMember);
	}

}
