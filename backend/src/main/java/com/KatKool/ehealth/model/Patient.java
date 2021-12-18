package com.KatKool.ehealth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String sex;
    private String phoneNumber;
    private String diagnosis;
    private String notes;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Doctor doctor;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Nurse nurse;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//    private Bed bed;


    public Patient(String name) {
        this.name = name;
    }

    public Patient(String name, int age, String sex, String phoneNumber, String diagnosis, String notes, LocalDate admissionDate) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.diagnosis = diagnosis;
        this.notes = notes;
        this.admissionDate = admissionDate;
    }
}
