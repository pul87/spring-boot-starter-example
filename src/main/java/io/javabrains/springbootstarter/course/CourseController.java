package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
@RequestMapping("/topics/{topicId}")
public class CourseController {
	
	@Autowired
	private CourseService topicService;

	@RequestMapping("/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return topicService.getAllCourses(topicId);
	}
	
	@RequestMapping("/courses/{id}")
	public Course getCourse(@PathVariable("id") String id) {
		return topicService.getCourse(id);
	}
	
	@RequestMapping(value="/courses", method=RequestMethod.POST)
	public Course addCourse(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		return topicService.addCourse(course);
	}
	
	@RequestMapping(value="/courses/{id}", method=RequestMethod.PUT)
	public Course updateCourse(@PathVariable String topicId, @PathVariable String id, @RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		return topicService.updateCourse(course);
	}
	
	@RequestMapping(value="/courses/{id}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id) {
		topicService.deleteCourse(id);
	}
}
