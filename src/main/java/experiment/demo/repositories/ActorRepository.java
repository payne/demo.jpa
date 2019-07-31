package experiment.demo.repositories;


import org.springframework.data.repository.CrudRepository;

import experiment.demo.models.Actor;

public interface ActorRepository extends CrudRepository<Actor, Long> {

}

