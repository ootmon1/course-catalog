package com.dxn.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxn.exception.ResourceNotFoundException;
import com.dxn.model.Topic;
import com.dxn.payload.TopicRequest;
import com.dxn.payload.TopicResponse;
import com.dxn.repository.CourseRepository;
import com.dxn.repository.TopicRepository;
import com.dxn.util.ModelMapper;

@Service
public class TopicService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	public static final Logger logger = LoggerFactory.getLogger(TopicService.class);
	
	public List<TopicResponse> getAllTopics() {
		
		List<TopicResponse> topicResponses = new ArrayList<>();
		topicRepository.findAll().forEach(topic -> {
			topicResponses.add(ModelMapper.mapTopicToTopicResponse(topic));
		});
		
		return topicResponses;		
	}
	
	public TopicResponse getTopicById(Long topicId) {
		
		Topic topic = topicRepository.findById(topicId).orElseThrow(
				() -> new ResourceNotFoundException("Topic", "id", topicId));
		
		return ModelMapper.mapTopicToTopicResponse(topic);
	}
	
	public Topic createTopic(TopicRequest topicRequest) {
		
		Topic topic = new Topic(topicRequest.getName(), topicRequest.getDescription());
		
		return topicRepository.save(topic);
	}
	
	public Topic updateTopic(Long topicId, TopicRequest topicRequest) {
		
		Topic topic = topicRepository.findById(topicId).orElseThrow(
				() -> new ResourceNotFoundException("Topic", "id", topicId));
		
		topic.setName(topicRequest.getName());
		topic.setDescription(topicRequest.getDescription());
		
		return topicRepository.save(topic);
	}
	
	@Transactional
	public void deleteTopic(Long topicId) {
		
		topicRepository.findById(topicId).orElseThrow(
				() -> new ResourceNotFoundException("Topic", "id", topicId));
		
		courseRepository.deleteByTopicId(topicId);
		topicRepository.deleteById(topicId);
	}

//	public List<Topic> getAllTopics() {
//
//		List<Topic> topics = new ArrayList<>();
//		topicRepository.findAll().forEach(topics::add);
//		return topics;
//	}

//	public Topic getTopic(Long id) {
//
//		return topicRepository.findById(id).orElse(null);
//	}
//
//	public Topic addTopic(Topic topic) {
//		return topicRepository.save(topic);
//
//	}
//
//	public Topic updateTopic(Topic topic) {
//		return topicRepository.save(topic);
//
//	}
//
//	public void deleteTopic(Long id) {
//		topicRepository.deleteById(id);
//	}
}
