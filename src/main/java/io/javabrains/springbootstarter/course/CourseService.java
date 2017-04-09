package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId) {
		return courseRepository.findByTopicId(topicId);
	}
	
	public Course getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);
	}
	
	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
	}
	
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		//topics.removeIf( t -> t.getId().equals(id) );
		courseRepository.delete(id);
	}
}
