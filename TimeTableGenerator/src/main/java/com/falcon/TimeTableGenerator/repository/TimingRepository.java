package com.falcon.TimeTableGenerator.repository;

import com.falcon.TimeTableGenerator.model.Timing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimingRepository extends JpaRepository<Timing, Long>
{
}
