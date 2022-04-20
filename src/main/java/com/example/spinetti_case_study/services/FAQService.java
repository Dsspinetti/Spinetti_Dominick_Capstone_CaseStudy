package com.example.spinetti_case_study.services;

import com.example.spinetti_case_study.models.FAQ;

import java.util.List;

public interface FAQService {

    List<FAQ> getAllFAQs();

    void saveQuestion(FAQ faq);

    FAQ getQuestionById(long id);

    void deleteQuestionById(long id);

    FAQ getQuestionByTitle(String title);
}
