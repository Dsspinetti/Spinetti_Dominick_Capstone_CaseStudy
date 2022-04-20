package com.example.spinetti_case_study.services;

import com.example.spinetti_case_study.models.Course;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;

    @Test
    void getAllCourses() {

        List<Course> allCourses = courseService.getAllCourses();
        int beforeAddingMoreCourses = allCourses.size();

        Course course = new Course();
        course.setCourseName("Test Course");
        course.setCourseDescription("Test Description");
        courseService.saveCourse(course);
        int afterAddingMoreCourses = courseService.getAllCourses().size();

        Assertions.assertThat(afterAddingMoreCourses).isEqualTo(beforeAddingMoreCourses + 1);
        Assertions.assertThat(allCourses.contains(course));
    }

    @Test
    void saveCourse() {
        Course course = new Course();
        course.setCourseName("Test Course");
        course.setCourseDescription("Test Description");
        courseService.saveCourse(course);
        Assertions.assertThat(courseService.getAllCourses().contains(course));
    }

    @Test
    void getCourseById() {
        List<Course> allCourses = courseService.getAllCourses();
        Course course = allCourses.get(0);
        if (course != null) {
            Course courseById = courseService.getCourseById(course.getId());
            Assertions.assertThat(courseById).isEqualTo(courseById);
        }
    }

    @Test
    void deleteCourseById() {
        List<Course> allCourses = courseService.getAllCourses();
        Course course = allCourses.get(0);
        if (course != null) {
            courseService.deleteCourseById(course.getId());
            Assertions.assertThat(courseService.getAllCourses().contains(course)).isEqualTo(false);
        }
    }
}