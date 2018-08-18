//package com.dxn;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.ResponseEntity;
//
//import com.dxn.controller.TopicController;
//import com.dxn.exception.TopicNotFoundException;
//import com.dxn.model.Topic;
//import com.dxn.service.TopicService;
//
//@RunWith(MockitoJUnitRunner.class)
//public class TopicControllerTest {
//	
//	@Mock
//	private TopicService topicServiceMock = mock(TopicService.class);
//	
//	@InjectMocks
//	private TopicController topicController = new TopicController();
//	
//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
//	
//	private static final Logger logger = LogManager.getLogger(TopicControllerTest.class);
//
//	@Test
//	public void testGetAllTopics() {
//		
//		logger.debug("Running testGetAllTopics()");
//		
//		List<Topic> expected = new ArrayList<>();
//		expected.add(new Topic("test1", "test1"));
//		expected.add(new Topic("test2", "test2"));
//		
//		when(topicServiceMock.getAllTopics()).thenReturn(expected);
//		
//		List<Topic> actual = topicController.getAllTopics();
//		
//		assertArrayEquals(expected.toArray(), actual.toArray());
//	}
//	
//	@Test
//	public void testGetTopicDetails() {
//		
//		logger.debug("Running testGetTopicDetails()");
//		
//		Topic expected = new Topic("test1", "test1");
//		
//		when(topicServiceMock.getTopic(1L)).thenReturn(expected);
//		when(topicServiceMock.getTopic(0L)).thenReturn(null);
//		
//		Topic actual = topicController.getTopicDetails(1L);
//		
//		assertEquals(expected, actual);
//		
//		// test that exception is thrown when given topic doesn't exist
//		thrown.expect(TopicNotFoundException.class);
//		topicController.getTopicDetails(0L);
//	}
//	
////	@Test
////	public void testAddTopic() {
////		
////		ResponseEntity<Object> expected = ResponseEntity.noContent().build();
////		Topic newTopic = new Topic();
////		newTopic.setId(1L);
////		
////		when(topicServiceMock.addTopic(newTopic)).thenReturn(newTopic);
////	}
//	
//	@Test
//	public void testUpdateTopic() {
//		
//		logger.debug("Running testUpdateTopic()");
//		
//		ResponseEntity<Object> expectedNotFound = ResponseEntity.notFound().build();
//		ResponseEntity<Object> expectedNoContent = ResponseEntity.noContent().build();
//		
//		Topic newTopic = new Topic();
//		
//		when(topicServiceMock.getTopic(0L)).thenReturn(null);
//		when(topicServiceMock.getTopic(1L)).thenReturn(newTopic);
//		
//		ResponseEntity<Object> actualNotFound = topicController.updateTopic(newTopic, 0L);
//		ResponseEntity<Object> actualNoContent = topicController.updateTopic(newTopic, 1L);
//		
//		assertEquals(expectedNotFound, actualNotFound);
//		assertEquals(expectedNoContent, actualNoContent);
//	}
//}
