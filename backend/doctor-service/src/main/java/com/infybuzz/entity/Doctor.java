package com.infybuzz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public Doctor(Long doctorId, String doctorName, Long specializationId, Long cityId) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specializationId = specializationId;
		this.cityId = cityId;
	}
	@Override
	public String toString() {
		return "Product [id=" + doctorId + ", doctorName=" + doctorName + ", specializationId=" + specializationId
				+ ", cityId=" + cityId + "]";
	}
	public Doctor() {
		super();
	}
	
	
	
	
	
	
	
}
