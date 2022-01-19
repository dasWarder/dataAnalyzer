package com.example.queryservice.repository;

import com.example.queryservice.model.InputData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.List;

@EnableElasticsearchRepositories
public interface InputDataReadRepository extends ElasticsearchRepository<InputData, String> {

    List<InputData> findByAuthor(String author);
}
