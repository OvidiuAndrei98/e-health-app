package com.KatKool.ehealth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String sex;
    private String phoneNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Department department;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Patient> patients;

    public Nurse(String name, int age, String sex, String phoneNumber, LocalDate startDate, Department department, List<Patient> patients) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.department = department;
        this.patients = patients;
    }
}
