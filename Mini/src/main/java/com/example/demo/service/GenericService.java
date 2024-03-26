package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.LaboratoryRepository;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.requestModel.CourseRequest;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericService {

    private final Logger logger = LoggerFactory.getLogger(GenericService.class);
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    LaboratoryRepository laboratoryRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public Department departmentName;
    public ResponseEntity<String> saveDepartment(Department department) {
        departmentName = department;
        Department savedDepartment = departmentRepository.save(department);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
    }

    public void saveCourse(String courseName)
    {
        Course course = new Course(courseName,departmentName);
        Course savedCourse = courseRepository.save(course);
    }

    public void saveLaboratory(String labName) {
        Laboratory lab = new Laboratory(labName,departmentName);
        laboratoryRepository.save(lab);
    }

    public ResponseEntity<String> saveTeacher(Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);
        return ResponseEntity.ok("Teacher saved with ID: " + savedTeacher.getId());
    }
}
