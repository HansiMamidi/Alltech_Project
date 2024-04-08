package com.infybuzz.service;

import com.infybuzz.entity.Specialization;
import com.infybuzz.repository.SpecializationRepository;
import com.infybuzz.request.CreateSpecializationRequest;
import com.infybuzz.response.SpecializationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecializationService {

    Logger logger = LoggerFactory.getLogger(SpecializationService.class);

    @Autowired
    SpecializationRepository specializationRepository;

    public SpecializationResponse createSpecialization(CreateSpecializationRequest createSpecializationRequest) {
        Specialization specialization = new Specialization();
        specialization.setSpecializationName(createSpecializationRequest.getSpecializationName());

        Specialization savedSpecialization = specializationRepository.save(specialization);

        return new SpecializationResponse(savedSpecialization);
    }

    public SpecializationResponse getSpecializationById(Long id) {
        logger.info("Inside getSpecializationById " + id);
        Specialization specialization = specializationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found with id: " + id));
        return new SpecializationResponse(specialization);
    }

    public List<SpecializationResponse> getAllSpecializations() {
        logger.info("Inside getAllSpecializations");
        List<Specialization> specializations = specializationRepository.findAll();
        return specializations.stream()
                .map(SpecializationResponse::new)
                .collect(Collectors.toList());
    }

    public SpecializationResponse updateSpecialization(Long id, CreateSpecializationRequest updateSpecializationRequest) {
        logger.info("Inside updateSpecialization " + id);
        Specialization specialization = specializationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found with id: " + id));

        if (updateSpecializationRequest.getSpecializationName() != null) {
            specialization.setSpecializationName(updateSpecializationRequest.getSpecializationName());
        }

        Specialization updatedSpecialization = specializationRepository.save(specialization);

        return new SpecializationResponse(updatedSpecialization);
    }

    public void deleteSpecializationById(Long id) {
        logger.info("Inside deleteSpecializationById " + id);
        Specialization specialization = specializationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found with id: " + id));
        specializationRepository.delete(specialization);
    }
}
