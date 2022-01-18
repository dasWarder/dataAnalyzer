package com.example.elastickafkaservice.service.kafka;

import com.example.elastickafkaservice.dto.InputData;
import com.example.elastickafkaservice.exception.InputDataNotStoredException;
import com.example.elastickafkaservice.model.InputDataDto;
import com.example.elastickafkaservice.service.inputData.InputDataService;
import com.example.elastickafkaservice.util.MappingUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableKafka
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

  private final ObjectMapper objectMapper;

  private final InputDataService inputDataService;

  @Override
  @KafkaListener(
      id = "#{'${kafka.keys.data}'}",
      topics = {"#{'${kafka.topics.data}'}"},
      groupId = "#{'${kafka.groups.data}'}")
  public void receiveMessage(String data) throws InputDataNotStoredException {

    InputDataDto inputDataDto = mapObject(data);
    InputDataDto storedData = inputDataService.saveInputData(inputDataDto);

    log.info(
        "In KafkaServiceImpl.receiveMessage - InputData with id = {} stored", storedData.getId());
  }

  private InputDataDto mapObject(String data) {

    InputData inputData = null;
    try {
      inputData = objectMapper.readValue(data, InputData.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e.getMessage());
    }
    return MappingUtility.toInputData(inputData);
  }
}
