package com.example.analyticsservice.service;

import com.example.analyticsservice.dto.InputData;
import com.example.analyticsservice.exception.AnalysisDataNotFoundException;
import com.example.analyticsservice.mappingService.InputDataMapper;
import com.example.analyticsservice.model.AnalysisData;
import com.example.analyticsservice.service.data.AnalysisDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@EnableKafka
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

  private final ObjectMapper objectMapper;

  private final InputDataMapper inputDataMapper;

  private final AnalysisDataService dataService;

  @Override
  @KafkaListener(
      id = "#{'${kafka.keys.data}'}",
      topics = {"#{'${kafka.topics.data}'}"}, groupId = "#{'${kafka.groups.data}'}")
  public void produceMessage(String data) {

    InputData inputData = mapToObject(data);
    log.info("Input data info: {}", inputData.toString());
    AnalysisData analysisData = inputDataMapper.inputDataToAnalysisData(inputData);
    log.info("Analysis data info: {}", analysisData.toString());
    AnalysisData storedData = dataService.saveAnalysisData(analysisData);
  }

  private InputData mapToObject(String data) {
    try {
      return objectMapper.readValue(data, InputData.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException();
    }
  }
}
