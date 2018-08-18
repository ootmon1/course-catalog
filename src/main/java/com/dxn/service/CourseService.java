package com.dxn.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxn.exception.ResourceNotFoundException;
import com.dxn.model.Course;
import com.dxn.model.Topic;
import com.dxn.payload.CourseRequest;
import com.dxn.payload.CourseResponse;
import com.dxn.repository.CourseRepository;
import com.dxn.repository.TopicRepository;
import com.dxn.util.ModelMapper;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	public static final Logger logger = LoggerFactory.getLogger(CourseService.class);

	public List<CourseResponse> getAllCourses() {

		List<CourseResponse> courseResponses = new ArrayList<>();
		courseRepository.findAll().forEach(course -> {
			courseResponses.add(ModelMapper.mapCourseToCourseResponse(course));
		});
		
		return courseResponses;	
	}
	
	public CourseResponse getCourseById(Long courseId) {
		
		Course course = courseRepository.findById(courseId).orElseThrow(
				() -> new ResourceNotFoundException("Course", "id", courseId));
		
		return ModelMapper.mapCourseToCourseResponse(course);
	}
	
	public List<CourseResponse> getCoursesByTopic(Long topicId) {
		
		Topic topic = topicRepository.findById(topicId).orElseThrow(
				() -> new ResourceNotFoundException("Topic", "id", topicId));
		
		List<CourseResponse> courseResponses = new ArrayList<>();
		courseRepository.findByTopic(topic).forEach(course -> {
			courseResponses.add(ModelMapper.mapCourseToCourseResponse(course));
		});
		
		return courseResponses;
	}
	
//	public List<CourseResponse> getCoursesByTopicId(Long topicId) {
//		
//		List<CourseResponse> courseResponses = new ArrayList<>();
//		courseRepository.findByTopicId(topicId).forEach(course -> {
//			courseResponses.add(ModelMapper.mapCourseToCourseResponse(course));
//		});
//		
//		return courseResponses;
//	}
	
//	public List<CourseResponse> getCoursesByTopic(Topic topic) {
//		
//		List<CourseResponse> courseResponses = new ArrayList<>();
//		courseRepository.findByTopic(topic).forEach(course -> {
//			courseResponses.add(ModelMapper.mapCourseToCourseResponse(course));
//		});
//		
//		return courseResponses;
//	}
	
	// change this to take a courseRequest.topicId instead of courseRequest.topic	
	public Course createCourse(CourseRequest courseRequest) {
		
		Long topicId = courseRequest.getTopicId();
		
		Topic topic = topicRepository.findById(topicId).orElseThrow(
				() -> new ResourceNotFoundException("Topic", "id", topicId));
		
		Course course = new Course(courseRequest.getName(), courseRequest.getDescription(), topic);
		return courseRepository.save(course);
	}
	
	public Course updateCourse(Long courseId, CourseRequest courseRequest) {
		
		Course course = courseRepository.findById(courseId).orElseThrow(
				() -> new ResourceNotFoundException("Course", "id", courseId));
		
		Long topicId = courseRequest.getTopicId();
		
		Topic topic = topicRepository.findById(topicId).orElseThrow(
				() -> new ResourceNotFoundException("Topic", "id", topicId));
			
		course.setName(courseRequest.getName());
		course.setDescription(courseRequest.getDescription());
		course.setTopic(topic);
		return courseRepository.save(course);
	}
	
	public void deleteCourse(Long courseId) {
		
		courseRepository.findById(courseId).orElseThrow(
				() -> new ResourceNotFoundException("Course", "id", courseId));
		
		courseRepository.deleteById(courseId);
	}
}

//	public Course getCourse(Long id) {
//
//		return courseRepository.findById(id).orElse(null);
//	}
//
//	public Course addCourse(Course course) {
//		return courseRepository.save(course);
//
//	}
//
//	public Course updateCourse(Course course) {
//		return courseRepository.save(course);
//
//	}
//
//	public void deleteCourse(Long id) {
//		courseRepository.deleteById(id);
//	}
//	
//	public void deleteCoursesByTopic(Topic topic) {
//		courseRepository.deleteByTopicId(topic);
//	}
	
//	public void deleteCoursesByTopic(Long topicId) {
//		courseRepository.deleteByTopicId(topicId);
//	}