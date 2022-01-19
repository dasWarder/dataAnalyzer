package com.example.webservice.controller;

import com.example.webservice.dto.analysisData.AnalysisAuthorData;
import com.example.webservice.dto.analysisData.AnalysisAuthorDateData;
import com.example.webservice.dto.analysisData.AnalysisDateData;
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
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/data")
public class DataController {

  private final DataService dataService;

  @GetMapping("/analysis")
  public ResponseEntity<?> getDataByParam(
      @RequestParam(value = "author", required = false) String author,
      @RequestParam(value = "creatingDate", required = false) String creatingDate) {

    if (Objects.nonNull(author) && Objects.isNull(creatingDate)) {
      return (ResponseEntity<AnalysisAuthorData>) dataService.getAnalysedDataByAuthor(author);
    }

    if (Objects.nonNull(creatingDate) && Objects.isNull(author)) {
      return (ResponseEntity<AnalysisDateData>)
          dataService.getAnalysedDataByCreatingDate(creatingDate);
    }

    return (ResponseEntity<AnalysisAuthorDateData>)
        dataService.getAnalysedDataByAuthorAndCreatingDate(author, creatingDate);
  }

  @GetMapping("/raw")
  public ResponseEntity<List<MainData>> getAllData(@RequestParam(value = "author", required = false) String author) {

    if(Objects.nonNull(author)) {
      return (ResponseEntity<List<MainData>>) dataService.getDataByAuthor(author);
    }

    return (ResponseEntity<List<MainData>>) dataService.getAllData();
  }

}
