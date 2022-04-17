package com.hong.toyproject.team;

import com.hong.toyproject.member.dto.MemberDto;
import com.hong.toyproject.team.dto.TeamDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    public List<TeamDto> teamsToTeamDtos(List<Team> teams){
        List<TeamDto> teamDtos = teams.stream()
                .map(team -> {
                    TeamDto teamDto = new TeamDto(team);
                    teamDto.setMembers(team.getMembers().stream()
                            .map(member -> new MemberDto(member))
                            .collect(Collectors.toList()));
                    return teamDto;
                })
                .collect(Collectors.toList());

        return teamDtos;
    }
}
