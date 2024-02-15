package com.falcon.TimeTableGenerator.repository;

import com.falcon.TimeTableGenerator.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
