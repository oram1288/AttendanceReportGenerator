package com.keyin.domain.course;

import com.keyin.domain.registeredstudent.RegisteredStudent;
import com.keyin.domain.registeredstudent.RegisteredStudentService;
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
        newCourse.setRegisteredStudents(checkIfExistsOrCreate(newCourse.getRegisteredStudents()));

        return courseRepository.save(newCourse);
    }

    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course findCourseById(long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);

        return courseOptional.orElse(null);
    }

    public Course findCourseByName(String name) {
        return courseRepository.findByCourseName(name);
    }

    public Course updateCourse(Course updatedCourse) {
        Course courseToUpdate = findCourseById(updatedCourse.getId());

        if (courseToUpdate != null) {
            courseToUpdate.setCourseName(updatedCourse.getCourseName());
            courseToUpdate.setYear(updatedCourse.getYear());
            courseToUpdate.setSemester(updatedCourse.getSemester());

            courseToUpdate.setRegisteredStudents(checkIfExistsOrCreate(updatedCourse.getRegisteredStudents()));

            courseRepository.save(courseToUpdate);
        }

        return courseToUpdate;
    }


    private List<RegisteredStudent> checkIfExistsOrCreate(List<RegisteredStudent> studentsToCheck) {
        if (studentsToCheck != null) {
            for (RegisteredStudent student : studentsToCheck) {
                RegisteredStudent registeredStudentFound = registeredStudentService.findByEmailAddress(student.getEmailAddress());

                if (registeredStudentFound == null) {
                    registeredStudentFound = registeredStudentService.createRegisteredStudent(student);
                } else {
                    student.setId(registeredStudentFound.getId());
                }
            }
        }

        return studentsToCheck;
    }
}
