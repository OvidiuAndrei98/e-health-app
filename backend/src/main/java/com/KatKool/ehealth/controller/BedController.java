package com.KatKool.ehealth.controller;

import com.KatKool.ehealth.model.Patient;
import com.KatKool.ehealth.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/bed")
public class BedController {

    private final BedService bedService;

    @Autowired
    public BedController(BedService bedService) {
        this.bedService = bedService;
    }

    @PutMapping ("/add/{id}")
    public ResponseEntity<String> addBedToDepartment(@PathVariable Long id) {
        bedService.addBed(id);
        return ResponseEntity.ok("Bed added to room");
    }

    @GetMapping("/beds/{roomId}")
    public ResponseEntity<?> getBedsForRoom(@PathVariable Long roomId) {
        return ResponseEntity.ok(bedService.getAllBedsForRoom(roomId));
    }

    @GetMapping("/beds/{roomId}/empty")
    public ResponseEntity<?> getEmptyBedsForRoom(@PathVariable Long roomId) {
        return ResponseEntity.ok(bedService.getEmptyBedsForRoom(roomId));
    }

    @PostMapping ("/add/patient/{id}")
    public ResponseEntity<?> addPatient(@RequestBody Patient patient, @PathVariable Long id) {
        return ResponseEntity.ok(bedService.addPatient(patient, id));
    }
}
