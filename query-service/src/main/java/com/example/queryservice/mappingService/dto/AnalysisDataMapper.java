package com.example.queryservice.mappingService.dto;

import com.example.queryservice.dto.read.analysisData.AnalysisAuthorData;
import com.example.queryservice.dto.read.analysisData.AnalysisAuthorDateData;
import com.example.queryservice.dto.read.analysisData.AnalysisDateData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper
public interface AnalysisDataMapper {

  @Mapping(target = "messagesCount", source = "count")
  AnalysisAuthorData toAnalysisAuthorData(String author, Long count);

  @Mapping(target = "messagesCount", source = "count")
  AnalysisDateData toAnalysisDateData(LocalDateTime creatingDate, Long count);

  @Mapping(target = "messagesCount", source = "count")
  AnalysisAuthorDateData toAnalysisAuthorDateData(
      String author, LocalDateTime creatingDate, Long count);
}
