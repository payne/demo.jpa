package experiment.demo.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			  name = "movies_acted", 
			  joinColumns = @JoinColumn(name = "actor_id"), 
			  inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<Movie> movies;
	
	private String name;
	
	public Actor() {
		id=-1L; name="";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
