package com.example.analyticsservice.mappingService;

import com.example.analyticsservice.dto.InputData;
import com.example.analyticsservice.model.AnalysisData;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDateTime;

@Mapper
public interface InputDataMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "dataId", source = "id")
  @Mapping(target = "creatingDate", source = "date")
  AnalysisData inputDataToAnalysisData(InputData inputData);

  @AfterMapping
  default void setProcessingDate(@MappingTarget AnalysisData.AnalysisDataBuilder dataBuilder) {
    dataBuilder.processingDate(LocalDateTime.now());
  }
}
