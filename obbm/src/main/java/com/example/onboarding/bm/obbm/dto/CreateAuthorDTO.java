package com.example.onboarding.bm.obbm.dto;

public class CreateAuthorDTO {
	private String name;
	
	public CreateAuthorDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CreateAuthorDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
