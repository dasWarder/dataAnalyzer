package com.example.queryservice.projection;

import com.example.queryservice.dto.query.*;
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
