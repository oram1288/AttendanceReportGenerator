package com.keyin.domain.registeredstudent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredStudentRepository extends CrudRepository<RegisteredStudent, Long> {
    public RegisteredStudent findByEmailAddress(String emailAddress);
}
