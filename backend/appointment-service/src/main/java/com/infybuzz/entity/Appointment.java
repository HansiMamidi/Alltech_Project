package com.infybuzz.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    
    // Reference to user ID
    @Column(name="user_id")
    private Long userId;
    
    // Reference to doctor ID
    @Column(name="doctor_id")
    private Long doctorId;
    
    // Other appointment fields
    @Column(name="appointment_datetime")
    private Date date;

    // Constructor, getters, and setters
    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	public Appointment(Long appointmentId, Long userId, Long doctorId, Date date) {
		super();
		this.appointmentId = appointmentId;
		this.userId = userId;
		this.doctorId = doctorId;
		this.date = date;
	}

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", userId=" + userId + ", doctorId=" + doctorId
				+ ", date=" + date + "]";
	}
    
    
    
}
