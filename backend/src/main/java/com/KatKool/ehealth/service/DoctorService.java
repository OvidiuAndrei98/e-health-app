package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
     private DoctorRepository dr;

     @Autowired
     public DoctorService(DoctorRepository dr) {
          this.dr = dr;
     }

     public void addDoctorToDepartment(Doctor doctor) {
          dr.save(doctor);
     }

    public Doctor getDoctorById(long id) {
        return this.dr.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Could not find doctor with id: " + id));
    }

    public List<Doctor> getAllDoctorsByDepartmentId(String id) {
         return this.dr.findAllByDepartmentId(Integer.parseInt(id));
    }

    public void update(Doctor doctor, Long id) {
         this.dr.updateDoctorDetails(doctor.getName(),doctor.getAge(),doctor.getSex(),doctor.getPhoneNumber(),
                 doctor.getStartDate(),doctor.getEndDate(),doctor.getDepartmentId(), id);
    }
}
