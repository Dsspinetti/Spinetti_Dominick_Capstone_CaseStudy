package com.example.spinetti_case_study.controller;


import com.example.spinetti_case_study.models.Course;
import com.example.spinetti_case_study.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

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

    @GetMapping("/showFileUploadForm")
    public String showFileUploadForm() {
        return "file_upload_form";
    }

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file")MultipartFile file) {
        String fileName = file.getOriginalFilename();

        try {
            file.transferTo(new File("C:\\Users\\Dominick\\Spinetti_Dominick_Case_Study\\src\\main\\resources\\static\\img\\" + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("File uploaded successfully.");
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable(value = "id") long id) {
        this.courseService.deleteCourseById(id);
        return "redirect:/";
    }


}
