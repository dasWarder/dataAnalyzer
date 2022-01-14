package com.example.queryservice.projection.dataProjection;

import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthor;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthorAndCreatingDate;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByCreatingDate;
import com.example.queryservice.dto.query.inputData.AllInputData;
import com.example.queryservice.dto.query.inputData.InputDataByAuthor;
import com.example.queryservice.dto.query.inputData.InputDataByDate;
import com.example.queryservice.model.InputData;
import org.springframework.data.domain.Page;

public interface DataProjection {

  Page<InputData> handleInputData(AllInputData query);

  Page<InputData> handleInputData(InputDataByAuthor query);

  Page<InputData> handleInputData(InputDataByDate query);

  Long handleAnalysisData(AnalysisDataCountByAuthor query);

  Long handleAnalysisData(AnalysisDataCountByCreatingDate query);

  Long handleAnalysisData(AnalysisDataCountByAuthorAndCreatingDate query);
}
