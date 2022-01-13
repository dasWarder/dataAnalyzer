package com.example.analyticsservice.service.data;

import com.example.analyticsservice.exception.AnalysisDataNotFoundException;
import com.example.analyticsservice.model.AnalysisData;
import com.example.analyticsservice.repository.AnalysisDataRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
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

  @Override
  @Transactional(readOnly = true)
  public AnalysisData getAnalysisDataById(Long id) throws AnalysisDataNotFoundException {

    log.info("In AnalysisDataServiceImpl.getAnalysisDataById - Get analysisData by id = {}", id);

    AnalysisData analysisData =
        dataRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new AnalysisDataNotFoundException(
                        String.format("AnalysisData object with id = %d not found", id)));
    return analysisData;
  }

  @Override
  @Transactional(readOnly = true)
  public AnalysisData getAnalysisDataByDataId(String dataId) throws AnalysisDataNotFoundException {

    log.info(
        "In AnalysisDataServiceImpl.getAnalysisDataByDataId - Get analysisData by dataId = {}",
        dataId);

    AnalysisData analysisData =
        dataRepository
            .getAnalysisDataByDataId(dataId)
            .orElseThrow(
                () ->
                    new AnalysisDataNotFoundException(
                        String.format("AnalysisData object with dataId = %s not found", dataId)));

    return analysisData;
  }

  @Override
  @Transactional
  public void deleteAnalysisDataById(Long id) {

    log.info(
        "In AnalysisDataServiceImpl.deleteAnalysisDataById - Remove analysisData by id = {}", id);

    dataRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void deleteAnalysisDataByDataId(String dataId) {

    log.info(
        "In AnalysisDataServiceImpl.deleteAnalysisDataByDataId - Remove analysisData by dataId = {}",
        dataId);

    dataRepository.deleteAnalysisDataByDataId(dataId);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<AnalysisData> getAllAnalysisData(LocalDateTime creatingDate, Pageable pageable) {

    if (Objects.isNull(creatingDate)) {

      log.info("In AnalysisDataServiceImpl.getAllAnalysisData - Get all analysisData");
      return dataRepository.findAll(pageable);
    }

    log.info(
        "In AnalysisDataServiceImpl.getAllAnalysisData - Get all analysisData by creating date = {}",
        creatingDate);

    return dataRepository.getAllByCreatingDate(creatingDate, pageable);
  }
}
