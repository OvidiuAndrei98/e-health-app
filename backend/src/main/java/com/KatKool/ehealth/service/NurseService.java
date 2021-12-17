package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Nurse;
import com.KatKool.ehealth.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {
    private NurseRepository nr;

    @Autowired
    public NurseService(NurseRepository nr) {
        this.nr = nr;
    }

    public void addNurseToDepartment(Nurse nurse) {
        nr.save(nurse);
    }

    public Nurse getNurseById(long id) {
        return this.nr.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Could not find nurse with id: " + id));
    }

    public List<Nurse> getAllNursesByDepartmentId(String id) {
        return this.nr.findAllByDepartmentId(Integer.parseInt(id));
    }

    public void update(Nurse nurse, Long id) {
        this.nr.updateNurseDetails(nurse.getName(),nurse.getAge(),nurse.getSex(),nurse.getPhoneNumber(),
                nurse.getStartDate(),nurse.getEndDate(),nurse.getDepartmentId(), id);
    }
}
