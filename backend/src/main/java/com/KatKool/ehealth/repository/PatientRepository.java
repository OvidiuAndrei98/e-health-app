package com.KatKool.ehealth.repository;

import com.KatKool.ehealth.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
