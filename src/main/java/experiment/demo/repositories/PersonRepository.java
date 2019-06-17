package experiment.demo.repositories;


import org.springframework.data.repository.CrudRepository;

import experiment.demo.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}

