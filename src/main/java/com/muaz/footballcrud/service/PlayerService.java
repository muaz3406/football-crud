package com.muaz.footballcrud.service;

import com.muaz.footballcrud.dto.TeamPlayersRequestDTO;
import com.muaz.footballcrud.entity.Player;
import com.muaz.footballcrud.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    public void deletePlayerById(Long playerId) {
        if (playerRepository.existsById(playerId)) {
            playerRepository.deleteById(playerId);
        }
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(Long id) {
        return playerRepository.getOne(id);
    }

    public List<Player> getActivePlayers(TeamPlayersRequestDTO teamPlayersRequestDTO) {
        Long teamId = teamPlayersRequestDTO.getTeamId();
        Date givenDate = teamPlayersRequestDTO.getGivenDate();
        return playerRepository.getActivePLayers(teamId, givenDate);
    }
}
