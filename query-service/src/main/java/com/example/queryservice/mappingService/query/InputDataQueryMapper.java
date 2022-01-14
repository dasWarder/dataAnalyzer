package com.example.queryservice.mappingService.query;

import com.example.queryservice.dto.read.inputData.MainData;
import com.example.queryservice.dto.query.inputData.AllInputData;
import com.example.queryservice.dto.query.inputData.InputDataByAuthor;
import com.example.queryservice.dto.query.inputData.InputDataByDate;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

@Mapper
public interface InputDataQueryMapper {

    AllInputData paramsToAllInputData(Pageable pageable);

    InputDataByAuthor paramsToInputDataByAuthor(String author, Pageable pageable);

    InputDataByDate paramsToInputDataByDate(LocalDateTime date, Pageable pageable);

    MainData allInputDataToMainData(AllInputData allInputData);
}
