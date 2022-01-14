package com.example.queryservice.projection.dataProjector;

import com.example.queryservice.dto.read.analysisData.AnalysisAuthorData;
import com.example.queryservice.dto.read.analysisData.AnalysisAuthorDateData;
import com.example.queryservice.dto.read.analysisData.AnalysisDateData;
import com.example.queryservice.dto.read.inputData.MainData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface DataProjector {

  Page<MainData> projectInputData(Pageable pageable);

  Page<MainData> projectInputData(String author, Pageable pageable);

  Page<MainData> projectInputData(LocalDateTime date, Pageable pageable);

  AnalysisAuthorData projectAnalysisData(String author);

  AnalysisDateData projectAnalysisData(LocalDateTime creatingDate);

  AnalysisAuthorDateData projectAnalysisData(String author, LocalDateTime creatingDate);
}
