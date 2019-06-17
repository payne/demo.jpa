package experiment.demo.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.ManyToMany;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	// https://www.baeldung.com/hibernate-one-to-many
	// https://www.baeldung.com/jpa-many-to-many
	@ManyToMany
	@JoinTable(
			  name = "meetings_attended", 
			  joinColumns = @JoinColumn(name = "person_id"), 
			  inverseJoinColumns = @JoinColumn(name = "meeting_id"))
	private Set<Meeting> meetings;
	
	private String name, email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}

}
