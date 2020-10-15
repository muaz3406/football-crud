package com.muaz.footballcrud.service;

import com.muaz.footballcrud.entity.Player;
import com.muaz.footballcrud.entity.Team;
import com.muaz.footballcrud.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TeamServiceTest {

    @InjectMocks
    private TeamService teamService;

    @Mock
    private TeamRepository teamRepository;

    @Test
    public void shouldSaveTeamWithGivenTeam() {
        Team team = new Team();
        teamService.saveTeam(team);

        verify(teamRepository).save(team);
    }

    @Test
    public void shouldSaveTeamListWithGivenTeamList() {
        Team team = new Team();
        List<Team> teamList = Collections.singletonList(new Team());

        teamService.saveAll(teamList);
        verify(teamRepository).saveAll(teamList);
    }

    @Test
    public void shouldReturnTeamWhenGivenPlayer() {
        Player player = new Player();
        player.setCurrentTeamName("FB");

        teamService.getTeamByPlayer(player);
        verify(teamRepository).findByName(player.getCurrentTeamName());
    }
}
