package com.KatKool.ehealth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
//    private List<Nurse> nursesList;
//    private List<Room> roomsList ;

    public Department(String name) {
        this.name = name;
//        this.nursesList = nursesList;
//        this.roomsList = roomsList;
    }
}
