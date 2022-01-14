package com.example.queryservice.projection.dataProjection;

import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthor;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthorAndCreatingDate;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByCreatingDate;
import com.example.queryservice.dto.query.inputData.AllInputData;
import com.example.queryservice.dto.query.inputData.InputDataByAuthor;
import com.example.queryservice.dto.query.inputData.InputDataByDate;
import com.example.queryservice.model.InputData;
import com.example.queryservice.repository.AnalysisDataReadRepository;
import com.example.queryservice.repository.InputDataReadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataProjectionImpl implements DataProjection {

  private final InputDataReadRepository inputDataRepository;

  private final AnalysisDataReadRepository analysisDataRepository;

  @Override
  @Transactional(readOnly = true)
  public Page<InputData> handleInputData(AllInputData query) {

    log.info("In DataProjectionImpl. handleInputData - Handle data by allInputData query");

    return inputDataRepository.findAll(query.getPageable());
  }

  @Override
  @Transactional(readOnly = true)
  public Page<InputData> handleInputData(InputDataByAuthor query) {

    log.info("In DataProjectionImpl.handleInputData - Handle data by InputDataByAuthor query");

    return inputDataRepository.findAllByAuthor(query.getAuthor(), query.getPageable());
  }

  @Override
  @Transactional(readOnly = true)
  public Page<InputData> handleInputData(InputDataByDate query) {

    log.info("In DataProjectionImpl.handleInputData - Handle data by InputDataByDate query");

    return inputDataRepository.findAllByDate(query.getDateTime(), query.getPageable());
  }

  @Override
  @Transactional(readOnly = true)
  public Long handleAnalysisData(AnalysisDataCountByAuthor query) {

    log.info(
        "In DataProjectionImpl.handleAnalysisData - Handle data by AnalysisDataCountByAuthor query");

    return analysisDataRepository.countAllByAuthor(query.getAuthor());
  }

  @Override
  @Transactional(readOnly = true)
  public Long handleAnalysisData(AnalysisDataCountByCreatingDate query) {

    log.info(
        "In DataProjectionImpl.handleAnalysisData - Handle data by AnalysisDataCountByCreatingDate query");

    return analysisDataRepository.countAllByCreatingDate(query.getCreatingDate());
  }

  @Override
  @Transactional(readOnly = true)
  public Long handleAnalysisData(AnalysisDataCountByAuthorAndCreatingDate query) {

    log.info(
        "In DataProjectionImpl.handleAnalysisData - Handle data by AnalysisDataCountByAuthorAndCreatingDate query");

    return analysisDataRepository.countAllByAuthorAndCreatingDate(
        query.getAuthor(), query.getCreatingDate());
  }
}
