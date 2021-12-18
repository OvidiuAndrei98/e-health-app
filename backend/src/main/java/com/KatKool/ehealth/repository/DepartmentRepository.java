package com.KatKool.ehealth.repository;

import com.KatKool.ehealth.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
