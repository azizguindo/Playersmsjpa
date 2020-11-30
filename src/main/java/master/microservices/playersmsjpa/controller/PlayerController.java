package master.microservices.playersmsjpa.controller;

import master.microservices.playersmsjpa.repository.PlayerRepository;
import master.microservices.playersmsjpa.exception.ResourceNotFoundException;
import master.microservices.playersmsjpa.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {

    /*@Value("${propertySources}")
    private String me;*/

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players")
    public Iterable<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id){
        return playerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Player","id",id));
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return playerRepository.save(player);
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@RequestBody Player playerData, @PathVariable int id){
        Player player1 = playerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Player","id",id));

        player1.setNom(playerData.getNom());
        player1.setPrenom(playerData.getPrenom());
        player1.setAge(playerData.getAge());
        player1.setPoste(playerData.getPoste());
        player1.setTeam(playerData.getTeam());
        player1.setNomTeam(playerData.getNomTeam());

        return playerRepository.save(player1);

    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable(value = "id") int id){
        Player player = playerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Utilisateur", "id",id));

        playerRepository.delete(player);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/error")
    public Iterable<Player> getError(){
        return playerRepository.findAll();
    }

    /*@GetMapping(value="/who")
    public String getName(){
        return String.format(me);
    }*/
}
