package com.dxn.model;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 25)
	private String name;
	
	@NotBlank
	@Size(max = 100)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "topic_id", nullable = false)
	private Topic topic;
	
	public Course() {
		
	}
	
	public Course(String name, String description, Topic topic) {
		this.name = name;
		this.description = description;
		this.topic = topic;
	}
	
	public Course(Course course) {
		this.name = course.name;
		this.description = course.description;
		this.topic = course.topic;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		
		Course that = (Course) o;
		return Objects.equals(id, that.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
