package com.dxn.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dxn.model.Course;
import com.dxn.model.Topic;
//import com.dxn.model.Topic;

public interface CourseRepository extends CrudRepository<Course, Long> {

	List<Course> findByTopicId(Long topicId);
	
	List<Course> findByTopic(Topic topic);
	
	void deleteByTopicId(Long topicId);
	
//	void deleteByTopicId(Topic topic);
//	
//	void deleteByTopic(Topic topic);
	
//	void deleteByTopicId(Long topicId);
}
