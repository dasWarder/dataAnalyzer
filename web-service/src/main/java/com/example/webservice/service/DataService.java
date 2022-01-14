package com.example.webservice.service;

import com.example.webservice.dto.analysisData.AnalysisAuthorData;
import com.example.webservice.dto.analysisData.AnalysisAuthorDateData;
import com.example.webservice.dto.analysisData.AnalysisDateData;
import org.springframework.http.HttpEntity;

import java.time.LocalDateTime;

public interface DataService {

//    HttpEntity<Page<MainData>> getAllData(Pageable pageable);
//
//    HttpEntity<Page<MainData>> getDataByAuthor(String author, Pageable pageable);
//
//    HttpEntity<Page<MainData>> getDataByDate(LocalDateTime date, Pageable pageable);

    HttpEntity<String> getDataByAuthor(String author);

    HttpEntity<AnalysisDateData> getDataByCreatingDate(LocalDateTime creatingDate);

    HttpEntity<AnalysisAuthorDateData> getDataByAuthorAndCreatingDate(String author, LocalDateTime creatingDate);
}
