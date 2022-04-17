package com.hong.toyproject.team;

import com.hong.toyproject.member.Member;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
public class Team {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private List<Member> members = new ArrayList<>();

}
