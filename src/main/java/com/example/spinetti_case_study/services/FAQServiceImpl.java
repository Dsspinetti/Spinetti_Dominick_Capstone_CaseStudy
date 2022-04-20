package com.example.spinetti_case_study.services;


import com.example.spinetti_case_study.models.FAQ;
import com.example.spinetti_case_study.repositories.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<FAQ> optionalFAQ = faqRepository.findById(id);
        if (optionalFAQ.isPresent()) {
            FAQ faq = optionalFAQ.get();
            return faq;
        }
        throw new QuestionNotFoundException();

    }
    @Override
    public FAQ getQuestionByTitle(String title) {
        FAQ faq = faqRepository.findQuestionByTitle(title);
        if (faq != null) {
            return faq;
        }
        throw new QuestionNotFoundException();

    }

    @Override
    public void deleteQuestionById(long id) {
        this.faqRepository.deleteById(id);
    }
}
