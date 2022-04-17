package com.hong.toyproject.member;

import com.hong.toyproject.member.dto.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberRepositoryDsl {
    public Member findAllMemberDsl();
    public Page<MemberDto> findPages(Pageable pageable, Long id);
}
