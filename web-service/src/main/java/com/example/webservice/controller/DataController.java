package com.example.webservice.controller;

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
    public ResponseEntity<String> getDataByParam(@RequestParam("author") String author) {

        HttpEntity<String> dataByAuthor = dataService.getDataByAuthor(author);

        return (ResponseEntity<String>) dataByAuthor;
    }

    @GetMapping("/raw")
    public ResponseEntity<Void> getAllData() {

        HttpEntity<List<MainData>> allData = dataService.getAllData();

        return ResponseEntity.noContent().build();
    }
}
