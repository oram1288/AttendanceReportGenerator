package com.keyin.domain.courseclass;

import com.keyin.domain.course.Course;
import com.keyin.domain.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CourseClassController {
    @Autowired
    private CourseClassService courseClassService;

    @GetMapping("/course_classes")
    public List<CourseClass> getAllCourseClasses() {
        return courseClassService.findAllCoursesClasses();
    }

    @GetMapping("/course_class/{id}")
    public CourseClass getCourseClassByID(@PathVariable long id) {
        return courseClassService.findCourseClassById(id);
    }

    @PostMapping("/course_class")
    public CourseClass createCourseClass(@RequestBody CourseClass newCourseClass) {
        return courseClassService.createCourseClass(newCourseClass);
    }

    @PutMapping("/course_class/{id}")
    public CourseClass updateCourse(@RequestBody CourseClass updatedCourseClass) {
        return courseClassService.updateCourseClass(updatedCourseClass);
    }
}