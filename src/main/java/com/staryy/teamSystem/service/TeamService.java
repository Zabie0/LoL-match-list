package com.staryy.teamSystem.service;

import com.staryy.teamSystem.interfaces.ServiceInterface;
import com.staryy.teamSystem.models.Team;
import com.staryy.teamSystem.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService implements ServiceInterface<Team> {
    private final TeamRepository repository;

    @Override
    public void save(Team team) {
        repository.save(team);
    }

    @Override
    public void update(Team team) {
        Team newTeam = repository.findById(team.getId()).orElseThrow(EntityNotFoundException::new);

        newTeam.setTeamName(team.getTeamName());
        newTeam.setAdditionalPlayers(team.isAdditionalPlayers());
        newTeam.setPreviousTournaments(team.isPreviousTournaments());
        newTeam.setOverallInfo(team.getOverallInfo());

        repository.save(newTeam);
    }

    @Override
    public void delete(Team team) {
        repository.delete(team);
    }

    @Override
    public Iterable<Team> getAll() {
        return repository.findAll();
    }

    public Team getByTeamName(String teamName){
        return repository.findByTeamName(teamName).orElseThrow(EntityNotFoundException::new);
    }
}
