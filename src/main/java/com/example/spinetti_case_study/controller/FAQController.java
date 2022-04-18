package com.example.spinetti_case_study.controller;


import com.example.spinetti_case_study.models.FAQ;
import com.example.spinetti_case_study.services.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FAQController {

    @Autowired
    private FAQService faqService;

    public FAQController(FAQService faqService) {
        this.faqService = faqService;
    }

    //Mapping for FAQ page
    @GetMapping("/faq")
    public String showFAQ(Model model) {
        FAQ faq = new FAQ();
        model.addAttribute("faq", faq);
        model.addAttribute("listFaqs", faqService.getAllFAQs());
        return "faq";
    }

    //Mapping for new_faq page
    @GetMapping("/showNewFAQ")
    public String showNewFAQ(Model model) {
        FAQ faq = new FAQ();
        model.addAttribute("faq", faq);
        return "new_faq";
    }

//    @RequestMapping("/faq")
//    public String listQuestions(Model model) {
//        model.addAttribute("listFaqs", faqService.getAllFAQs());
//        return "faq";
//    }

    @PostMapping("/saveQuestion")
    public String saveQuestion(@ModelAttribute("faq") FAQ faq) {
        faqService.saveQuestion(faq);
        return "redirect:/faq";
    }
}
