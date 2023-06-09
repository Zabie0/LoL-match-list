package com.staryy.teamSystem.controller;

import com.staryy.teamSystem.models.Team;
import com.staryy.teamSystem.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService service;
    @GetMapping("/{name}")
    public String getTeamByName(@PathVariable String name,Model model) {
        Team team = service.getByTeamName(name);
        model.addAttribute("team",team);
        return "team-name";
    }

    @GetMapping("/all")
    public String getAllTeams(Model model){
        Iterable<Team> teamList = service.getAll();
        model.addAttribute("militaryFormation",teamList);
        return "all-teams";
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveTeam(@RequestParam("team-name") String teamName,
                           @RequestParam("previous-tournaments") boolean previousTournaments,
                           @RequestParam("additional-players") boolean additionalPlayers,
                           @RequestParam("team-info") String teamInfo){
        service.save(new Team(teamName,additionalPlayers,previousTournaments,teamInfo));
        return "redirect:/";
    }

    @GetMapping
    public String getForm(){
        return "form";
    }
}
