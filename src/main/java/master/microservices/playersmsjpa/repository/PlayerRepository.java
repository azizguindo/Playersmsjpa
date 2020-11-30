package master.microservices.playersmsjpa.repository;

import master.microservices.playersmsjpa.model.Player;
import org.springframework.data.repository.CrudRepository;


public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
