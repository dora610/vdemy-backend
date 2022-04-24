package com.proect.vdemy.services;

import com.proect.vdemy.dao.CourseDao;
import com.proect.vdemy.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseDao.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Course> getCourse(Long courseId) throws Exception {
        Optional<Course> course = courseDao.findById(courseId);
        if (course.isPresent()) {
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        } else {
            throw new Exception("No such couse found");
        }
    }

    @Override
    public ResponseEntity<String> addCourse(Course course) {
        Course c = courseDao.save(course);
        return new ResponseEntity<>(String.format("Successfully added course with courseId: %s", c.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateCourse(Long courseId, Course course) {
        boolean isCourseExists = courseDao.existsById(courseId);
        if (!isCourseExists) {
            return new ResponseEntity<>("No such course found", HttpStatus.NOT_FOUND);
        }
        courseDao.save(course);
        return new ResponseEntity<>("Successfully updated course", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCourse(Long courseId) {
        if (!courseDao.existsById(courseId)) return new ResponseEntity<>("No such course found", HttpStatus.NOT_FOUND);

        courseDao.deleteById(courseId);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
