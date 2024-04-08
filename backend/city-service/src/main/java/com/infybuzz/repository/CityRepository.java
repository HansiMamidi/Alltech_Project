package com.infybuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infybuzz.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
