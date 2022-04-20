package com.example.spinetti_case_study.controller;


import com.example.spinetti_case_study.models.Course;
import com.example.spinetti_case_study.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/showCourse")
    public String showCourse(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "course";
    }

    @GetMapping("/showNewCourseForm")
    public String showNewCourseForm(Model model) {

        Course course = new Course();
        model.addAttribute("course", course);
        return "new_course_form";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course")Course course) {
        courseService.saveCourse(course);
        return "redirect:/";
    }

}
