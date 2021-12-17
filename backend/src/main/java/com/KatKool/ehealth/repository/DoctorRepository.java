package com.KatKool.ehealth.repository;

import com.KatKool.ehealth.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findAllByDepartmentId(int id);

    @Modifying
    @Transactional
    @Query("update Doctor d set d.name = ?1, d.age = ?2, d.sex = ?3, d.phoneNumber = ?4," +
            " d.startDate = ?5, d.endDate = ?6, d.departmentId = ?7 where d.id = ?8")
    void updateDoctorDetails(@Param("name") String name,
                          @Param("age") int age,
                          @Param("sex") String sex,
                          @Param("phoneNumber") String phoneNumber,
                          @Param("startDate") LocalDate startDate,
                          @Param("endDate") LocalDate endDate,
                          @Param("departmentId") int departmentId,
                          @Param("id") Long id
                          );
}
