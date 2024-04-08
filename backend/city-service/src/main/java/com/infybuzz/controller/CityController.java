package com.infybuzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infybuzz.request.CreateCityRequest;
import com.infybuzz.response.CityResponse;
import com.infybuzz.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/create")
    public CityResponse createCity(@RequestBody CreateCityRequest createCityRequest) {
        return cityService.createCity(createCityRequest);
    }

    @GetMapping("/getById/{id}")
    public CityResponse getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @GetMapping("/getAll")
    public List<CityResponse> getAllCities() {
        return cityService.getAllCities();
    }

    @PutMapping("/update/{id}")
    public CityResponse updateCity(@PathVariable Long id, @RequestBody CreateCityRequest updateCityRequest) {
        return cityService.updateCity(id, updateCityRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCityById(@PathVariable Long id) {
        cityService.deleteCityById(id);
    }
}
