package com.KatKool.ehealth.controller;

import com.KatKool.ehealth.model.Doctor;
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

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/add-doctor")
    public ResponseEntity<String> addDoctorToDepartment(@RequestBody Doctor doctor) {
        doctorService.addDoctorToDepartment(doctor);
        return ResponseEntity.ok("Doctor added to department");
    }

    @GetMapping("/doctor-info/{id}")
    public ResponseEntity<Doctor> getDoctorInfo(@PathVariable String id) {
        return ResponseEntity.ok(this.doctorService.getDoctorById(Long.parseLong(id)));
    }

    @GetMapping("/department/{id}/all")
    public ResponseEntity<List<Doctor>> getAllDoctorsByDepartmentId(@PathVariable String id) {
        return ResponseEntity.ok(this.doctorService.getAllDoctorsByDepartmentId(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDoctorDetails(@RequestBody Doctor doctor, @PathVariable Long id) {
        this.doctorService.update(doctor, id);
        return ResponseEntity.ok("doctor info has been updated for id " + id);
    }
}
