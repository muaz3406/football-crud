package com.muaz.footballcrud.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.muaz.footballcrud.dto.TeamPlayersRequestDTO;
import com.muaz.footballcrud.entity.Contract;
import com.muaz.footballcrud.entity.Player;
import com.muaz.footballcrud.entity.Team;
import com.muaz.footballcrud.service.ContractService;
import com.muaz.footballcrud.service.PlayerService;
import com.muaz.footballcrud.service.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(DashboardController.class)
public class DashBoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @MockBean
    private TeamService teamService;

    @MockBean
    private ContractService contractService;

    @Test
    public void shouldReturnAllPlayers() throws Exception {
        this.mockMvc.perform(get("/app/get-all-players")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnTeamWhenGivenPlayer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/app/get-team-by-player")
                .content(asJsonString(new Player()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnActivePlayersWhenGivenTeamAndTime() throws Exception {
        TeamPlayersRequestDTO teamPlayersRequestDTO = new TeamPlayersRequestDTO();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/app/get-active-players")
                .content(asJsonString(teamPlayersRequestDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(playerService).getActivePlayers(teamPlayersRequestDTO);
    }

    @Test
    public void shouldSaveGivenPlayer() throws Exception {
        Player player = new Player();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/app/save-player")
                .content(asJsonString(player))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        verify(playerService).savePlayer(player);
    }

    @Test
    public void shouldSaveGivenTeam() throws Exception {
        Team team = new Team();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/app/save-team")
                .content(asJsonString(team))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        verify(teamService).saveTeam(team);
    }

    @Test
    public void shouldMakeContractWhenGivenContract() throws Exception {
        Contract contract = new Contract();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/app/make-contract")
                .content(asJsonString(contract))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        verify(contractService).makeContract(contract);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
