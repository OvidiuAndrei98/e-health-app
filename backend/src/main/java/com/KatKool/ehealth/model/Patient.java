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

    public Patient(String name, int age, String sex, String phoneNumber, String diagnosis, String notes,
                   int bedId, int roomId, int departmentId, LocalDate admissionDate,
                   int assignedDoctorId,  int assignedNurseId) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.diagnosis = diagnosis;
        this.notes = notes;
        this.bedId = bedId;
        this.roomId = roomId;
        this.departmentId = departmentId;
        this.admissionDate = admissionDate;
        this.assignedDoctorId = assignedDoctorId;
        this.assignedNurseId = assignedNurseId;

    }

    public Patient(String name, int age, String sex, String phoneNumber, String diagnosis, String notes,
                   int bedId, int roomId, int departmentId, LocalDate admissionDate, LocalDate dischargeDate,
                   int assignedDoctorId, int assignedNurseId) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.diagnosis = diagnosis;
        this.notes = notes;
        this.bedId = bedId;
        this.roomId = roomId;
        this.departmentId = departmentId;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.assignedDoctorId = assignedDoctorId;
        this.assignedNurseId = assignedNurseId;
    }
}
