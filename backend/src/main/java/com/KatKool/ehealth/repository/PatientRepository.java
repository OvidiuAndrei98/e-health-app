package com.KatKool.ehealth.repository;

import com.KatKool.ehealth.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAllByDepartmentId(int id);

    @Modifying
    @Transactional
    @Query("update Patient d set d.name = ?1, d.age = ?2, d.sex = ?3, d.phoneNumber = ?4," +
            " d.diagnosis = ?5, d.notes = ?6, d.bedId = ?7, d.roomId = ?8, d.departmentId = ?9," +
            " d.admissionDate = ?10, d.dischargeDate = ?11, d.assignedDoctorId = ?12," +
            " d.assignedNurseId = ?13 where d.id = ?14")
    void updatePatientDetails(@Param("name") String name,
                              @Param("age") int age,
                              @Param("sex") String sex,
                              @Param("phoneNumber") String phoneNumber,
                              @Param("diagnosis") String diagnosis,
                              @Param("notes") String notes,
                              @Param("bedId") int bedId,
                              @Param("roomId") int roomId,
                              @Param("departmentId") int departmentId,
                              @Param("admissionDate") LocalDate admissionDate,
                              @Param("dischargeDate") LocalDate dischargeDate,
                              @Param("assignedDoctorId") int assignedDoctorId,
                              @Param("assignedNurseId") int assignedNurseId,
                              @Param("id") Long id
    );

}
