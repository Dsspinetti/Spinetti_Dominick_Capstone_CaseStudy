package com.example.spinetti_case_study.repositories;

import com.example.spinetti_case_study.models.ReportBug;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReportBugRepositoryTest {

    @Autowired
    private ReportBugRepository reportBugRepository;

    @Test
    void findReportBugByTitle_should_return_Bug_given_valid_title() {
        ReportBug reportBug = reportBugRepository.findReportBugByTitle("found a bug in _____");
        Assertions.assertThat(reportBug.getTitle()).isEqualTo("found a bug in _____");
    }
}