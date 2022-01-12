package com.example.elastickafkaservice.repository;

import com.example.elastickafkaservice.model.InputData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface InputDataRepository extends ElasticsearchRepository<InputData, String> {
}
