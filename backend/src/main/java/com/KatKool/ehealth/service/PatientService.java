package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Patient;
import com.KatKool.ehealth.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void  savePatient(Patient patient) {
        patientRepository.save(patient);
    }
}
