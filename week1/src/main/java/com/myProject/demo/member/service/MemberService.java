package com.myProject.demo.member.service;

import com.myProject.demo.member.entity.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}