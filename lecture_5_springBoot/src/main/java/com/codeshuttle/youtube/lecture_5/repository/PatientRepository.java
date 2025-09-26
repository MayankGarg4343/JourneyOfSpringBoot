package com.codeshuttle.youtube.lecture_5.repository;

import com.codeshuttle.youtube.lecture_5.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
