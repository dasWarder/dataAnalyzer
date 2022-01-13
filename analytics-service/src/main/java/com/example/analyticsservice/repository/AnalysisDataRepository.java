package com.example.analyticsservice.repository;

import com.example.analyticsservice.model.AnalysisData;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnalysisDataRepository extends PagingAndSortingRepository<AnalysisData, Long> {
}
