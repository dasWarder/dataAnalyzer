package com.example.queryservice.projection.dataProjection;

import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthor;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByAuthorAndCreatingDate;
import com.example.queryservice.dto.query.analysisData.AnalysisDataCountByCreatingDate;
import com.example.queryservice.dto.query.inputData.AllInputData;
import com.example.queryservice.dto.query.inputData.InputDataByAuthor;
import com.example.queryservice.model.InputData;

import java.util.List;

public interface DataProjection {

  List<InputData> handleInputData(AllInputData query);

  List<InputData> handleInputData(InputDataByAuthor query);

  Long handleAnalysisData(AnalysisDataCountByAuthor query);

  Long handleAnalysisData(AnalysisDataCountByCreatingDate query);

  Long handleAnalysisData(AnalysisDataCountByAuthorAndCreatingDate query);
}
