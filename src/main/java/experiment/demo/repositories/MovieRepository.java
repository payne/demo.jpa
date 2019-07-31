package experiment.demo.repositories;


import org.springframework.data.repository.CrudRepository;

import experiment.demo.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}

