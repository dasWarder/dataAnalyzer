package com.example.queryservice.repository;

import com.example.queryservice.model.InputData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDateTime;

public interface InputDataReadRepository extends ElasticsearchRepository<InputData, String> {

    @Override
    Page<InputData> findAll(Pageable pageable);

    Page<InputData> findAllByAuthor(String author, Pageable pageable);

    Page<InputData> findAllByDate(LocalDateTime dateTime, Pageable pageable);

    Page<InputData> findAllByDateGreaterThanEqual(LocalDateTime dateTime, Pageable pageable);
}
