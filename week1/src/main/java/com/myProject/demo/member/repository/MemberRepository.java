package com.myProject.demo.member.repository;

import com.myProject.demo.member.entity.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
