package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

	// findBy<nomeProprietàEntity> JPA crea l'implementazione
	public List<Course> findByName(String topicId);
	public List<Course> findByDescription(String description);
	
	// posso anche aggiungere una ricerca per un campo innestato aggiungendolo dopo il nome della classe inner!
	public List<Course> findByTopicId(String topicId);
}
