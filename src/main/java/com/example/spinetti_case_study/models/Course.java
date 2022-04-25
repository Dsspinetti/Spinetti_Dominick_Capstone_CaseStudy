package com.example.spinetti_case_study.models;


import com.example.spinetti_case_study.security.Role;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "course_name")
    private String courseName;

    @Size(min = 2, max = 1000000)
    @Column(name = "course_description")
    private String courseDescription;

    @Size(min = 2, max = 1000000)
    @Column(name = "course_image")
    private String courseImage;

    @Column(name = "hole1_strategy")
    private String hole1Strategy;

    @Column(name = "hole2_strategy")
    private String hole2Strategy;

    @Column(name = "hole3_strategy")
    private String hole3Strategy;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_list",
            joinColumns = @JoinColumn(
                    name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "strategy_id", referencedColumnName = "id"))
    private Collection<CourseStrategy> courseStrategies;

    public Course() {
    }

    public String getHole2Strategy() {
        return hole2Strategy;
    }

    public void setHole2Strategy(String hole2Strategy) {
        this.hole2Strategy = hole2Strategy;
    }

    public String getHole3Strategy() {
        return hole3Strategy;
    }

    public void setHole3Strategy(String hole3Strategy) {
        this.hole3Strategy = hole3Strategy;
    }

    public String getHole1Strategy() {
        return hole1Strategy;
    }

    public void setHole1Strategy(String hole1Strategy) {
        this.hole1Strategy = hole1Strategy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }
}
