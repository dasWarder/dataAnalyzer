package com.example.analyticsservice.repository;

import com.example.analyticsservice.model.AnalysisData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AnalysisDataRepository extends PagingAndSortingRepository<AnalysisData, Long> {

  Optional<AnalysisData> getAnalysisDataByDataId(String dataId);

  void deleteAnalysisDataByDataId(String id);

  @Override
  Page<AnalysisData> findAll(Pageable pageable);

  Page<AnalysisData> getAllByCreatingDate(LocalDateTime date, Pageable pageable);
}
