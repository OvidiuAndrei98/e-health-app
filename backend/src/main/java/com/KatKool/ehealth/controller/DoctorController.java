package com.KatKool.ehealth.controller;

import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.model.Patient;
import com.KatKool.ehealth.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<List<Doctor>> searchDoctor(@PathVariable String search){
        return ResponseEntity.ok(doctorService.searchDoctor(search));
    }

    @PostMapping("/doctor-for-patient")
    public ResponseEntity<Doctor> getDoctorForPatient(@RequestBody Patient patient){
        System.out.println("am intrat");
        return ResponseEntity.ok(doctorService.getDoctorByPatient(patient));
    }
}
