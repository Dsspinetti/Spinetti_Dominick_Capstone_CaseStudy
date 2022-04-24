package com.example.spinetti_case_study.services;

import com.example.spinetti_case_study.models.Course;
import com.example.spinetti_case_study.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public Course getCourseById(long id) {
        Course course = courseRepository.getById(id);
        if (course == null) {
            throw new CourseNotFoundException();
        }
        return course;
    }

    public List<Course> listAll(String keyword) {
        if (keyword != null) {
            return courseRepository.searchByName(keyword);
        }
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourseById(long id) {
        this.courseRepository.deleteById(id);
    }
}

