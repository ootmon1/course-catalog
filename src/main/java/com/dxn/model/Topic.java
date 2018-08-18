package com.dxn.model;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "topics")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 25)
	private String name;
	
	@NotBlank
	@Size(max = 100)
	private String description;
	
	public Topic() {
		
	}
	
	public Topic(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Topic(Topic topic) {
		this.name = topic.name;
		this.description = topic.description;
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

	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		
		Topic that = (Topic) o;
		return Objects.equals(id, that.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
