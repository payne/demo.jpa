package experiment.demo;

import static org.junit.Assert.*;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import experiment.demo.models.Meeting;
import experiment.demo.models.Person;
import experiment.demo.repositories.MeetingRepository;
import experiment.demo.repositories.PersonRepository;

// https://blog.arnoldgalovics.com/lazyinitializationexception-demystified/

import static org.hibernate.Hibernate.isInitialized;
import static org.junit.Assert.*;

// https://reflectoring.io/spring-boot-data-jpa-test/

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class DataAccessTest {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MeetingRepository meetingRepository;


	@Test
	public void test() {
		Person matt = new Person();
		matt.setName("Matt Payne");
		matt.setEmail("Matt@MattPayne.org");
		Meeting m1 = new Meeting();
		m1.setDate(new Date(2019, 06, 15));
		m1.setLocation("Butterloo");
		meetingRepository.save(m1);
		Set<Meeting> meetings=new HashSet<>();
		meetings.add(m1);
		Meeting m2 = new Meeting();
		m2.setDate(new Date(2019, 06, 16));
		m2.setLocation("Butterloo");
		meetingRepository.save(m2);
		meetings.add(m2);
		matt.setMeetings(meetings);
		personRepository.save(matt);

		Optional<Person> alsoMatt = personRepository.findById(matt.getId());
		boolean p = alsoMatt.isPresent();
		Person matt2 = alsoMatt.get();
		// assertFalse(isInitialized(matt2.getMeetings()));
		// WHY DOES this get initialized here???
		int numMeetings = matt2.getMeetings().size();
		System.out.println(numMeetings);
	}

}
