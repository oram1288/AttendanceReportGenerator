package com.keyin.domain.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RegisteredStudentService registeredStudentService;

    public Course createCourse(Course newCourse) {
        List<RegisteredStudent> studentsForNewCourse = newCourse.getRegisteredStudents();

        for (RegisteredStudent student : studentsForNewCourse) {
            RegisteredStudent registeredStudentFound = registeredStudentService.findByEmailAddress(student.getEmailAddress());

            if (registeredStudentFound == null) {
                registeredStudentFound = registeredStudentService.createRegisteredStudent(student);
            } else {
                student.setId(registeredStudentFound.getId());
            }
        }

        return courseRepository.save(newCourse);
    }

    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course findCourseById(long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);

        return courseOptional.orElse(null);
    }
}
