package com.KatKool.ehealth.controller;

import com.KatKool.ehealth.model.Patient;
import com.KatKool.ehealth.service.DoctorService;
import com.KatKool.ehealth.service.NurseService;
import com.KatKool.ehealth.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final NurseService nurseService;

    @Autowired
    public PatientController(PatientService patientService, DoctorService doctorService,NurseService nurseService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.nurseService = nurseService;
    }

    @PutMapping("/save-patient")
    public ResponseEntity<String> savePatient(@RequestBody Patient patient) {

        patientService.savePatient(patient);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/patients/{docId}")
    public ResponseEntity<List<Patient>> getPatientsForDept(@PathVariable Long docId) {
        return ResponseEntity.ok(patientService.getAllForDept(docId));
    }
}
