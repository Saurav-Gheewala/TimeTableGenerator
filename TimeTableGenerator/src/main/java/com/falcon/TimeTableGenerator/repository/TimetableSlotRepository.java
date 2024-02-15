package com.falcon.TimeTableGenerator.repository;

import com.falcon.TimeTableGenerator.model.TimetableSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableSlotRepository extends JpaRepository<TimetableSlot, Long> {
}
