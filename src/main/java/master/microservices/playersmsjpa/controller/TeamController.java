package master.microservices.playersmsjpa.controller;

import master.microservices.playersmsjpa.exception.ResourceNotFoundException;
import master.microservices.playersmsjpa.model.Team;
import master.microservices.playersmsjpa.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/teams")
    public Iterable<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    @GetMapping("/teams/{id")
    public Team getTeam(@PathVariable int id){
        return teamRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Team","id",id));
    }

    @PostMapping("/teams")
    public Team addTeam(@RequestBody Team team){return teamRepository.save(team); }

    @PutMapping("/teams/{id}")
    public Team updateTeam(@RequestBody Team teamData, @PathVariable int id){
        Team team1 = teamRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Team","id",id));

        team1.setName(teamData.getName());

        return teamRepository.save(team1);
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable(value = "id") int id){
        Team team = teamRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Team", "id",id));

        teamRepository.delete(team);

        return ResponseEntity.ok().build();
    }
}
