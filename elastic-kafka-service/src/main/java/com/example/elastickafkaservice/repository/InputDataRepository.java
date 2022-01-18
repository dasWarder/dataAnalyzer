package com.example.elastickafkaservice.repository;

import com.example.elastickafkaservice.model.InputDataDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface InputDataRepository extends ElasticsearchRepository<InputDataDto, String> {
}
