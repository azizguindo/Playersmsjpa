package master.microservices.playersmsjpa;

import master.microservices.playersmsjpa.model.Player;
import master.microservices.playersmsjpa.model.Team;
import master.microservices.playersmsjpa.repository.PlayerRepository;
import master.microservices.playersmsjpa.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InitBD  implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(PlayermsjpaApplication.class);

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void run(String... args) throws Exception {
        Team team1 = new Team(1,"Bayern Munich");
        Team team2 = new Team(2, "FC Barcelone");
        teamRepository.save(team1);
        teamRepository.save(team2);

        playerRepository.save(new Player(1, "Guindo", "Aziz", "Attaquant", 22, team2));
        playerRepository.save(new Player(2, "Kimmich", "Joshua", "Milieu de terrain", 25,team1));
        playerRepository.save(new Player(3, "Coman", "Kingsley", "Attaquant", 24,team1));
    }
}
