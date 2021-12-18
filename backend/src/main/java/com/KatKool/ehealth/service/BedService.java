package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Bed;
import com.KatKool.ehealth.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedService {
    private BedRepository bedRepository;

    @Autowired
    public BedService(BedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    public List<Bed> getAllBedsForRoom(Long id) {
        return bedRepository.findAllByRoomId(id);
    }
}
