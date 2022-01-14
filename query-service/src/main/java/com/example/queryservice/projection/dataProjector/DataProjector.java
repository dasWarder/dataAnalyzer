package com.example.queryservice.projection.dataProjector;

import com.example.queryservice.model.InputData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface DataProjector {

  Page<InputData> projectInputData(Pageable pageable);

  Page<InputData> projectInputData(String author, Pageable pageable);

  Page<InputData> projectInputData(LocalDateTime date, Pageable pageable);

  Long projectAnalysisData(String author);

  Long projectAnalysisData(LocalDateTime creatingDate);

  Long projectAnalysisData(String author, LocalDateTime creatingDate);
}
