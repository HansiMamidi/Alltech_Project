package com.infybuzz.controller;

import com.infybuzz.request.CreateSpecializationRequest;
import com.infybuzz.response.SpecializationResponse;
import com.infybuzz.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/specializations")
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @PostMapping("/create")
    public SpecializationResponse createSpecialization(@RequestBody CreateSpecializationRequest createSpecializationRequest) {
        return specializationService.createSpecialization(createSpecializationRequest);
    }

    @GetMapping("/getById/{id}")
    public SpecializationResponse getSpecializationById(@PathVariable Long id) {
        return specializationService.getSpecializationById(id);
    }

    @GetMapping("/getAll")
    public List<SpecializationResponse> getAllSpecializations() {
        return specializationService.getAllSpecializations();
    }

    @PutMapping("/update/{id}")
    public SpecializationResponse updateSpecialization(@PathVariable Long id, @RequestBody CreateSpecializationRequest updateSpecializationRequest) {
        return specializationService.updateSpecialization(id, updateSpecializationRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSpecializationById(@PathVariable Long id) {
        specializationService.deleteSpecializationById(id);
    }
}
