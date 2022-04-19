package com.example.spinetti_case_study.services;

import com.example.spinetti_case_study.models.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    void saveCourse(Course course);

    Course getCourseById(long id);

    void deleteCourseById(long id);

}
