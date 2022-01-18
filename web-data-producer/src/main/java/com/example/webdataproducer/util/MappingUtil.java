package com.example.webdataproducer.util;

import com.example.webdataproducer.dto.Request;
import com.example.webdataproducer.dto.Response;
import com.example.webdataproducer.dto.InputData;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
public class MappingUtil {

    public static final InputData requestToInputData(Request request) {

        log.info("In MappingUtil.requestToInputData - Request to inputData");

    return InputData.builder()
        .id(UUID.randomUUID().toString())
        .author(request.getAuthor())
        .message(request.getMessage())
        .date(LocalDate.now().atStartOfDay())
        .build();
    }


    public static final Response inputDataToResponse(InputData inputData) {

        log.info("In MappingUtil.inputDataToResponse - InputData with id = {} to Response", inputData.getId());

        return Response.builder()
                .id(inputData.getId())
                .date(inputData.getDate())
                .build();
    }
}
