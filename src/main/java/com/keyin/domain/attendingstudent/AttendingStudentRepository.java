package com.keyin.domain.attendingstudent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendingStudentRepository extends CrudRepository<AttendingStudent, Long> {
    public AttendingStudent findByEmailAddress(String emailAddress);
}
