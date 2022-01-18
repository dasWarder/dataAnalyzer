package com.example.queryservice.mappingService.query;

import com.example.queryservice.dto.query.inputData.InputDataByAuthor;
import org.mapstruct.Mapper;

@Mapper
public interface InputDataQueryMapper {

    InputDataByAuthor paramsToInputDataByAuthor(String author);
}
