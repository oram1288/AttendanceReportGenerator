package com.keyin.domain.courseclass;

import com.keyin.domain.attendingstudent.AttendingStudent;
import com.keyin.domain.attendingstudent.AttendingStudentService;
import com.keyin.domain.course.Course;
import com.keyin.domain.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseClassService {
    @Autowired
    private CourseClassRepository courseClassRepository;

    @Autowired
    private AttendingStudentService attendingStudentService;

    @Autowired
    private CourseService courseService;

    public CourseClass createCourseClass(CourseClass newCourseClass) {
        List<AttendingStudent> studentsForNewCourseClass = newCourseClass.getAttendingStudents();

        for (AttendingStudent student : studentsForNewCourseClass) {
            AttendingStudent attendingStudentFound = attendingStudentService.findByEmailAddress(student.getEmailAddress());

            if (attendingStudentFound == null) {
                attendingStudentFound = attendingStudentService.createAttendingStudent(student);
            } else {
                student.setId(attendingStudentFound.getId());
            }
        }

        Course course = newCourseClass.getCourse();
        Course foundCourse = courseService.findCourseByName(course.getCourseName());

        if (foundCourse != null) {
            newCourseClass.setCourse(foundCourse);
        } else {
            courseService.createCourse(course);
        }

        return courseClassRepository.save(newCourseClass);
    }

    public List<CourseClass> findAllCoursesClasses() {
        return (List<CourseClass>) courseClassRepository.findAll();
    }

    public CourseClass findCourseClassById(long id) {
        Optional<CourseClass> courseClassOptional = courseClassRepository.findById(id);

        return courseClassOptional.orElse(null);
    }

    public CourseClass updateCourseClass(CourseClass updatedCourseClass) {
        CourseClass courseClassToUpdate = findCourseClassById(updatedCourseClass.getId());

        if (courseClassToUpdate != null) {
            courseClassToUpdate.setCourse(updatedCourseClass.getCourse());
            courseClassToUpdate.setOccurenceDate(updatedCourseClass.getOccurenceDate());
            courseClassToUpdate.setAttendingStudents(updatedCourseClass.getAttendingStudents());
            courseClassRepository.save(courseClassToUpdate);
        }

        return courseClassToUpdate;
    }
}
