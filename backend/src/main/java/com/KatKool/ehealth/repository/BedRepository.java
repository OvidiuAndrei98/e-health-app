package com.KatKool.ehealth.repository;

import com.KatKool.ehealth.model.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BedRepository extends JpaRepository<Bed, Long> {
    List<Bed> findAllByRoomId(Long id);
    Bed findByPatientId(Long id);
}
