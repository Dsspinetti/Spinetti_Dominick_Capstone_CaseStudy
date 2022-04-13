package com.example.spinetti_case_study.services;

import com.example.spinetti_case_study.models.ReportBug;

import java.util.List;

public interface ReportBugService {

    List<ReportBug> getAllReports();

    void saveReport(ReportBug reportBug);

    ReportBug getReportById(long id);

    void deleteReportById(long id);
}

