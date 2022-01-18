package com.example.elastickafkaservice.util;

import com.example.elastickafkaservice.dto.InputData;
import com.example.elastickafkaservice.model.InputDataDto;

public class MappingUtility {

  public static final InputDataDto toInputData(InputData inputData) {

    return InputDataDto.builder()
        .id(inputData.getId())
        .author(inputData.getAuthor())
        .message(inputData.getMessage())
        .build();
  }
}
