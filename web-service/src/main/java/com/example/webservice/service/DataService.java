package com.example.webservice.service;

import com.example.webservice.dto.analysisData.AnalysisAuthorData;
import com.example.webservice.dto.analysisData.AnalysisAuthorDateData;
import com.example.webservice.dto.analysisData.AnalysisDateData;
import com.example.webservice.dto.inputData.MainData;
import org.springframework.http.HttpEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface DataService {

    HttpEntity<List<MainData>> getAllData();

    HttpEntity<List<MainData>> getDataByAuthor(String author);

    HttpEntity<AnalysisAuthorData> getAnalysedDataByAuthor(String author);

    HttpEntity<AnalysisDateData> getAnalysedDataByCreatingDate(String creatingDate);

    HttpEntity<AnalysisAuthorDateData> getAnalysedDataByAuthorAndCreatingDate(String author, String creatingDate);
}
