package com.infybuzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infybuzz.request.CreateDoctorRequest;
import com.infybuzz.response.DoctorResponse;
import com.infybuzz.service.DoctorService;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;
    
    @GetMapping("/getAll")
    public List<DoctorResponse> getAllDoctors() {
        return doctorService.getAllDoctors();
    }


    @PostMapping("/create")
    public DoctorResponse createDoctor(@RequestBody CreateDoctorRequest createDoctorRequest) {
        return doctorService.createDoctor(createDoctorRequest);
    }

    @GetMapping("/getById/{id}")
    public DoctorResponse getById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/update/{id}")
    public DoctorResponse updateDoctor(@PathVariable Long id, @RequestBody CreateDoctorRequest updateDoctorRequest) {
        return doctorService.updateDoctor(id, updateDoctorRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDoctorById(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
    }

}
