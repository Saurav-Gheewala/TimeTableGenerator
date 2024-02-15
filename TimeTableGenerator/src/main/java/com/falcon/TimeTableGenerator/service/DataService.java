package com.falcon.TimeTableGenerator.service;

import com.falcon.TimeTableGenerator.model.*;
import com.falcon.TimeTableGenerator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DataService
{
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    TimingRepository timingRepository;
    @Autowired
    TimetableSlotRepository timetableSlotRepository;
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Timing addTiming(Timing timing) {
        return timingRepository.save(timing);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public Section addSection(Section section) {
        return sectionRepository.save(section);
    }
    public List<TimetableSlot> generateTimetable() {
        List<Department> departments = departmentRepository.findAll();
        List<Teacher> teachers = teacherRepository.findAll();
        List<Room> rooms = roomRepository.findAll();
        List<Timing> timings = timingRepository.findAll();
        List<Course> courses = courseRepository.findAll();
        List<Section> sections = sectionRepository.findAll();


        List<TimetableSlot> timetableSlots = new ArrayList<>();

        for (Department department : departments) {
            Set<Course> departmentCourses = department.getCourses();

            for (Teacher teacher : department.getTeachers()) {
                Set<Course> preferredCourses = teacher.getPreferredCourses();

                for (Room room : rooms) {
                    for (Timing timing : timings) {
                        for (Course course : departmentCourses) {
                            if (preferredCourses.contains(course)) {
                                for (Section section : sections) {
                                    TimetableSlot timetableSlot = new TimetableSlot();
                                    timetableSlot.setTeacher(teacher);
                                    timetableSlot.setRoom(room);
                                    timetableSlot.setTiming(timing);
                                    timetableSlot.setCourse(course);
                                    timetableSlot.setDepartment(department);
                                    timetableSlot.setSection(section);

                                    timetableSlotRepository.save(timetableSlot);
                                    timetableSlots.add(timetableSlot);
                                }
                            }
                        }
                    }
                }
            }
        }

        return timetableSlots;
    }
}
