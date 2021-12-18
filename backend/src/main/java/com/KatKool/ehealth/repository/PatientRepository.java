package com.KatKool.ehealth.repository;

import com.KatKool.ehealth.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Modifying
    @Transactional
    @Query("update Patient pt set pt.name = ?1 , pt.age = ?2, pt.sex = ?3, pt.diagnosis = ?4  where pt.id = ?5")
    void updatePatient(String name, int age, String sex, String diagnosis, Long id);

    List<Patient> findAllByDoctorId(Long id);
}
