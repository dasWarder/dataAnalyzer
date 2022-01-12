package com.example.elastickafkaservice.service;

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

    @Override
    @KafkaListener(id = "#{'${kafka.keys.data}'}" , topics = { "#{'${kafka.topics.data}'}" })
    public void receiveMessage(String data) {
        log.info("Received: {}", data);
    }
}
