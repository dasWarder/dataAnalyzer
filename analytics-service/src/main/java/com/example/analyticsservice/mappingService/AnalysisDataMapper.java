package com.example.analyticsservice.mappingService;

import com.example.analyticsservice.dto.AnalysisDataResponse;
import com.example.analyticsservice.model.AnalysisData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AnalysisDataMapper {

  @Mapping(target = "creatingDate", ignore = true)
  AnalysisDataResponse analysisDataToAnalysisDataResponse(AnalysisData analysisData);
}
