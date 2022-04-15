package com.example.spinetti_case_study.services;


import com.example.spinetti_case_study.models.FAQ;
import com.example.spinetti_case_study.repositories.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FAQServiceImpl implements FAQService {

    @Autowired
    private FAQRepository faqRepository;

    public FAQServiceImpl(FAQRepository faqRepository) {
        this.faqRepository = faqRepository;
    }


    @Override
    public List<FAQ> getAllFAQs() {
        return faqRepository.findAll();
    }

    @Override
    public void saveQuestion(FAQ faq) {
        this.faqRepository.save(faq);
    }

    @Override
    public FAQ getQuestionById(long id) {
        FAQ faq = faqRepository.getById(id);
        if (faq == null) {
            throw new QuestionNotFoundException();
        }
        return faq;
    }

    @Override
    public void deleteQuestionById(long id) {
        this.faqRepository.deleteById(id);
    }
}
