package com.example.queryservice.projection.dataProjector;

import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthor;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthorAndCreatingDate;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByCreatingDate;
import com.example.queryservice.dto.query.inputData.AllInputData;
import com.example.queryservice.dto.query.inputData.InputDataByAuthor;
import com.example.queryservice.dto.query.inputData.InputDataByDate;
import com.example.queryservice.mappingService.AnalysisDataQueryMapper;
import com.example.queryservice.mappingService.InputDataQueryMapper;
import com.example.queryservice.model.InputData;
import com.example.queryservice.projection.dataProjection.DataProjection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataProjectorImpl implements DataProjector {

  private final DataProjection dataProjection;

  private final InputDataQueryMapper inputDataQueryMapper;

  private final AnalysisDataQueryMapper analysisDataQueryMapper;

  @Override
  public Page<InputData> projectInputData(Pageable pageable) {

    log.info("In DataProjectorImpl.projectInputData - project to AllInputData query");

    AllInputData allInputData = inputDataQueryMapper.paramsToAllInputData(pageable);

    return dataProjection.handleInputData(allInputData);
  }

  @Override
  public Page<InputData> projectInputData(String author, Pageable pageable) {

    log.info("In DataProjectorImpl.projectInputData - project to InputDataByAuthor query");

    InputDataByAuthor inputDataByAuthor =
        inputDataQueryMapper.paramsToInputDataByAuthor(author, pageable);

    return dataProjection.handleInputData(inputDataByAuthor);
  }

  @Override
  public Page<InputData> projectInputData(LocalDateTime date, Pageable pageable) {

    log.info("In DataProjectorImpl.projectInputData - project to InputDataByDate query");

    InputDataByDate inputDataByDate = inputDataQueryMapper.paramsToInputDataByDate(date, pageable);

    return dataProjection.handleInputData(inputDataByDate);
  }

  @Override
  public Long projectAnalysisData(String author) {

    log.info(
        "In DataProjectorImpl.projectAnalysisData - project to AnalysisDataCountByAuthor query");

    AnalysisDataCountByAuthor analysisDataCountByAuthor =
        analysisDataQueryMapper.paramsToAnalysisDataCountByAuthor(author);

    return dataProjection.handleAnalysisData(analysisDataCountByAuthor);
  }

  @Override
  public Long projectAnalysisData(LocalDateTime creatingDate) {

    log.info(
        "In DataProjectorImpl.projectAnalysisData - project to AnalysisDataCountByCreatingDate query");

    AnalysisDataCountByCreatingDate analysisDataCountByCreatingDate =
        analysisDataQueryMapper.paramsToAnalysisDataCountByCreatingDate(creatingDate);

    return dataProjection.handleAnalysisData(analysisDataCountByCreatingDate);
  }

  @Override
  public Long projectAnalysisData(String author, LocalDateTime creatingDate) {

    log.info(
        "In DataProjectorImpl.projectAnalysisData - project to AnalysisDataCountByAuthor query");

    AnalysisDataCountByAuthorAndCreatingDate analysisDataCountByAuthorAndCreatingDate =
        analysisDataQueryMapper.paramsToAnalysisDataCountByAuthorAndCreatingDate(
            author, creatingDate);

    return dataProjection.handleAnalysisData(analysisDataCountByAuthorAndCreatingDate);
  }
}
