package com.example.webservice.controller;

import com.example.webservice.dto.analysisData.AnalysisAuthorData;
import com.example.webservice.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/data")
public class DataController {

    private final DataService dataService;

    @GetMapping
    public ResponseEntity<String> getDataByParam(@RequestParam("author") String author) {

        HttpEntity<String> dataByAuthor = dataService.getDataByAuthor(author);

        return (ResponseEntity<String>) dataByAuthor;
    }
}
