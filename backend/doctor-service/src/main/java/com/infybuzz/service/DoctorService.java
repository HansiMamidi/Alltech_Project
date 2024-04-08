package com.infybuzz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infybuzz.entity.Doctor;
import com.infybuzz.repository.DoctorRepository;
import com.infybuzz.request.CreateDoctorRequest;
import com.infybuzz.response.DoctorResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    Logger logger = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    DoctorRepository doctorRepository;

    public DoctorResponse createDoctor(CreateDoctorRequest createDoctorRequest) {
        Doctor doctor = new Doctor();
        doctor.setDoctorName(createDoctorRequest.getDoctorName());
        doctor.setSpecializationId(createDoctorRequest.getSpecializationId());
        doctor.setCityId(createDoctorRequest.getCityId());

        Doctor savedDoctor = doctorRepository.save(doctor);

        return new DoctorResponse(savedDoctor);
    }

    public DoctorResponse getDoctorById(Long id) {
        logger.info("Inside getDoctorById " + id);
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
        return new DoctorResponse(doctor);
    }

    public List<DoctorResponse> getAllDoctors() {
        logger.info("Inside getAllDoctors");
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(DoctorResponse::new)
                .collect(Collectors.toList());
    }

    public DoctorResponse updateDoctor(Long id, CreateDoctorRequest updateDoctorRequest) {
        logger.info("Inside updateDoctor " + id);
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

        if (updateDoctorRequest.getDoctorName() != null) {
            doctor.setDoctorName(updateDoctorRequest.getDoctorName());
        }

        if (updateDoctorRequest.getSpecializationId() != null) {
            doctor.setSpecializationId(updateDoctorRequest.getSpecializationId());
        }

        if (updateDoctorRequest.getCityId() != null) {
            doctor.setCityId(updateDoctorRequest.getCityId());
        }

        Doctor updatedDoctor = doctorRepository.save(doctor);

        return new DoctorResponse(updatedDoctor);
    }

    public void deleteDoctorById(Long id) {
        logger.info("Inside deleteDoctorById " + id);
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
        doctorRepository.delete(doctor);
    }
}
