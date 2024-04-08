package com.infybuzz.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="specializations")
public class Specialization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long specializationId;
	
	@Column(name="specialization_name")
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

	public Specialization(Long specializationId, String specializationName) {
		super();
		this.specializationId = specializationId;
		this.specializationName = specializationName;
	}

	public Specialization() {
		super();
	}

	@Override
	public String toString() {
		return "Specialization [specializationId=" + specializationId + ", specializationName=" + specializationName
				+ "]";
	}
	
	

	
}
