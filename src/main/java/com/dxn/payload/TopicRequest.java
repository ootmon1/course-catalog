package com.dxn.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TopicRequest {
	
	@NotBlank
	@Size(max = 25)
	private String name;
	
	@NotBlank
	@Size(max = 100)
	private String description;

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

}
