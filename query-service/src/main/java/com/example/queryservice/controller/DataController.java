package com.example.queryservice.controller;

import com.example.queryservice.controller.util.ControllerUtility;
import com.example.queryservice.dto.read.analysisData.AnalysisAuthorData;
import com.example.queryservice.dto.read.analysisData.AnalysisAuthorDateData;
import com.example.queryservice.dto.read.analysisData.AnalysisDateData;
import com.example.queryservice.dto.read.inputData.MainData;
import com.example.queryservice.projection.dataProjector.DataProjector;
import lombok.RequiredArgsConstructor;
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

  private final DataProjector dataProjector;

  @GetMapping("/input")
  public ResponseEntity<List<MainData>> getAllInputData() {

    List<MainData> mainData = dataProjector.projectInputData();

    return ResponseEntity.ok(mainData);
  }

  @GetMapping("/input/author")
  public ResponseEntity<List<MainData>> getInputDataByAuthor(
      @RequestParam("author") String author) {

    List<MainData> inputData = dataProjector.projectInputData(author);

    return ResponseEntity.ok(inputData);
  }

  @GetMapping("/analysis/author")
  public ResponseEntity<AnalysisAuthorData> getDataCountByAuthor(
      @RequestParam("author") String author) {

    AnalysisAuthorData authorData = dataProjector.projectAnalysisData(author);

    return ResponseEntity.ok(authorData);
  }

  @GetMapping("/analysis/creatingDate")
  public ResponseEntity<AnalysisDateData> getDataCountByCreatingDate(
      @RequestParam("creatingDate") String creatingDate) {

    AnalysisDateData dateData =
        dataProjector.projectAnalysisData(
            ControllerUtility.convertDateTimeStringToLDT(creatingDate));

    return ResponseEntity.ok(dateData);
  }

  @GetMapping("/analysis")
  public ResponseEntity<AnalysisAuthorDateData> getDataCountByAuthorAndCreatingDate(
      @RequestParam("author") String author, @RequestParam("creatingDate") String creatingDate) {

    AnalysisAuthorDateData authorDateData =
        dataProjector.projectAnalysisData(
            author, ControllerUtility.convertDateTimeStringToLDT(creatingDate));

    return ResponseEntity.ok(authorDateData);
  }
}
