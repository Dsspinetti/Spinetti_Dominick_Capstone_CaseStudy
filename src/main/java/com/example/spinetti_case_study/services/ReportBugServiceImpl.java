package com.example.spinetti_case_study.services;

import com.example.spinetti_case_study.models.ReportBug;
import com.example.spinetti_case_study.repositories.ReportBugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class ReportBugServiceImpl implements ReportBugService{

    @Autowired
    private ReportBugRepository reportBugRepository;


    public ReportBugServiceImpl(ReportBugRepository reportBugRepository){
        this.reportBugRepository = reportBugRepository;
    }

    @Override
    public List<ReportBug> getAllReports() {
        return reportBugRepository.findAll();
    }

    @Override
    public void saveReport(ReportBug reportBug) {
        this.reportBugRepository.save(reportBug);
    }

    @Override
    public ReportBug getReportById(long id) {
        ReportBug reportBug = reportBugRepository.getById(id);
        if (reportBug == null) {
            throw new ReportNotFoundException();
        }
        return reportBug;
    }

    @Override
    public void deleteReportById(long id) {
        this.reportBugRepository.deleteById(id);
    }
}
