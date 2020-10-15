package com.muaz.footballcrud.service;

import com.muaz.footballcrud.entity.Player;
import com.muaz.footballcrud.entity.Team;
import com.muaz.footballcrud.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    public void saveAll(List<Team> teamList) {
        teamRepository.saveAll(teamList);
    }

    public Team getTeamByPlayer(Player player) {
        return teamRepository.findByName(player.getCurrentTeamName());
    }
}
