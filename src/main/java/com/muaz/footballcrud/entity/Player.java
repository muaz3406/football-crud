package com.muaz.footballcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "player")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player extends BaseEntity {

    private String name;
    private String position;
    private String currentTeamName;
}
