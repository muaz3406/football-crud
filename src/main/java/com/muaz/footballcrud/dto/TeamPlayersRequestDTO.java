package com.muaz.footballcrud.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TeamPlayersRequestDTO {
    private Long teamId;
    private Date givenDate;
}
