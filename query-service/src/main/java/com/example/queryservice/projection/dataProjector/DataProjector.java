package com.example.queryservice.projection.dataProjector;

import com.example.queryservice.dto.read.analysisData.AnalysisAuthorData;
import com.example.queryservice.dto.read.analysisData.AnalysisAuthorDateData;
import com.example.queryservice.dto.read.analysisData.AnalysisDateData;
import com.example.queryservice.dto.read.inputData.MainData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface DataProjector {

  List<MainData> projectInputData();

  List<MainData> projectInputData(String author);

  AnalysisAuthorData projectAnalysisData(String author);

  AnalysisDateData projectAnalysisData(LocalDateTime creatingDate);

  AnalysisAuthorDateData projectAnalysisData(String author, LocalDateTime creatingDate);
}
