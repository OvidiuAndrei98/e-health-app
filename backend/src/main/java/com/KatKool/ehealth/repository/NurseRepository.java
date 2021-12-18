package com.KatKool.ehealth.repository;

import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.model.Nurse;
import com.KatKool.ehealth.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
    List<Nurse> findNurseByDepartmentIdAndNameContaining(Long id, String search);
    Nurse getNurseByPatients(Patient patient);
}
