package com.infybuzz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infybuzz.entity.Appointment;
import com.infybuzz.repository.AppointmentRepository;
import com.infybuzz.request.CreateAppointmentRequest;
import com.infybuzz.response.AppointmentResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentResponse createAppointment(CreateAppointmentRequest createAppointmentRequest) {
        Appointment appointment = new Appointment();
        appointment.setUserId(createAppointmentRequest.getUserId());
        appointment.setDoctorId(createAppointmentRequest.getDoctorId());
        appointment.setDate(createAppointmentRequest.getDate());

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return new AppointmentResponse(savedAppointment);
    }

    public AppointmentResponse getAppointmentById(Long id) {
        logger.info("Inside getAppointmentById " + id);
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        return new AppointmentResponse(appointment);
    }

    public List<AppointmentResponse> getAllAppointments() {
        logger.info("Inside getAllAppointments");
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(AppointmentResponse::new)
                .collect(Collectors.toList());
    }

    public AppointmentResponse updateAppointment(Long id, CreateAppointmentRequest updateAppointmentRequest) {
        logger.info("Inside updateAppointment " + id);
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));

        if (updateAppointmentRequest.getUserId() != null) {
            appointment.setUserId(updateAppointmentRequest.getUserId());
        }
        if (updateAppointmentRequest.getDoctorId() != null) {
            appointment.setDoctorId(updateAppointmentRequest.getDoctorId());
        }
        if (updateAppointmentRequest.getDate() != null) {
            appointment.setDate(updateAppointmentRequest.getDate());
        }

        Appointment updatedAppointment = appointmentRepository.save(appointment);

        return new AppointmentResponse(updatedAppointment);
    }

    public void deleteAppointmentById(Long id) {
        logger.info("Inside deleteAppointmentById " + id);
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        appointmentRepository.delete(appointment);
    }
}
