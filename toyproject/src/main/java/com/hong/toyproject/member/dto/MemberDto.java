package com.hong.toyproject.member.dto;

import com.hong.toyproject.member.Member;
import com.hong.toyproject.team.Team;
import com.hong.toyproject.team.dto.TeamDto;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MemberDto {

    private Long memberId;
    private String name;
    private TeamDto team;

    public MemberDto(Member member) {
        this.memberId = member.getMemberId();
        this.name = member.getName();
    }

    @QueryProjection
    public MemberDto(Long memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}
