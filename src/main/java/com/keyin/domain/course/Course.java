package com.keyin.domain.course;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "course_sequence")
    private long id;

    private String courseName;
    private String year;
    private String semester;

    @ManyToMany
    private List<RegisteredStudent> registeredStudents;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public List<RegisteredStudent> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(List<RegisteredStudent> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }
}
