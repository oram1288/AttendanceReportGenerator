package com.keyin.domain.report;

import com.keyin.domain.course.CourseService;
import com.keyin.domain.registeredstudent.RegisteredStudent;
import com.keyin.domain.attendingstudent.AttendingStudent;
import com.keyin.domain.courseclass.CourseClass;
import com.keyin.domain.courseclass.CourseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassAttendanceReportService {
    @Autowired
    private CourseClassService courseClassService;
    @Autowired
    private CourseService courseService;

    public ClassAttendanceReport createClassAttendanceReport(long courseClassId) {
        ClassAttendanceReport classAttendanceReport = new ClassAttendanceReport();

        CourseClass courseClassForReport = courseClassService.findCourseClassById(courseClassId);

        classAttendanceReport.setCourseName(courseClassForReport.getCourse().getCourseName());
        classAttendanceReport.setClassOccurenceDate(courseClassForReport.getOccurenceDate());
        classAttendanceReport.setSemester(courseClassForReport.getCourse().getSemester());
        classAttendanceReport.setYear(courseClassForReport.getCourse().getYear());

        if (courseClassForReport != null) {
            List<RegisteredStudent> registeredStudents = courseClassForReport.getCourse().getRegisteredStudents();

            for (RegisteredStudent registeredStudent : registeredStudents) {
                StudentAttendanceReport studentAttendanceReport = new StudentAttendanceReport();
                studentAttendanceReport.setName(registeredStudent.getName());
                studentAttendanceReport.setEmailAddress(registeredStudent.getEmailAddress());

                for (AttendingStudent attendingStudent : courseClassForReport.getAttendingStudents()) {
                    if (attendingStudent.getEmailAddress().equalsIgnoreCase(registeredStudent.getEmailAddress())) {
                        studentAttendanceReport.setAttended(true);
                    }
                }

                classAttendanceReport.getStudentAttendanceReports().add(studentAttendanceReport);
            }

        }

        return classAttendanceReport;
    }
}
