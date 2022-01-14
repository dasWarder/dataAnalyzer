package com.example.analyticsservice.service.data;

import com.example.analyticsservice.model.AnalysisData;
import com.example.analyticsservice.repository.AnalysisDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnalysisDataServiceImpl implements AnalysisDataService {

  private final AnalysisDataRepository dataRepository;

  @Override
  @Transactional
  public AnalysisData saveAnalysisData(AnalysisData data) {

    log.info(
        "In AnalysisDataServiceImpl.saveAnalysisData - Store new AnalysisData with dataId = {}",
        data.getDataId());

    return dataRepository.save(data);
  }

}
