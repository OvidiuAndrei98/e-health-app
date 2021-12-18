package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.model.Nurse;
import com.KatKool.ehealth.model.Patient;
import com.KatKool.ehealth.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {
    private final NurseRepository nurseRepository;

    @Autowired
    public NurseService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public List<Nurse> searchNursesOnDepartment(String search, Long id) {
        return nurseRepository.findNurseByDepartmentIdAndNameContaining(id,search);
    }

    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }
    public List<Nurse> getAllNursesForDept(Long id) {
        return nurseRepository.findAllByDepartmentId(id);
    }

    public Nurse getNurseByPatient(Long id) {
        return nurseRepository.getById(id);
    }

}
