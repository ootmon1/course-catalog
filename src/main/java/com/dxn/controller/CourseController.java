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

import com.dxn.model.Course;
import com.dxn.payload.ApiResponse;
import com.dxn.payload.CourseRequest;
import com.dxn.payload.CourseResponse;
import com.dxn.service.CourseService;
import com.dxn.util.ModelMapper;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<CourseResponse> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{courseId}")
	public CourseResponse getCourseById(@PathVariable Long courseId) {
		return courseService.getCourseById(courseId);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<CourseResponse> createCourse(@Valid @RequestBody CourseRequest courseRequest) {
		
		Course course = courseService.createCourse(courseRequest);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{courseId}")
				.buildAndExpand(course.getId()).toUri();
		
		return ResponseEntity.created(location).body(ModelMapper.mapCourseToCourseResponse(course));
	}
	
	@PutMapping("/{courseId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<CourseResponse> updateCourse(@Valid @RequestBody CourseRequest courseRequest,
			@PathVariable Long courseId) {
		
		Course course = courseService.updateCourse(courseId, courseRequest);
		return ResponseEntity.ok(ModelMapper.mapCourseToCourseResponse(course));
	}
	
	@DeleteMapping("/{courseId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteCourse(@PathVariable Long courseId) {		
		courseService.deleteCourse(courseId);
		return ResponseEntity.ok(new ApiResponse(true, "Course Deleted Successfully"));
	}
}
