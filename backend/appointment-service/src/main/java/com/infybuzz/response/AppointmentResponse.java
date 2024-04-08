package com.infybuzz.response;

import java.util.Date;

import com.infybuzz.entity.Appointment;

public class AppointmentResponse {

    private Long appointmentId;
    private Long userId;
    private Long doctorId;
    private Date date;

    // Constructors, getters, and setters

    public AppointmentResponse() {
    }

    public AppointmentResponse(Appointment appointment) {
        this.appointmentId = appointment.getAppointmentId();
        this.userId = appointment.getUserId();
        this.doctorId = appointment.getDoctorId();
        this.date = appointment.getDate();
    }

    // Getters and setters

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

    @Override
    public String toString() {
        return "AppointmentResponse{" +
                "appointmentId=" + appointmentId +
                ", userId=" + userId +
                ", doctorId=" + doctorId +
                ", date=" + date +
                '}';
    }
}
