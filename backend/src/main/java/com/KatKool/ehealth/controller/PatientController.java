package com.KatKool.ehealth.controller;

import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.model.Nurse;
import com.KatKool.ehealth.model.Patient;
import com.KatKool.ehealth.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/patient")
public class PatientController {
    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/add-patient")
    public ResponseEntity<String> addPatientToDepartment(@RequestBody Patient patient) {
        patientService.addPatientToDepartment(patient);
        return ResponseEntity.ok("Patient added to department");
    }

    @GetMapping("/patient-info/{id}")
    public ResponseEntity<Patient> getPatientInfo(@PathVariable String id) {
        return ResponseEntity.ok(this.patientService.getPatientById(Long.parseLong(id)));
    }

    @GetMapping("/department/{id}/all")
    public ResponseEntity<List<Patient>> getAllPatientsByDepartmentId(@PathVariable String id) {
        return ResponseEntity.ok(this.patientService.getAllPatientsByDepartmentId(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePatientDetails(@RequestBody Patient patient, @PathVariable Long id) {
        this.patientService.update(patient, id);
        return ResponseEntity.ok("patient info has been updated for id " + id);
    }
}
