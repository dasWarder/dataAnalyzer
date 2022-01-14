package com.example.queryservice.mappingService.dto;

import com.example.queryservice.dto.read.inputData.MainData;
import com.example.queryservice.model.InputData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface InputDataMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "dataId", ignore = true)
  @Mapping(target = "processingDate", ignore = true)
  MainData inputDataToMainData(InputData inputData);
}
