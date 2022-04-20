package com.example.spinetti_case_study.repositories;

import com.example.spinetti_case_study.models.ReportBug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportBugRepository extends JpaRepository<ReportBug, Long> {
    ReportBug findReportBugById(Long bugId);

    ReportBug findReportBugByTitle(String title);
}
