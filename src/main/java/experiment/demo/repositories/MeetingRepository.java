package experiment.demo.repositories;


import org.springframework.data.repository.CrudRepository;

import experiment.demo.models.Meeting;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {

}

