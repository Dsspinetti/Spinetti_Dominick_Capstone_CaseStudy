package com.example.spinetti_case_study.repositories;


import com.example.spinetti_case_study.models.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long> {
    FAQ findFAQById(Long FAQId);

    FAQ findQuestionByTitle(String title);
}
