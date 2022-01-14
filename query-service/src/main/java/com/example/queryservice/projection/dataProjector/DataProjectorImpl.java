package com.example.queryservice.projection.dataProjector;

import com.example.queryservice.dto.read.analysisData.AnalysisAuthorData;
import com.example.queryservice.dto.read.analysisData.AnalysisAuthorDateData;
import com.example.queryservice.dto.read.analysisData.AnalysisDateData;
import com.example.queryservice.dto.read.inputData.MainData;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthor;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthorAndCreatingDate;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByCreatingDate;
import com.example.queryservice.dto.query.inputData.AllInputData;
import com.example.queryservice.dto.query.inputData.InputDataByAuthor;
import com.example.queryservice.dto.query.inputData.InputDataByDate;
import com.example.queryservice.mappingService.dto.AnalysisDataMapper;
import com.example.queryservice.mappingService.dto.InputDataMapper;
import com.example.queryservice.mappingService.query.AnalysisDataQueryMapper;
import com.example.queryservice.mappingService.query.InputDataQueryMapper;
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

  private final InputDataMapper inputDataMapper;

  private final AnalysisDataMapper analysisDataMapper;

  private final InputDataQueryMapper inputDataQueryMapper;

  private final AnalysisDataQueryMapper analysisDataQueryMapper;

  @Override
  public Page<MainData> projectInputData(Pageable pageable) {

    log.info("In DataProjectorImpl.projectInputData - project to AllInputData query");

    AllInputData allInputData = inputDataQueryMapper.paramsToAllInputData(pageable);

    return dataProjection.handleInputData(allInputData).map(inputDataMapper::inputDataToMainData);
  }

  @Override
  public Page<MainData> projectInputData(String author, Pageable pageable) {

    log.info("In DataProjectorImpl.projectInputData - project to InputDataByAuthor query");

    InputDataByAuthor inputDataByAuthor =
        inputDataQueryMapper.paramsToInputDataByAuthor(author, pageable);

    return dataProjection
        .handleInputData(inputDataByAuthor)
        .map(inputDataMapper::inputDataToMainData);
  }

  @Override
  public Page<MainData> projectInputData(LocalDateTime date, Pageable pageable) {

    log.info("In DataProjectorImpl.projectInputData - project to InputDataByDate query");

    InputDataByDate inputDataByDate = inputDataQueryMapper.paramsToInputDataByDate(date, pageable);

    return dataProjection
        .handleInputData(inputDataByDate)
        .map(inputDataMapper::inputDataToMainData);
  }

  @Override
  public AnalysisAuthorData projectAnalysisData(String author) {

    log.info(
        "In DataProjectorImpl.projectAnalysisData - project to AnalysisDataCountByAuthor query");

    AnalysisDataCountByAuthor analysisDataCountByAuthor =
        analysisDataQueryMapper.paramsToAnalysisDataCountByAuthor(author);
    Long count = dataProjection.handleAnalysisData(analysisDataCountByAuthor);

    return analysisDataMapper.toAnalysisAuthorData(author, count);
  }

  @Override
  public AnalysisDateData projectAnalysisData(LocalDateTime creatingDate) {

    log.info(
        "In DataProjectorImpl.projectAnalysisData - project to AnalysisDataCountByCreatingDate query");

    AnalysisDataCountByCreatingDate analysisDataCountByCreatingDate =
        analysisDataQueryMapper.paramsToAnalysisDataCountByCreatingDate(creatingDate);
    Long count = dataProjection.handleAnalysisData(analysisDataCountByCreatingDate);

    return analysisDataMapper.toAnalysisDateData(creatingDate, count);
  }

  @Override
  public AnalysisAuthorDateData projectAnalysisData(String author, LocalDateTime creatingDate) {

    log.info(
        "In DataProjectorImpl.projectAnalysisData - project to AnalysisDataCountByAuthor query");

    AnalysisDataCountByAuthorAndCreatingDate analysisDataCountByAuthorAndCreatingDate =
        analysisDataQueryMapper.paramsToAnalysisDataCountByAuthorAndCreatingDate(
            author, creatingDate);
    Long count = dataProjection.handleAnalysisData(analysisDataCountByAuthorAndCreatingDate);

    return analysisDataMapper.toAnalysisAuthorDateData(author, creatingDate, count);
  }
}
