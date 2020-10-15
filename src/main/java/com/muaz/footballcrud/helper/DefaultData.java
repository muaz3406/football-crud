package com.muaz.footballcrud.helper;

import com.muaz.footballcrud.entity.Player;
import com.muaz.footballcrud.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class DefaultData {

    public static List<Team> createDefaultPlayerData() {
        Team team1 = Team.builder().name("FB").countryCode("TR").build();
        Team team2 = Team.builder().name("RM").countryCode("ISP").build();

        Player player = Player.builder().name("ronaldinho").position("CF").currentTeamName("FB").build();

        Player player1 = Player.builder().name("iniesta").position("LEFT MF").currentTeamName("FB").build();

        Player player2 = Player.builder().name("puyol").position("CENTRE BACK").currentTeamName("FB").build();

        Player player3 = Player.builder().name("xavi").position("RIGHT MF").currentTeamName("RM").build();

        Player player4 = Player.builder().name("pique").position("CENTRE BACK").currentTeamName("RM").build();

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        playerList.add(player1);
        playerList.add(player2);

        List<Player> playerList2 = new ArrayList<>();
        playerList2.add(player3);
        playerList2.add(player4);

        team1.setPlayerList(playerList);
        team2.setPlayerList(playerList2);

        List<Team> teamList = new ArrayList<>();
        teamList.add(team1);
        teamList.add(team2);

        return teamList;
    }

}
