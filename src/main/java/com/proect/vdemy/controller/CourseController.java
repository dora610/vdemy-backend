package com.proect.vdemy.controller;

import com.proect.vdemy.entities.Course;
import com.proect.vdemy.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable long courseId) throws Exception {
        return courseService.getCourse(courseId);
    }

    @PostMapping("/course")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/course/{courseId}")
    public ResponseEntity<String> updateCourse(@PathVariable long courseId, @RequestBody Course course) {
        return courseService.updateCourse(courseId, course);
    }

    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable long courseId) {
        try {
            return courseService.deleteCourse(courseId);
        } catch (Exception e) {
            return new ResponseEntity<>(String.format("Somthing went wrong\n %s", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
