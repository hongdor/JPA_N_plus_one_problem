package com.hong.toyproject.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hong.toyproject.team.Team;
import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    @ToString.Exclude
    private Team team;

    public void setName(String name) {
        this.name = name;
    }

    //    @Override
//    public String toString() {
//        return "Member{" +
//                "memberId=" + memberId +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
