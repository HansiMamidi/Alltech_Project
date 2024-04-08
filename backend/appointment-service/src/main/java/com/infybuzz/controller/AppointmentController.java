package com.infybuzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infybuzz.request.CreateAppointmentRequest;
import com.infybuzz.response.AppointmentResponse;
import com.infybuzz.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/create")
    public AppointmentResponse createAppointment(@RequestBody CreateAppointmentRequest createAppointmentRequest) {
        return appointmentService.createAppointment(createAppointmentRequest);
    }

    @GetMapping("/getById/{id}")
    public AppointmentResponse getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping("/getAll")
    public List<AppointmentResponse> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PutMapping("/update/{id}")
    public AppointmentResponse updateAppointment(@PathVariable Long id, @RequestBody CreateAppointmentRequest updateAppointmentRequest) {
        return appointmentService.updateAppointment(id, updateAppointmentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAppointmentById(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
    }
}
