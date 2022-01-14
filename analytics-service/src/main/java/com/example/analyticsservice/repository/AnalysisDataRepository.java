package com.example.analyticsservice.repository;

import com.example.analyticsservice.model.AnalysisData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisDataRepository extends JpaRepository<AnalysisData, Long> {
}
