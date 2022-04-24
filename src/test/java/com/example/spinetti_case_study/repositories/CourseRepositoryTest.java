package com.example.spinetti_case_study.repositories;

import com.example.spinetti_case_study.models.Course;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void findCourseById_should_return_course_given_valid_id() {

        Course course = courseRepository.findCourseById(1L);
        Assertions.assertThat(course).isNotNull();
    }

    @Test
    void searchByName_should_return_course_given_valid_keyword() {
        //TODO: implement test for searchByName

    }
}