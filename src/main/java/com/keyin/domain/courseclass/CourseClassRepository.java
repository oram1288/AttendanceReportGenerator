package com.keyin.domain.courseclass;

import com.keyin.domain.course.RegisteredStudent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseClassRepository extends CrudRepository<CourseClass, Long> {
}
