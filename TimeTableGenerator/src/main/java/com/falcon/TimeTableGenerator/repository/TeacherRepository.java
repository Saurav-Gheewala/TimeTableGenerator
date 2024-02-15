package com.falcon.TimeTableGenerator.repository;

import com.falcon.TimeTableGenerator.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
