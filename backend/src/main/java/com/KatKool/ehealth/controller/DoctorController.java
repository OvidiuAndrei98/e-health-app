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

    @GetMapping("/doctors/{id}")
    public ResponseEntity<List<Doctor>> getAllDoctorsForDept(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.getAllDoctorsForDept(id));
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<List<Doctor>> searchDoctor(@PathVariable String search){
        return ResponseEntity.ok(doctorService.searchDoctor(search));
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.getDoctor(id));
    }

    @PostMapping("/doctor-for-patient/{id}")
    public ResponseEntity<Doctor> getDoctorForPatient(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.getDoctorByPatient(id));
    }
}
