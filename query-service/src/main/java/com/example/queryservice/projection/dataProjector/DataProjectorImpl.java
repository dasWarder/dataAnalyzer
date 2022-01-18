package com.example.queryservice.projection.dataProjector;

import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthor;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthorAndCreatingDate;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByCreatingDate;
import com.example.queryservice.dto.query.inputData.AllInputData;
import com.example.queryservice.dto.query.inputData.InputDataByAuthor;
import com.example.queryservice.dto.read.analysisData.AnalysisAuthorData;
import com.example.queryservice.dto.read.analysisData.AnalysisAuthorDateData;
import com.example.queryservice.dto.read.analysisData.AnalysisDateData;
import com.example.queryservice.dto.read.inputData.MainData;
import com.example.queryservice.mappingService.dto.AnalysisDataMapper;
import com.example.queryservice.mappingService.dto.InputDataMapper;
import com.example.queryservice.mappingService.query.AnalysisDataQueryMapper;
import com.example.queryservice.mappingService.query.InputDataQueryMapper;
import com.example.queryservice.projection.dataProjection.DataProjection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
  public List<MainData> projectInputData() {

    log.info("In DataProjectorImpl.projectInputData - project to AllInputData query");

     return dataProjection.handleInputData(new AllInputData()).stream()
        .map(inputDataMapper::inputDataToMainData)
        .collect(Collectors.toList());
  }

  @Override
  public List<MainData> projectInputData(String author) {

    log.info("In DataProjectorImpl.projectInputData - project to InputDataByAuthor query");

    InputDataByAuthor inputDataByAuthor = inputDataQueryMapper.paramsToInputDataByAuthor(author);

    return dataProjection.handleInputData(inputDataByAuthor).stream()
        .map(inputDataMapper::inputDataToMainData)
        .collect(Collectors.toList());
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
