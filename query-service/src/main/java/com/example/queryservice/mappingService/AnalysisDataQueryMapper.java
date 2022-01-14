package com.example.queryservice.mappingService;

import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthor;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthorAndCreatingDate;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByCreatingDate;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface AnalysisDataQueryMapper {

  AnalysisDataCountByAuthor paramsToAnalysisDataCountByAuthor(String author);

  AnalysisDataCountByCreatingDate paramsToAnalysisDataCountByCreatingDate(
      LocalDateTime creatingDate);

  AnalysisDataCountByAuthorAndCreatingDate paramsToAnalysisDataCountByAuthorAndCreatingDate(
      String author, LocalDateTime creatingDate);
}
