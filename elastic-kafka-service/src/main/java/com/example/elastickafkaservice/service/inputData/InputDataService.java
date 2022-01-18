package com.example.elastickafkaservice.service.inputData;

import com.example.elastickafkaservice.exception.InputDataNotStoredException;
import com.example.elastickafkaservice.model.InputDataDto;

public interface InputDataService {

    InputDataDto saveInputData(InputDataDto inputDataDto) throws InputDataNotStoredException;
}
