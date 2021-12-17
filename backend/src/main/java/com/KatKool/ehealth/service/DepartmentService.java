package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Department;
import com.KatKool.ehealth.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void addDepartment(Department department) {
        this.departmentRepository.save(department);
    }
}
