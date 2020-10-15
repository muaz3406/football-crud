package com.muaz.footballcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "team")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team extends BaseEntity {

    private String name;
    private String countryCode;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "team_id")
    private List<Player> playerList = new ArrayList<>();

}
