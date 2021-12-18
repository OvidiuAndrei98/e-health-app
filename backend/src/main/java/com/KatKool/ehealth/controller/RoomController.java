package com.KatKool.ehealth.controller;

import com.KatKool.ehealth.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/room")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms/{departmentId}")
    public ResponseEntity<?> getRoomsForDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(roomService.getAllRoomsForDepartmenr(departmentId));
    }


}
