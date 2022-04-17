package com.hong.toyproject.member;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryDsl {
    Page<Member> findByOrderByMemberIdDesc(Pageable pageable);
    Page<Member> findByOrderByMemberIdAsc(Pageable pageable);
}
