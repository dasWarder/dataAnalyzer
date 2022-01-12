package com.example.elastickafkaservice.service.inputData;

import com.example.elastickafkaservice.exception.InputDataNotStoredException;
import com.example.elastickafkaservice.model.InputData;

public interface InputDataService {

    InputData saveInputData(InputData inputData) throws InputDataNotStoredException;
}
