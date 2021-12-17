package com.KatKool.ehealth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String name;
    protected int age;
    protected String sex;
    protected String phoneNumber;
    private String diagnosis;
    private String notes;
    private int bedId;
    private int roomId;
    private int departmentId;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private int assignedDoctorId;
    private int assignedNurseId;

}
