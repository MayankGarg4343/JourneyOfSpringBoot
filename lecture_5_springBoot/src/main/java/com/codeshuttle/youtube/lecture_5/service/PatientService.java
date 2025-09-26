package com.codeshuttle.youtube.lecture_5.service;

import com.codeshuttle.youtube.lecture_5.entity.Patient;
import com.codeshuttle.youtube.lecture_5.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient getPatientById(long id) {
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();
        return p1;
    }
}
