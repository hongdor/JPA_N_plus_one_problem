package com.hong.toyproject.member;

import com.hong.toyproject.member.dto.MemberDto;
import com.hong.toyproject.team.TeamController;
import com.hong.toyproject.team.dto.TeamDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);


    // jpa repository
    @GetMapping("/api/v1/members/{id}")
    public MemberDto findOneMember(@PathVariable Long id){
        Member member = this.memberRepository.findById(id).get();
        MemberDto res = new MemberDto(member);
        System.out.println(res);
        System.out.println(new TeamDto(member.getTeam()));
        return res;
    }

    // querydsl
    @GetMapping("/api/v2/members/{id}")
    public MemberDto findOneMemberV2(@PathVariable Long id){
        Member member = this.memberRepository.findAllMemberDsl();
        MemberDto res = new MemberDto(member);
        System.out.println(res);
        System.out.println(new TeamDto(member.getTeam()));
        return res;
    }

    // errorcheck test
    @GetMapping("/api/v3/members/{id}")
    public MemberDto findOneMember2(@PathVariable Long id){
        Member member = this.memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException());
        MemberDto res = new MemberDto(member);
        return res;
    }

    // errorcheck test 2
    @GetMapping("/api/v4/members/{memberId}")
    public MemberDto findOneMember3(@PathVariable Long memberId){
        Member member = this.memberService.findMember(memberId);
        MemberDto res = new MemberDto(member);
        return res;
    }


    // page query
    @GetMapping("/api/v5/members/pages")
    public Page<MemberDto> findPages(Pageable pageable, Long memberId){
        return this.memberRepository.findPages(pageable, memberId);
    }

    @GetMapping("/api/v6/members/pages")
    public Page<MemberDto> findPages2(Pageable pageable){
        Page<Member> page = this.memberRepository.findByOrderByMemberIdAsc(pageable);

        return PageableExecutionUtils.getPage(
                page.getContent().stream().map(MemberDto::new).collect(Collectors.toList()),
                pageable,
                () -> page.getTotalElements());
    }

    @PostMapping("/api/v1/members")
    public MemberDto newEmployee(@RequestBody Member member) {
        Member newMember = this.memberRepository.save(member);
        return new MemberDto(newMember);
    }

    @Transactional
    @PutMapping("/api/v1/members/{memberId}")
    public MemberDto replaceEmployee(@RequestBody Member newMember, @PathVariable Long memberId) {
        return this.memberRepository.findById(memberId)
                .map(member -> {
                    member.setName(newMember.getName());
                    return new MemberDto(member);
                })
                .orElseThrow(MemberNotFoundException::new);
    }

    @DeleteMapping("/api/v1/members/{memberId}")
    void deleteEmployee(@PathVariable Long memberId) {
        this.memberRepository.deleteById(memberId);
    }
}
