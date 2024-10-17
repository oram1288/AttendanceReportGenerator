package com.keyin.domain.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/course/{id}")
    public Course getCourseByID(@PathVariable long id) {
        return courseService.findCourseById(id);
    }

    @PostMapping("/course")
    public Course createCourse(@RequestBody Course newCourse) {
        return courseService.createCourse(newCourse);
    }
}
