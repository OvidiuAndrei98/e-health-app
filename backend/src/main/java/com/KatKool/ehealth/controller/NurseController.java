package com.KatKool.ehealth.controller;

import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.model.Nurse;
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
    private NurseService nurseService;

    @Autowired
    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @PostMapping("/add-nurse")
    public ResponseEntity<String> addNurseToDepartment(@RequestBody Nurse nurse) {
        nurseService.addNurseToDepartment(nurse);
        return ResponseEntity.ok("Nurse added to department");
    }

    @GetMapping("/nurse-info/{id}")
    public ResponseEntity<Nurse> getNurseInfo(@PathVariable String id) {
        return ResponseEntity.ok(this.nurseService.getNurseById(Long.parseLong(id)));
    }

    @GetMapping("/department/{id}/all")
    public ResponseEntity<List<Nurse>> getAllNursesByDepartmentId(@PathVariable String id) {
        return ResponseEntity.ok(this.nurseService.getAllNursesByDepartmentId(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateNurseDetails(@RequestBody Nurse nurse, @PathVariable Long id) {
        this.nurseService.update(nurse, id);
        return ResponseEntity.ok("nurse info has been updated for id " + id);
    }
}
