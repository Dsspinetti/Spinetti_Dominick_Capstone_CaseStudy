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
    void findCourseById_should_return_Course_given_valid_id() {
        //Test should fail for now as the database is empty
        Course course = courseRepository.findCourseById(1L);
        Assertions.assertThat(course).isNotNull();
    }

}