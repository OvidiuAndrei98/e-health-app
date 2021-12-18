package com.KatKool.ehealth.repository;

import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findDoctorByNameContainingIgnoreCase(String search);
    List<Doctor> findAllByDepartmentId(Long id);
    boolean existsByUsername(String username);
    Doctor findByUsername(String username);
}
