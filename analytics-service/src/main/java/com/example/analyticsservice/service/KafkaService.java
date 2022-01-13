package com.example.analyticsservice.service;

import com.example.analyticsservice.exception.AnalysisDataNotFoundException;

public interface KafkaService {

  void produceMessage(String data) throws AnalysisDataNotFoundException;
}
