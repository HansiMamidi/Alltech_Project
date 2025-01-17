package com.infybuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infybuzz.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
}
