package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Room;
import com.KatKool.ehealth.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private RoomRepository repository;

    @Autowired
    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public List<Room> getAllRoomsForDepartmenr(Long id) {
        return repository.findAllByDepartmentId(id);
    }
}
