package com.example.queryservice.controller;

import com.example.queryservice.dto.read.analysisData.AnalysisAuthorData;
import com.example.queryservice.dto.read.analysisData.AnalysisAuthorDateData;
import com.example.queryservice.dto.read.analysisData.AnalysisDateData;
import com.example.queryservice.dto.read.inputData.MainData;
import com.example.queryservice.projection.dataProjector.DataProjector;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/data")
public class DataController {

  private final DataProjector dataProjector;

  @GetMapping("/input")
  public ResponseEntity<Page<MainData>> getAllInputData(
      @RequestParam("pageable") Pageable pageable) {

    Page<MainData> mainData = dataProjector.projectInputData(pageable);

    return ResponseEntity.ok(mainData);
  }

  @GetMapping("/input/author")
  public ResponseEntity<Page<MainData>> getInputDataByAuthor(
      @RequestParam("author") String author, @RequestParam("pageable") Pageable pageable) {

    Page<MainData> inputData = dataProjector.projectInputData(author, pageable);

    return ResponseEntity.ok(inputData);
  }

  @GetMapping("/input/date")
  public ResponseEntity<Page<MainData>> getInputDataByDate(
      @RequestParam("date") LocalDateTime date, @RequestParam("pageable") Pageable pageable) {

    Page<MainData> inputData = dataProjector.projectInputData(date, pageable);

    return ResponseEntity.ok(inputData);
  }

  @GetMapping("/analysis/author")
  public ResponseEntity<AnalysisAuthorData> getDataCountByAuthor(
      @RequestParam("author") String author) {

    AnalysisAuthorData authorData = dataProjector.projectAnalysisData(author);

    return ResponseEntity.ok(authorData);
  }

  @GetMapping("/analysis/cratingDate")
  public ResponseEntity<AnalysisDateData> getDataCountByCreatingDate(
      @RequestParam("creatingDate") LocalDateTime creatingDate) {

    AnalysisDateData dateData = dataProjector.projectAnalysisData(creatingDate);

    return ResponseEntity.ok(dateData);
  }

  @GetMapping("/analysis")
  public ResponseEntity<AnalysisAuthorDateData> getDataCountByAuthorAndCreatingDate(
      @RequestParam("author") String author,
      @RequestParam("creatingDate") LocalDateTime creatingDate) {

    AnalysisAuthorDateData authorDateData = dataProjector.projectAnalysisData(author, creatingDate);

    return ResponseEntity.ok(authorDateData);
  }
}
