package com.muaz.footballcrud.service;

import com.muaz.footballcrud.dto.TeamPlayersRequestDTO;
import com.muaz.footballcrud.entity.Player;
import com.muaz.footballcrud.repository.PlayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Test
    public void shouldSavePlayerWhenGivenPlayer() {
        Player player = new Player();
        playerService.savePlayer(player);

        verify(playerRepository).save(player);
    }

    @Test
    public void shouldDeletePlayerByIdWhenPlayerExist() {
        when(playerRepository.existsById(123L)).thenReturn(true);
        playerService.deletePlayerById(123L);

        verify(playerRepository).deleteById(123L);
    }

    @Test
    public void shouldReturnPlayerListWhenInvokeAllPlayers() {
        playerService.getAllPlayers();
        verify(playerRepository).findAll();
    }

    @Test
    public void shouldReturnPlayerWhenInvokeById() {
        playerService.getPlayer(123L);
        verify(playerRepository).getOne(123L);
    }

    @Test
    public void shouldReturnActivePlayersWhenGivenDateAndTeamId() {
        Date givenDate = new Date();
        TeamPlayersRequestDTO teamPlayersRequestDTO = new TeamPlayersRequestDTO();
        teamPlayersRequestDTO.setTeamId(123L);
        teamPlayersRequestDTO.setGivenDate(givenDate);

        playerService.getActivePlayers(teamPlayersRequestDTO);

        verify(playerRepository).getActivePLayers(teamPlayersRequestDTO.getTeamId(), teamPlayersRequestDTO.getGivenDate());
    }

}
