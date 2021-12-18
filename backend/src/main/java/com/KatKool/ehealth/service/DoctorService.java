package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.model.Patient;
import com.KatKool.ehealth.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> searchDoctor(String name) {
        return doctorRepository.findDoctorByNameContainingIgnoreCase(name);
    }

    public Doctor getDoctorByPatient(Patient patient) {
        return doctorRepository.getDoctorByPatients(patient);
    }
}
