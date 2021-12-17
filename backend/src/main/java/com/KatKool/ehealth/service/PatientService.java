package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Patient;
import com.KatKool.ehealth.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository pr;

    @Autowired
    public PatientService(PatientRepository pr) {
        this.pr = pr;
    }

    public void addPatientToDepartment(Patient patient) {
        pr.save(patient);
    }

    public Patient getPatientById(long id) {
        return pr.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Could not find patient with id: " + id));
    }

    public List<Patient> getAllPatientsByDepartmentId(String id) {
        return this.pr.findAllByDepartmentId(Integer.parseInt(id));
    }

    public void update(Patient patient, Long id) {
        this.pr.updatePatientDetails(patient.getName(), patient.getAge(), patient.getSex(),patient.getPhoneNumber(),
                patient.getDiagnosis(), patient.getNotes(), patient.getBedId(), patient.getRoomId(), patient.getDepartmentId(),
                patient.getAdmissionDate(),patient.getDischargeDate(), patient.getAssignedDoctorId(),patient.getAssignedNurseId(), id);
    }
}
