package com.falcon.TimeTableGenerator.repository;

import com.falcon.TimeTableGenerator.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
