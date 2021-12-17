package com.KatKool.ehealth.repository;

import com.KatKool.ehealth.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
    List<Nurse> findAllByDepartmentId(int id);

    @Modifying
    @Transactional
    @Query("update Nurse d set d.name = ?1, d.age = ?2, d.sex = ?3, d.phoneNumber = ?4," +
            " d.startDate = ?5, d.endDate = ?6, d.departmentId = ?7")
    void updateNurseDetails(String name,
                            int age,
                            String sex,
                            String phoneNumber,
                            LocalDate startDate,
                            LocalDate endDate,
                            int departmentId,
                            Long id);

    //    void updateNurseDetails(@Param("name") String name,
//                             @Param("age") int age,
//                             @Param("sex") String sex,
//                             @Param("phoneNumber") String phoneNumber,
//                             @Param("startDate") String startDate,
//                             @Param("endDate") String endDate,
//                             @Param("departmentId") String departmentId
//    );
}
