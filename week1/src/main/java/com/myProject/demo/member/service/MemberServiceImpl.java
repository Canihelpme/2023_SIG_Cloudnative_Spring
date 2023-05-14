package com.myProject.demo.member.service;

import com.myProject.demo.member.entity.Member;
import com.myProject.demo.member.repository.MemoryMemberRepository;
import com.myProject.demo.member.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
