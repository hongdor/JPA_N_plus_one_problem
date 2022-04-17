package com.hong.toyproject.team;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long>, TeamRepositoryDsl {

    @Query("select distinct t from Team t join fetch t.members")
    List<Team> findAll2();


    @EntityGraph(attributePaths = "members")
    @Query("select t from Team t")
    List<Team> findAll3();
}
