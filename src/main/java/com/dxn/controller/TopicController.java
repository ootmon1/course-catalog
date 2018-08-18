package com.dxn.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dxn.model.Topic;
import com.dxn.payload.ApiResponse;
import com.dxn.payload.CourseResponse;
import com.dxn.payload.TopicRequest;
import com.dxn.payload.TopicResponse;
import com.dxn.service.CourseService;
import com.dxn.service.TopicService;
import com.dxn.util.ModelMapper;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping
	public List<TopicResponse> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@GetMapping("/{topicId}")
	public TopicResponse getTopic(@PathVariable Long topicId) {
		return topicService.getTopicById(topicId);
	}
	
	@GetMapping("/{topicId}/courses")
	public List<CourseResponse> getCoursesByTopic(@PathVariable Long topicId) {
		return courseService.getCoursesByTopic(topicId);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<TopicResponse> createTopic(@Valid @RequestBody TopicRequest topicRequest) {
		
		Topic topic = topicService.createTopic(topicRequest);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{topicId}")
				.buildAndExpand(topic.getId()).toUri();
		
		return ResponseEntity.created(location).body(ModelMapper.mapTopicToTopicResponse(topic));
	}
	
	@PutMapping("/{topicId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<TopicResponse> updateTopic(@PathVariable Long topicId,
			@Valid @RequestBody TopicRequest topicRequest) {
		
		Topic topic = topicService.updateTopic(topicId, topicRequest);
		
		return ResponseEntity.ok(ModelMapper.mapTopicToTopicResponse(topic));
	}
	
	@DeleteMapping("/{topicId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteTopic(@PathVariable Long topicId) {
		
		topicService.deleteTopic(topicId);
		return ResponseEntity.ok(new ApiResponse(true, "Topic Deleted Successfully"));
	}
}




//@RestController
//public class TopicController {
//
//	@Autowired
//	private TopicService topicService;
//	
//	@Autowired
//	private CourseService courseService;
//
//	@RequestMapping(value = "/api/topics")
//	public List<Topic> getAllTopics() {
//		return topicService.getAllTopics();
//	}
//	
//	@RequestMapping(value = "/api/topics/{id}")
//	public Topic getTopicDetails(@PathVariable Long id) {
//		Topic topic = topicService.getTopic(id);
//		
//		if (topic == null)
//			throw new TopicNotFoundException("id-" + id);
//		
//		return topic;
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, value = "/api/topics")
//	public ResponseEntity<Object> addTopic(@Valid @RequestBody Topic topic) {
//		Topic newTopic = new Topic(topic);
//		
//		topicService.addTopic(newTopic);
//		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(newTopic.getId()).toUri();
//		
//		return ResponseEntity.created(location).build();
//	}
//
//	@RequestMapping(method = RequestMethod.PUT, value = "/api/topics/{id}")
//	public ResponseEntity<Object> updateTopic(@Valid @RequestBody Topic topic, @PathVariable Long id) {
//		
//		if (topicService.getTopic(id) == null)
//			return ResponseEntity.notFound().build();
//		
//		topic.setId(id);		
//		topicService.updateTopic(topic);
//		
//		return ResponseEntity.noContent().build();
//	}
//
//	@RequestMapping(method = RequestMethod.DELETE, value = "/api/topics/{id}")
//	@Transactional
//	public void deleteTopic(@PathVariable Long id) {
//		courseService.deleteCoursesByTopic(id);
//		topicService.deleteTopic(id);
//	}
//}
