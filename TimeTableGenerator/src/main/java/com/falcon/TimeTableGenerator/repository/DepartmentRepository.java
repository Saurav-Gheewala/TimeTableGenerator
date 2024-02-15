package com.falcon.TimeTableGenerator.repository;

import com.falcon.TimeTableGenerator.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
