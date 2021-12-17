package com.KatKool.ehealth.controller;

import com.KatKool.ehealth.model.*;
import com.KatKool.ehealth.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
    private PatientService patientService;
    private DoctorService doctorService;
    private NurseService nurseService;
    private DepartmentService departmentService;
    private RoomService roomService;
    private BedService bedService;

    @Autowired
    public AdminController(PatientService patientService, DoctorService doctorService, NurseService nurseService, DepartmentService departmentService, RoomService roomService, BedService bedService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.nurseService = nurseService;
        this.departmentService = departmentService;
        this.roomService = roomService;
        this.bedService = bedService;
    }

//    @PostMapping("/add-doctor")
//    public ResponseEntity<String> addDoctorToDepartment(@RequestBody Doctor doctor) {
//        doctorService.addDoctorToDepartment(doctor);
//        return ResponseEntity.ok("Doctor added to department");
//    }

//    @PostMapping("/add-nurse")
//    public ResponseEntity<String> addNurseToDepartment(@RequestBody Nurse nurse) {
//        nurseService.addNurseToDepartment(nurse);
//        return ResponseEntity.ok("Nurse added to department");
//    }

//    @PostMapping("/add-patient")
//    public ResponseEntity<String> addPatientToDepartment(@RequestBody Patient patient) {
//        patientService.addPatientToDepartment(patient);
//        return ResponseEntity.ok("Patient added to department");
//    }

//    @PostMapping("/add-department")
//    public ResponseEntity<String> addDepartment(@RequestBody Department department) {
//        departmentService.addDepartment(department);
//        return ResponseEntity.ok("Department added");
//    }

//    @PostMapping("/add-room")
//    public ResponseEntity<String> addRoom(@RequestBody Room room) {
//        roomService.addRoom(room);
//        return ResponseEntity.ok("Room added");
//    }

//    @PostMapping("/add-bed")
//    public ResponseEntity<String> addBedToDepartment(@RequestBody Bed bed) {
//        bedService.addBedToDepartment(bed);
//        return ResponseEntity.ok("Bed added to department");
//    }

//    @GetMapping("/patient-info/{id}")
//    public ResponseEntity<Patient> getPatientInfo(@PathVariable String id) {
//        return ResponseEntity.ok(this.patientService.getPatientById(Long.parseLong(id)));
//    }

//    @GetMapping("/nurse-info/{id}")
//    public ResponseEntity<Nurse> getNurseInfo(@PathVariable String id) {
//        return ResponseEntity.ok(this.nurseService.getNurseById(Long.parseLong(id)));
//    }

//    @GetMapping("/doctor-info/{id}")
//    public ResponseEntity<Doctor> getDoctorInfo(@PathVariable String id) {
//        return ResponseEntity.ok(this.doctorService.getDoctorById(Long.parseLong(id)));
//    }


}
