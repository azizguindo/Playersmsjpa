package master.microservices.playersmsjpa.repository;

import master.microservices.playersmsjpa.model.Team;
import org.springframework.data.repository.CrudRepository;


public interface TeamRepository extends CrudRepository<Team, Integer> {
}
