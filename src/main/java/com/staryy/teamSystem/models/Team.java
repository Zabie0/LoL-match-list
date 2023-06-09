package com.staryy.teamSystem.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "team_table")
@Table
@Data
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String teamName;
    private boolean additionalPlayers;
    private boolean previousTournaments;
    private String overallInfo;

    public Team(String teamName, boolean additionalPlayers, boolean previousTournaments, String overallInfo){
        this.teamName = teamName;
        this.additionalPlayers = additionalPlayers;
        this.previousTournaments = previousTournaments;
        this.overallInfo = overallInfo;
    }
}
