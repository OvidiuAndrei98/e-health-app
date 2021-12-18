package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Bed;
import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.model.Patient;
import com.KatKool.ehealth.repository.BedRepository;
import com.KatKool.ehealth.repository.DoctorRepository;
import com.KatKool.ehealth.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final BedRepository bedRepository;


    @Autowired
    public PatientService(PatientRepository patientRepository, BedRepository bedRepository) {
        this.patientRepository = patientRepository;
        this.bedRepository = bedRepository;
    }


    public void  savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Patient> getAllForDept(Long id) {
       return patientRepository.findAllByDoctorId(id);
    }
}
