package com.hong.toyproject.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hong.toyproject.team.Team;
import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Member))
            return false;
        Member member = (Member) o;
        return Objects.equals(this.memberId, member.memberId) &&
                Objects.equals(this.name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.memberId, this.name);
    }
}
