package com.dxn.util;

import com.dxn.model.Course;
import com.dxn.model.Topic;
import com.dxn.payload.CourseResponse;
import com.dxn.payload.TopicResponse;

public class ModelMapper {

	public static TopicResponse mapTopicToTopicResponse(Topic topic) {
		
		TopicResponse topicResponse = new TopicResponse(topic.getId(), topic.getName(),
				topic.getDescription());
		
		return topicResponse;
	}
	
	public static CourseResponse mapCourseToCourseResponse(Course course) {
		
		CourseResponse courseResponse = new CourseResponse(course.getId(), course.getName(),
				course.getDescription(), course.getTopic().getId());
		
		return courseResponse;
	}
}
