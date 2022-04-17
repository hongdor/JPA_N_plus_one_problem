package com.hong.toyproject.team;

import com.hong.toyproject.member.dto.MemberDto;
import com.hong.toyproject.team.dto.TeamDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamRepository teamRepository;
    private final TeamService teamService;
    private static final Logger log = LoggerFactory.getLogger(TeamController.class);


    // 1 + N 문제 테스트 / 1 + N 발생
    // jpa.properties.hibernate.default_batch_fetch_size: 1000 설정 후 1 + N 발생 X IN절로
    @GetMapping("api/v1/teams")
    public List<TeamDto> findTeam(){
        List<Team> teams = this.teamRepository.findAll();
        return teamService.teamsToTeamDtos(teams);
    }

    // fetch join을 사용해 해결
    @GetMapping("api/v2/teams")
    public List<TeamDto> findTeam2(){
        List<Team> teams = this.teamRepository.findAll2();
        return teamService.teamsToTeamDtos(teams);
    }

    // entitygraph로 해결
    @GetMapping("api/v3/teams")
    public List<TeamDto> findTeam3(){
        List<Team> teams = this.teamRepository.findAll3();
        return teamService.teamsToTeamDtos(teams);
    }

    // query builder로 해결
    @GetMapping("api/v4/teams")
    public List<TeamDto> findTeam4(){
        List<Team> teams = this.teamRepository.findAll4();
        return teamService.teamsToTeamDtos(teams);
    }



}
