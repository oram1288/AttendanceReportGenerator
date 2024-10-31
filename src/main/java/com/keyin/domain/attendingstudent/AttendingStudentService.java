package com.keyin.domain.attendingstudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendingStudentService {
    @Autowired
    private AttendingStudentRepository attendingStudentRepository;

    public AttendingStudent findByEmailAddress(String emailAddress) {
        return attendingStudentRepository.findByEmailAddress(emailAddress);
    }

    public AttendingStudent createAttendingStudent(AttendingStudent student) {
        return attendingStudentRepository.save(student);
    }
}
