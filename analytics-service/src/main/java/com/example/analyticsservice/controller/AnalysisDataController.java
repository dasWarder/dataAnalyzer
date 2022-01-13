package com.example.analyticsservice.controller;

import com.example.analyticsservice.dto.AnalysisDataResponse;
import com.example.analyticsservice.exception.AnalysisDataNotFoundException;
import com.example.analyticsservice.mappingService.AnalysisDataMapper;
import com.example.analyticsservice.model.AnalysisData;
import com.example.analyticsservice.service.data.AnalysisDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/analysisData")
public class AnalysisDataController {

  private final AnalysisDataMapper mapper;

  private final AnalysisDataService dataService;

  @GetMapping("/{id}")
  public ResponseEntity<AnalysisDataResponse> getAnalysisDataById(@PathVariable("id") Long id)
      throws AnalysisDataNotFoundException {

    AnalysisData analysisDataById = dataService.getAnalysisDataById(id);
    AnalysisDataResponse response = mapper.analysisDataToAnalysisDataResponse(analysisDataById);

    return ResponseEntity.ok(response);
  }

  @GetMapping("/data")
  public ResponseEntity<AnalysisDataResponse> getAnalysisDataByDataId(
      @RequestParam("dataId") String dataId) throws AnalysisDataNotFoundException {

    AnalysisData analysisDataByDataId = dataService.getAnalysisDataByDataId(dataId);
    AnalysisDataResponse response = mapper.analysisDataToAnalysisDataResponse(analysisDataByDataId);

    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<Page<AnalysisDataResponse>> getAllAnalysisData(
      @RequestParam(value = "creatingDate", required = false) LocalDateTime creatingDate,
      @PageableDefault(
              size = 20,
              sort = {"id"})
          Pageable pageable) {

    Page<AnalysisDataResponse> response =
        dataService
            .getAllAnalysisData(creatingDate, pageable)
            .map(mapper::analysisDataToAnalysisDataResponse);

    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAnalysisDataById(@PathVariable("id") Long id) {

    dataService.deleteAnalysisDataById(id);

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/data")
  public ResponseEntity<Void> deleteAnalysisDataByDataId(@RequestParam("dataId") String dataId) {

    dataService.deleteAnalysisDataByDataId(dataId);

    return ResponseEntity.noContent().build();
  }
}
