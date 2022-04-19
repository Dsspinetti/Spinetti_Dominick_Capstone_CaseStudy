package com.example.spinetti_case_study.repositories;

import com.example.spinetti_case_study.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCourseById(Long courseId);

}
