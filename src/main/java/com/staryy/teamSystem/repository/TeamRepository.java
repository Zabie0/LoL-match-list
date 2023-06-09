package com.staryy.teamSystem.repository;

import com.staryy.teamSystem.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team,Long> {
    Optional<Team> findByTeamName(String teamName);
}
