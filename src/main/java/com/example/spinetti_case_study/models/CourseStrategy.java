package com.example.spinetti_case_study.models;


import javax.persistence.*;

@Entity
@Table(name = "course_strategy")
public class CourseStrategy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hole_photo")
    private String holePhoto;

    @Column(name = "hole_strategy")
    private String holeStrategy;

    public CourseStrategy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHolePhoto() {
        return holePhoto;
    }

    public void setHolePhoto(String holePhoto) {
        this.holePhoto = holePhoto;
    }

    public String getHoleStrategy() {
        return holeStrategy;
    }

    public void setHoleStrategy(String holeStrategy) {
        this.holeStrategy = holeStrategy;
    }
}
