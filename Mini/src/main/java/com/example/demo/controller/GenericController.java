package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.requestModel.CourseRequest;
import com.example.demo.requestModel.LabRequest;
import com.example.demo.service.GenericService;
import com.example.demo.service.TimetableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class GenericController   {
    private final Logger logger = LoggerFactory.getLogger(GenericController.class);

    @Autowired
    GenericService genericService;
    @Autowired
    TimetableService timetableService;
    @PostMapping("/departments")
    public ResponseEntity<String> saveDepartment(@RequestBody Department department) {
        return genericService.saveDepartment(department);
    }

    @PostMapping("/courses")
    public ResponseEntity<String> saveCourse(@RequestBody CourseRequest course) {
        for(CourseInput input : course.getName())
        {
            logger.info(input.getName());
            genericService.saveCourse(input.getName());
        }
        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }

    @PostMapping("/laboratories")
    public ResponseEntity<String> saveLaboratory(@RequestBody LabRequest laboratory) {
        for(LabInput input : laboratory.getName())
        {
            logger.info(input.getName());
            genericService.saveLaboratory(input.getName());
        }
        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }

    @PostMapping("/teachers")
    public ResponseEntity<String> saveTeacher(@RequestBody Teacher teacher) {
        return genericService.saveTeacher(teacher);
    }

    @GetMapping("/time")
    public List<String> generateTimetable()
    {
        return timetableService.createTimetable();
    }

}
