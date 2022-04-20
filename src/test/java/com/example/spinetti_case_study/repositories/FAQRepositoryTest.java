package com.example.spinetti_case_study.repositories;

import com.example.spinetti_case_study.models.FAQ;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FAQRepositoryTest {

    @Autowired
    private FAQRepository faqRepository;

    @Test
    void findQuestionByTitle_should_return_FAQ_with_given_question() {
        FAQ faq = faqRepository.findQuestionByTitle("How do I add a new FAQ?");
        Assertions.assertThat(faq.getTitle()).isEqualTo("How do I add a new FAQ?");
    }

}