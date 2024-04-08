package com.infybuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infybuzz.entity.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long>{

}
