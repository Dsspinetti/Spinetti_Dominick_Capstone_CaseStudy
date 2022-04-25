package com.example.spinetti_case_study.repositories;

import com.example.spinetti_case_study.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCourseById(Long courseId);

    //add search query for courses by name
    @Query(value = "SELECT * FROM course c WHERE c.course_name LIKE %?1%", nativeQuery = true)
    //make return value a list
    public List<Course> searchByName(String name);
}
