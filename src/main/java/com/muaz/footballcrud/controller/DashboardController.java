package com.muaz.footballcrud.controller;

import com.muaz.footballcrud.dto.TeamPlayersRequestDTO;
import com.muaz.footballcrud.entity.Contract;
import com.muaz.footballcrud.entity.Player;
import com.muaz.footballcrud.entity.Team;
import com.muaz.footballcrud.helper.DefaultData;
import com.muaz.footballcrud.service.ContractService;
import com.muaz.footballcrud.service.PlayerService;
import com.muaz.footballcrud.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(path = "/app")
public class DashboardController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private ContractService contractService;

    @PostConstruct
    public void init() {
        List<Team> teamList = DefaultData.createDefaultPlayerData();
        teamService.saveAll(teamList);
    }

    @RequestMapping(value = "/get-all-players", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @RequestMapping(value = "/get-team-by-player", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Team getTeamByPlayer(@RequestBody Player player) {
        return teamService.getTeamByPlayer(player);
    }

    @RequestMapping(value = "/save-player", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void savePlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
    }

    @RequestMapping(value = "/save-team", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void saveTeam(@RequestBody Team team) {
        teamService.saveTeam(team);
    }

    @RequestMapping(value = "/make-contract", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void makeContract(@RequestBody Contract contract) {
        contractService.makeContract(contract);
    }

    @RequestMapping(value = "/player", method = RequestMethod.DELETE)
    public void deletePlayer(@RequestHeader(value = "playerId") Long playerId) {
        playerService.deletePlayerById(playerId);
    }

    @RequestMapping(value = "/get-active-players", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Player> getActivePlayersByTeamAndTime(@RequestBody TeamPlayersRequestDTO teamPlayersRequestDTO) {
        return playerService.getActivePlayers(teamPlayersRequestDTO);
    }

}
