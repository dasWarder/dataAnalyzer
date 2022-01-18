package com.example.webservice.service;

import com.example.webservice.dto.analysisData.AnalysisAuthorDateData;
import com.example.webservice.dto.analysisData.AnalysisDateData;
import com.example.webservice.dto.inputData.MainData;
import org.springframework.http.HttpEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface DataService {

    HttpEntity<List<MainData>> getAllData();
//
//    HttpEntity<Page<MainData>> getDataByAuthor(String author);

    HttpEntity<String> getDataByAuthor(String author);

    HttpEntity<AnalysisDateData> getDataByCreatingDate(LocalDateTime creatingDate);

    HttpEntity<AnalysisAuthorDateData> getDataByAuthorAndCreatingDate(String author, LocalDateTime creatingDate);
}
