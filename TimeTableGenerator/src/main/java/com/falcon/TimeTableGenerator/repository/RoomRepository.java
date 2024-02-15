package com.falcon.TimeTableGenerator.repository;

import com.falcon.TimeTableGenerator.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
