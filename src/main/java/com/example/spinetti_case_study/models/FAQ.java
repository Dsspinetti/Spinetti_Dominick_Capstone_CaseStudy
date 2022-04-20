package com.example.spinetti_case_study.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "FAQ")
public class FAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "QUESTION_TITLE")
    private String title;

    @NotNull
    @Column(name = "QUESTION_DESCRIPTION")
    private String description;

    public FAQ() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
