//package com.dxn;
//
//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
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
//import com.dxn.controller.CourseController;
//import com.dxn.controller.TopicController;
//import com.dxn.exception.CourseNotFoundException;
//import com.dxn.exception.TopicNotFoundException;
//import com.dxn.model.Course;
//import com.dxn.model.Topic;
//import com.dxn.service.CourseService;
//import com.dxn.service.TopicService;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CourseControllerTest {
//
//	@Mock
//	private TopicService topicServiceMock = mock(TopicService.class);
//	@Mock
//	private CourseService courseServiceMock = mock(CourseService.class);
//	
//	@InjectMocks
//	private TopicController topicController = new TopicController();
//	@InjectMocks
//	private CourseController courseController = new CourseController();
//	
//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
//	
//	private static final Logger logger = LogManager.getLogger(CourseControllerTest.class);
//	
//	@Test
//	public void testGetAllCourses() {
//		
//		logger.debug("Running testGetAllCourses()");
//		
//		List<Course> expected = new ArrayList<>();
//		expected.add(new Course("test1", "test1", 1L));
//		expected.add(new Course("test2", "test2", 2L));
//		
//		when(courseServiceMock.getAllCourses()).thenReturn(expected);
//		
//		List<Course> actual = courseController.getAllCourses();
//		
//		assertArrayEquals(expected.toArray(), actual.toArray());
//	}
//	
//	@Test
//	public void testGetCoursesByTopic() {
//		
//		logger.debug("Running testGetCoursesByTopic()");
//		
//		List<Course> expected = new ArrayList<>();
//		expected.add(new Course("test1", "test1", 1L));
//		expected.add(new Course("test2", "test2", 1L));
//		
//		when(courseServiceMock.getCoursesByTopic(1L)).thenReturn(expected);
//		when(topicServiceMock.getTopic(1L)).thenReturn(new Topic());
//		when(topicServiceMock.getTopic(0L)).thenReturn(null);
//		
//		List<Course> actual = courseController.getCoursesByTopic(1L);
//		assertArrayEquals(expected.toArray(), actual.toArray());
//		
//		// test that exception is thrown when given topic doesn't exist
//		thrown.expect(TopicNotFoundException.class);
//		courseController.getCoursesByTopic(0L);
//	}
//	
//	@Test
//	public void testGetCourse() {
//		
//		logger.debug("Running testGetCourse()");
//		
//		Course expected = new Course("test1", "test1", 2L);
//		
//		when(courseServiceMock.getCourse(1L)).thenReturn(expected);
//		when(courseServiceMock.getCourse(0L)).thenReturn(null);
//		
//		Course actual = courseController.getCourse(1L);
//		
//		assertEquals(expected, actual);
//		
//		thrown.expect(CourseNotFoundException.class);
//		courseController.getCourse(0L);
//	}
//	
////	@Test
////	public void testAddCourse() {
////		
////	}
//	
//	@Test
//	public void testUpdateCourse() {
//		
//		logger.debug("Running testUpdateCourse()");
//		
//		ResponseEntity<Object> expectedNotFound = ResponseEntity.notFound().build();
//		ResponseEntity<Object> expectedNoContent = ResponseEntity.noContent().build();
//		
//		Course newCourse = new Course();
//		
//		when(topicServiceMock.getTopic(0L)).thenReturn(null);
//		when(topicServiceMock.getTopic(1L)).thenReturn(new Topic());
//		when(courseServiceMock.getCourse(0L)).thenReturn(null);
//		when(courseServiceMock.getCourse(1L)).thenReturn(newCourse);
//		
//
//		newCourse.setTopicId(1L);
//		ResponseEntity<Object> actualNotFound = courseController.updateCourse(newCourse, 0L);
//		assertEquals(expectedNotFound, actualNotFound);
//		
//		ResponseEntity<Object> actualNoContent = courseController.updateCourse(newCourse, 1L);
//		assertEquals(expectedNoContent, actualNoContent);
//		
//		newCourse.setTopicId(0L);
//		thrown.expect(TopicNotFoundException.class);
//		courseController.updateCourse(newCourse, 1L);		
//	}
//}
