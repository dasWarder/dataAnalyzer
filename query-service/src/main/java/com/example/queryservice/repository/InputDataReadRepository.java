package com.example.queryservice.repository;

import com.example.queryservice.model.InputData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface InputDataReadRepository extends ElasticsearchRepository<InputData, String> {

    List<InputData> findAllByAuthor(String author);;
}
