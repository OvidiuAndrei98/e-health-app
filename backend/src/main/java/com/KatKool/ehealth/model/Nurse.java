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
    private int departmentId;
    private int roomId;


    public Nurse(String name, int age, String sex, String phoneNumber, LocalDate startDate,
                 int departmentId, int roomId) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.departmentId = departmentId;
        this.roomId = roomId;
    }

    public Nurse(String name, int age, String sex, String phoneNumber, LocalDate startDate, LocalDate endDate,
                 int departmentId, int roomId) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.departmentId = departmentId;
        this.roomId = roomId;
    }
}
