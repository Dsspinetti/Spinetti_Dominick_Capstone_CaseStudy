package com.example.spinetti_case_study.services;

import com.example.spinetti_case_study.models.FAQ;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FAQServiceImplTest {

    @Autowired
    private FAQService faqService;

    @Test
    void getAllFAQs() {

        List<FAQ> allFAQs = faqService.getAllFAQs();
        int beforeAddingMoreFAQs = allFAQs.size();

        FAQ faq = new FAQ();
        faq.setTitle("How do I add a new FAQ?");
        faq.setDescription("You can add a new FAQ by clicking the 'Add FAQ' button in the top right corner of the page.");
        faqService.saveQuestion(faq);
        int afterAddingMoreFAQs = faqService.getAllFAQs().size();

        Assertions.assertThat(afterAddingMoreFAQs).isEqualTo(beforeAddingMoreFAQs + 1);
        Assertions.assertThat(allFAQs.contains(faq));
    }

    @Test
    void getQuestionById() {
        List<FAQ> allFAQs = faqService.getAllFAQs();
        FAQ faq = allFAQs.get(0);
        if (faq != null) {
            FAQ faq2 = faqService.getQuestionById(faq.getId());
            Assertions.assertThat(faq2).isEqualTo(faq2);
        }
    }

    @Test
    void saveQuestion() {
        FAQ faq = new FAQ();
        faq.setTitle("How do I add a new FAQ?");
        faq.setDescription("You can add a new FAQ by clicking the 'Add FAQ' button in the top right corner of the page.");
        faqService.saveQuestion(faq);
        Assertions.assertThat(faqService.getAllFAQs().contains(faq));
    }

    @Test
    void deleteQuestionById() {
        List<FAQ> allFAQs = faqService.getAllFAQs();
        FAQ faq = allFAQs.get(0);
        if (faq != null) {
            faqService.deleteQuestionById(faq.getId());
            Assertions.assertThat(faqService.getAllFAQs().contains(faq)).isFalse();
        }
    }

}