package com.example.queryservice.mappingService.dto;

import com.example.queryservice.dto.read.inputData.MainData;
import com.example.queryservice.model.InputData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface InputDataMapper {

  MainData inputDataToMainData(InputData inputData);
}
