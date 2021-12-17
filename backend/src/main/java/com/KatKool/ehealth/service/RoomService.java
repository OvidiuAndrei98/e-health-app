package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Room;
import com.KatKool.ehealth.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void addRoom(Room room) {
        this.roomRepository.save(room);
    }
}
