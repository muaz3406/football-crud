package com.muaz.footballcrud.repository;

import com.muaz.footballcrud.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT DISTINCT ct.player FROM Contract ct WHERE ct.team.id =:teamId AND :givenDate BETWEEN ct.startDate AND ct.endDate")
    List<Player> getActivePLayers(@Param("teamId") Long teamId, @Param("givenDate") Date givenDate);
}
