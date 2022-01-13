package com.example.elastickafkaservice.service.kafka;

import com.example.elastickafkaservice.exception.InputDataNotStoredException;
import com.example.elastickafkaservice.model.InputData;
import com.example.elastickafkaservice.service.inputData.InputDataService;
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
    @KafkaListener(id = "#{'${kafka.keys.data}'}", topics = {"#{'${kafka.topics.data}'}"}, groupId = "#{'${kafka.groups.data}'}")
    public void receiveMessage(String data) throws InputDataNotStoredException {

        InputData inputData = mapObject(data);
        InputData storedData = inputDataService.saveInputData(inputData);

        log.info("In KafkaServiceImpl.receiveMessage - InputData with id = {} stored", storedData.getId());
    }

    private InputData mapObject(String data) {
        try {
            return objectMapper.readValue(data, InputData.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }
}
