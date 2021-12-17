package com.KatKool.ehealth.controller;

import com.KatKool.ehealth.model.Bed;
import com.KatKool.ehealth.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/bed")
public class BedController {

    private BedService bedService;

    @Autowired
    public BedController(BedService bedService) {
        this.bedService = bedService;
    }

    @PostMapping("/add-bed")
    public ResponseEntity<String> addBedToDepartment(@RequestBody Bed bed) {
        bedService.addBedToDepartment(bed);
        return ResponseEntity.ok("Bed added to department");
    }
}
