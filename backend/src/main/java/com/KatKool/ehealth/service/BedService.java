package com.KatKool.ehealth.service;

import com.KatKool.ehealth.model.Bed;
import com.KatKool.ehealth.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedService {
    private BedRepository bedRepository;

    @Autowired
    public BedService(BedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    public void addBedToDepartment(Bed bed) {
        this.bedRepository.save(bed);
    }
}
