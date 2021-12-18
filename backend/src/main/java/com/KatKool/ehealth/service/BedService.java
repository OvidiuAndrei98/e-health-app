package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Bed;
import com.KatKool.ehealth.model.Patient;
import com.KatKool.ehealth.model.Room;
import com.KatKool.ehealth.repository.BedRepository;
import com.KatKool.ehealth.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BedService {
    private BedRepository bedRepository;
    private RoomRepository roomRepository;

    @Autowired
    public BedService(BedRepository bedRepository, RoomRepository roomRepository) {
        this.bedRepository = bedRepository;
        this.roomRepository = roomRepository;
    }

    public List<Bed> getAllBedsForRoom(Long id) {
        return bedRepository.findAllByRoomId(id);
    }

    public void addBed(Long id) {
        Room room = roomRepository.getById(id);
        Bed bed = new Bed(room);
        bedRepository.save(bed);

    }

    public List<Bed> getEmptyBedsForRoom(Long id) {
        List<Bed> beds = bedRepository.findAllByRoomId(id);
        return beds.stream().filter(bed -> bed.getPatient() == null).collect(Collectors.toList());
    }

    public String addPatient(Patient patient, Long id) {
        Bed bed = bedRepository.getById(id);
        bed.setPatient(patient);
        bedRepository.save(bed);
        return "patient added";

    }
}
