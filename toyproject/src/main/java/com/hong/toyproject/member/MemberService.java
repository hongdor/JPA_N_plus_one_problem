package com.hong.toyproject.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findMember(Long memberId) {
        return this.memberRepository.findById(memberId).get();
    }
}
