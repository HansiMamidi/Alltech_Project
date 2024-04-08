package com.infybuzz.response;

import javax.persistence.Column;

import com.infybuzz.entity.Specialization;

public class SpecializationResponse {

	private Long specializationId;
	private String specializationName;
	
	public Long getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(Long specializationId) {
		this.specializationId = specializationId;
	}

	public String getSpecializationName() {
		return specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}



	public SpecializationResponse(Specialization specialization) {
		super();
		this.specializationId = specialization.getSpecializationId();
		this.specializationName = specialization.getSpecializationName();
	}
	
	
}
