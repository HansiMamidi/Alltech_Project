package com.infybuzz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infybuzz.entity.City;
import com.infybuzz.repository.CityRepository;
import com.infybuzz.request.CreateCityRequest;
import com.infybuzz.response.CityResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    Logger logger = LoggerFactory.getLogger(CityService.class);

    @Autowired
    CityRepository cityRepository;

    public CityResponse createCity(CreateCityRequest createCityRequest) {
        City city = new City();
        city.setCityName(createCityRequest.getCityName());

        City savedCity = cityRepository.save(city);

        return new CityResponse(savedCity);
    }

    public CityResponse getCityById(Long id) {
        logger.info("Inside getCityById " + id);
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id: " + id));
        return new CityResponse(city);
    }

    public List<CityResponse> getAllCities() {
        logger.info("Inside getAllCities");
        List<City> cities = cityRepository.findAll();
        return cities.stream()
                .map(CityResponse::new)
                .collect(Collectors.toList());
    }

    public CityResponse updateCity(Long id, CreateCityRequest updateCityRequest) {
        logger.info("Inside updateCity " + id);
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id: " + id));

        if (updateCityRequest.getCityName() != null) {
            city.setCityName(updateCityRequest.getCityName());
        }

        City updatedCity = cityRepository.save(city);

        return new CityResponse(updatedCity);
    }

    public void deleteCityById(Long id) {
        logger.info("Inside deleteCityById " + id);
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id: " + id));
        cityRepository.delete(city);
    }
}
