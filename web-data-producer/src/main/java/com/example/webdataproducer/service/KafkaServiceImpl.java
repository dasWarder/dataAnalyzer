package com.example.webdataproducer.service;

import com.example.webdataproducer.dto.InputData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableKafka
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

    @Value("${kafka.keys.data}")
    private String key;

    @Value("${kafka.topics.data}")
    private String topicName;

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void produceMessage(InputData inputData) throws JsonProcessingException {

        String serializeData = objectMapper.writeValueAsString(inputData);
        kafkaTemplate.send(topicName, key, serializeData);
    }
}
