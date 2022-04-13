package com.example.spinetti_case_study.models;


import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "REPORT_BUG")
public class ReportBug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "TITLE")
    private String title;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    public ReportBug() {
    }

    public int getId() {
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
