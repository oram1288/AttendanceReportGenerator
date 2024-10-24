package com.keyin.domain.courseclass;

import com.keyin.domain.course.RegisteredStudent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendingStudentRepository extends CrudRepository<AttendingStudent, Long> {
    public AttendingStudent findByEmailAddress(String emailAddress);
}
