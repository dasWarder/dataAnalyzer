package com.example.queryservice.repository;

import com.example.queryservice.model.AnalysisData;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface AnalysisDataReadRepository extends CrudRepository<AnalysisData, Long> {

    long countAllByAuthor(String author);

    long countAllByCreatingDate(LocalDateTime creatingDate);

    long countAllByAuthorAndCreatingDate(String author, LocalDateTime creatingDate);
}
