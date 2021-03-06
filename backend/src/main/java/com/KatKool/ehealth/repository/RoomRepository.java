package com.KatKool.ehealth.repository;

import com.KatKool.ehealth.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findAllByDepartmentId(Long id);
}
