package com.example.spinetti_case_study.controller;

import com.example.spinetti_case_study.models.ReportBug;
import com.example.spinetti_case_study.services.ReportBugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ReportBugController {

    @Autowired
    private ReportBugService reportBugService;

//    public ReportBugController() {
//    }


    public ReportBugController(ReportBugService reportBugService) {
        this.reportBugService = reportBugService;
    }

    @GetMapping("/reportBug")
    public String showReportBug(Model model) {
        ReportBug reportBug = new ReportBug();
        model.addAttribute("reportBug", reportBug);
        return "report_bug";
    }


    //mapping for saving a bug report
    @PostMapping("/saveBugReport")
    public String saveBugReport(@ModelAttribute("reportBug") ReportBug reportBug) {

        reportBugService.saveReport(reportBug);
        return "redirect:/reportBug";
    }

}
