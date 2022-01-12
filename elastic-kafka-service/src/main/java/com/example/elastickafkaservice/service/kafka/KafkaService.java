package com.example.elastickafkaservice.service.kafka;

import com.example.elastickafkaservice.exception.InputDataNotStoredException;

public interface KafkaService {

    void receiveMessage(String data) throws InputDataNotStoredException;
}
