package com.infybuzz.request;

public class CreateDoctorRequest {

	private String doctorName;
	private Long specializationId;
	private Long cityId;
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Long getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(Long specializationId) {
		this.specializationId = specializationId;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	

}
