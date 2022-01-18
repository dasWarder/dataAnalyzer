package com.example.webservice.controller;

import com.example.webservice.dto.analysisData.AnalysisAuthorData;
import com.example.webservice.dto.inputData.MainData;
import com.example.webservice.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/data")
public class DataController {

  private final DataService dataService;

  @GetMapping("/analysis/author")
  public ResponseEntity<AnalysisAuthorData> getDataByParam(@RequestParam("author") String author) {

    HttpEntity<AnalysisAuthorData> dataByAuthor = dataService.getAnalysedDataByAuthor(author);

    return (ResponseEntity<AnalysisAuthorData>) dataByAuthor;
  }

  @GetMapping("/raw")
  public ResponseEntity<List<MainData>> getAllData() {

    HttpEntity<List<MainData>> allData = dataService.getAllData();

    return (ResponseEntity<List<MainData>>) allData;
  }
}
