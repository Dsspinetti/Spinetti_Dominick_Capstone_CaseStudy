package com.example.spinetti_case_study.services;

import com.example.spinetti_case_study.models.ReportBug;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReportBugServiceImplTest {

    @Autowired
    private ReportBugService reportBugService;

    @Test
    void getAllReports() {
        List<ReportBug> allReports = reportBugService.getAllReports();
        int beforeAddingMoreReports = allReports.size();

        ReportBug reportBug = new ReportBug();
        reportBug.setTitle("Test");
        reportBug.setDescription("Test");
        reportBugService.saveReport(reportBug);
        int afterAddingMoreReports = reportBugService.getAllReports().size();

        Assertions.assertThat(afterAddingMoreReports).isEqualTo(beforeAddingMoreReports + 1);
        Assertions.assertThat(allReports.contains(reportBug));
    }

    @Test
    void saveReport() {
        ReportBug reportBug = new ReportBug();
        reportBug.setTitle("Test title");
        reportBug.setDescription("Test description");
        reportBugService.saveReport(reportBug);
        Assertions.assertThat(reportBugService.getAllReports()).contains(reportBug);
    }

    @Test
    void getReportById() {
        List<ReportBug> allReports = reportBugService.getAllReports();
        ReportBug reportBug = allReports.get(0);
        if (reportBug != null) {
            ReportBug reportBugById = reportBugService.getReportById(reportBug.getId());
            Assertions.assertThat(reportBugById).isEqualTo(reportBugById);
        }
    }

    @Test
    void deleteReportById() {
        List<ReportBug> allReports = reportBugService.getAllReports();
        ReportBug reportBug = allReports.get(0);
        if (reportBug != null) {
            reportBugService.deleteReportById(reportBug.getId());
            Assertions.assertThat(reportBugService.getAllReports()).doesNotContain(reportBug);
        }
    }
}