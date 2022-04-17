package com.hong.toyproject.member;

import com.hong.toyproject.member.dto.MemberDto;
import com.hong.toyproject.member.dto.QMemberDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

import static com.hong.toyproject.QClassConfig.*;



@Repository
public class MemberRepositoryDslImpl implements MemberRepositoryDsl {


    private final EntityManager em;
    private JPAQueryFactory queryFactory;

    public MemberRepositoryDslImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Member findAllMemberDsl(){
        return queryFactory
                .select(member)
                .from(member)
                .fetchFirst();
    }

    @Override
    public Page<MemberDto> findPages(Pageable pageable, Long memberId) {
        List<MemberDto> members = queryFactory
                .select(new QMemberDto(member.memberId, member.name))
                .from(member)
                .where(
                        eqMemberId(memberId)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        List<Member> members2 = queryFactory
                .select(member)
                .from(member)
                .where(
                        eqMemberId(memberId)
                )
                .fetch();

        return PageableExecutionUtils.getPage(members, pageable, members2::size);
    }

    private BooleanExpression eqMemberId(Long memberId){
        return memberId == null ? null : member.memberId.eq(memberId);
    }
}
