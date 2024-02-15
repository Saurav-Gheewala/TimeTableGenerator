package com.falcon.TimeTableGenerator.controller;

import com.falcon.TimeTableGenerator.model.*;
import com.falcon.TimeTableGenerator.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("data")
public class HomeController
{
    @Autowired
    DataService dataService;

    @PostMapping("/teachers")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        Teacher addedTeacher = dataService.addTeacher(teacher);
        return new ResponseEntity<>(addedTeacher, HttpStatus.CREATED);
    }

    @PostMapping("/rooms")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        Room addedRoom = dataService.addRoom(room);
        return new ResponseEntity<>(addedRoom, HttpStatus.CREATED);
    }

    @PostMapping("/timings")
    public ResponseEntity<Timing> addTiming(@RequestBody Timing timing) {
        Timing addedTiming = dataService.addTiming(timing);
        return new ResponseEntity<>(addedTiming, HttpStatus.CREATED);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course addedCourse = dataService.addCourse(course);
        return new ResponseEntity<>(addedCourse, HttpStatus.CREATED);
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department addedDepartment = dataService.addDepartment(department);
        return new ResponseEntity<>(addedDepartment, HttpStatus.CREATED);
    }
    @PostMapping("/sections")
    public ResponseEntity<Section> addSection(@RequestBody Section section) {
        Section addedSection = dataService.addSection(section);
        return new ResponseEntity<>(addedSection, HttpStatus.CREATED);
    }
    @PostMapping("/generate-timetable")
    public ResponseEntity<List<TimetableSlot>> generateTimetable() {
        List<TimetableSlot> timetable = dataService.generateTimetable();
        return new ResponseEntity<>(timetable, HttpStatus.OK);

}
}
