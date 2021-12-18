package com.KatKool.ehealth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String name;
    private int age;
    private String sex;
    private String phoneNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Department department;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<UserRole> roles;


    public Doctor(String username, String password, String name, int age, String sex, String phoneNumber, LocalDate startDate, Department department, Set<UserRole> roles) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.department = department;
        this.roles = roles;
    }
}
