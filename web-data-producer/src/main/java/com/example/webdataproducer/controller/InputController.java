package com.example.webdataproducer.controller;

import com.example.webdataproducer.dto.Request;
import com.example.webdataproducer.dto.Response;
import com.example.webdataproducer.service.KafkaService;
import com.example.webdataproducer.dto.InputData;
import com.example.webdataproducer.util.MappingUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class InputController {

    private final KafkaService kafkaService;

    @PostMapping("/data")
    public ResponseEntity<Response> processData(@RequestBody Request request) throws JsonProcessingException {

        InputData inputData = MappingUtil.requestToInputData(request);
        kafkaService.produceMessage(inputData);
        Response response = MappingUtil.inputDataToResponse(inputData);

        return ResponseEntity.ok(response);
    }
}
