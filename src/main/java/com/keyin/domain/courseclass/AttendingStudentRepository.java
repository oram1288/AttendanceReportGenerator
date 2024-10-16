package com.keyin.domain.courseclass;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendingStudentRepository extends CrudRepository<AttendingStudent, Long> {
}
