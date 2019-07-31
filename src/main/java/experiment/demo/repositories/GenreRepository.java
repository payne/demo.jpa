package experiment.demo.repositories;


import org.springframework.data.repository.CrudRepository;

import experiment.demo.models.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

}

