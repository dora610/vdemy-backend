package com.proect.vdemy.dao;

import com.proect.vdemy.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
    @Override
    boolean existsById(Long aLong);
}
