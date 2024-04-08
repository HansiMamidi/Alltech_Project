package com.infybuzz.response;

import com.infybuzz.entity.Doctor;

public class DoctorResponse {

	private Long doctorId;
	private String doctorName;
	private Long specializationId;
	private Long cityId;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
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
	public DoctorResponse(Doctor doctor) {
		super();
		this.doctorId = doctor.getDoctorId();
		this.doctorName = doctor.getDoctorName();
		this.specializationId = doctor.getSpecializationId();
		this.cityId = doctor.getCityId();
	}
	
	
}
