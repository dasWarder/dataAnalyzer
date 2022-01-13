package com.example.analyticsservice.service.data;

import com.example.analyticsservice.exception.AnalysisDataNotFoundException;
import com.example.analyticsservice.model.AnalysisData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface AnalysisDataService {

    AnalysisData saveAnalysisData(AnalysisData data);

    AnalysisData getAnalysisDataById(Long id) throws AnalysisDataNotFoundException;

    AnalysisData getAnalysisDataByDataId(String dataId) throws AnalysisDataNotFoundException;

    void deleteAnalysisDataById(Long id);

    void deleteAnalysisDataByDataId(String dataId);

    Page<AnalysisData> getAllAnalysisData(Pageable pageable);

    Page<AnalysisData> getAllAnalysisDataByCreatingDate(LocalDateTime creatingDate, Pageable pageable);
}
