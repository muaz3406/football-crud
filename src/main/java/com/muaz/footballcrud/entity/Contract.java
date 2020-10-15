package com.muaz.footballcrud.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "contract")
public class Contract extends BaseEntity {

    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private String currency;
    private String status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
}
