package com.KatKool.ehealth.controller;

import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.model.Nurse;
import com.KatKool.ehealth.model.Patient;
import com.KatKool.ehealth.service.DoctorService;
import com.KatKool.ehealth.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/nurse")
public class NurseController {

    private final NurseService nurseService;

    @Autowired
    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @GetMapping("/search-nurses/{id}/{search}")
    public ResponseEntity<List<Nurse>> searchNursesOnDepartment(@PathVariable Long id, @PathVariable String search) {
        return ResponseEntity.ok(nurseService.searchNursesOnDepartment(search,id));
    }

    @GetMapping("/nurses")
    public ResponseEntity<List<Nurse>> getAllNurses() {
        return ResponseEntity.ok(nurseService.getAllNurses());
    }

    @PostMapping("/nurse-for-patient")
    public ResponseEntity<Nurse> getNurseByPatient(@RequestBody Patient patient){
        return ResponseEntity.ok(nurseService.getNurseByPatient(patient));
    }

}
