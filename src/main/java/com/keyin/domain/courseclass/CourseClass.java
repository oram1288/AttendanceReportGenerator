package com.keyin.domain.courseclass;

import com.keyin.domain.course.Course;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class CourseClass {
    @Id
    @SequenceGenerator(name = "course_class_sequence", sequenceName = "course_class_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "course_class_sequence")
    private long id;

    @OneToOne
    private Course course;
    private Date occurenceDate;

    @ManyToMany
    private List<AttendingStudent> attendingStudents;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getOccurenceDate() {
        return occurenceDate;
    }

    public void setOccurenceDate(Date occurenceDate) {
        this.occurenceDate = occurenceDate;
    }

    public List<AttendingStudent> getAttendingStudents() {
        return attendingStudents;
    }

    public void setAttendingStudents(List<AttendingStudent> attendingStudents) {
        this.attendingStudents = attendingStudents;
    }
}
