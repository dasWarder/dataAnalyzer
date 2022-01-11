package com.example.webdataproducer.service;

import com.example.webdataproducer.dto.InputData;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface KafkaService {

    void produceMessage(InputData inputData) throws JsonProcessingException;
}
