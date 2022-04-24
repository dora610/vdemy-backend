package com.proect.vdemy.services;

import com.proect.vdemy.entities.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {

    public ResponseEntity<List<Course>> getAllCourses();

    public ResponseEntity<Course> getCourse(Long courseId) throws Exception;

    public ResponseEntity<String> addCourse(Course course);

    public ResponseEntity<String> updateCourse(Long courseId, Course course);

    public ResponseEntity<String> deleteCourse(Long courseId);

}
