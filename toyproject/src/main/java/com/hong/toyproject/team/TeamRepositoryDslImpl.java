package com.hong.toyproject.team;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.hong.toyproject.QClassConfig.*;

public class TeamRepositoryDslImpl implements TeamRepositoryDsl{

    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    public TeamRepositoryDslImpl(EntityManager em) {
        this.em = em;
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Team> findAll4() {
        return jpaQueryFactory
                .select(team)
                .from(team)
                .leftJoin(team.members, member)
                .fetchJoin()
                .distinct()
                .fetch();
    }
}
