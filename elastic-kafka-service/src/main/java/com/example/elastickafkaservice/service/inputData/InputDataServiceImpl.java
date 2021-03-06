package com.example.elastickafkaservice.service.inputData;

import com.example.elastickafkaservice.exception.InputDataNotStoredException;
import com.example.elastickafkaservice.model.InputDataDto;
import com.example.elastickafkaservice.repository.InputDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class InputDataServiceImpl implements InputDataService {

    private final InputDataRepository inputDataRepository;

    @Override
    public InputDataDto saveInputData(InputDataDto inputDataDto) throws InputDataNotStoredException {

        log.info("In InputDataRepositoryImpl.saveInputData - Save a new input data");

        InputDataDto storedData = inputDataRepository.save(inputDataDto);

        if(Objects.isNull(storedData)) {

            log.error("In InputDataRepositoryImpl.saveInputData - Throw InputDataNotStoredException");
            throw new InputDataNotStoredException("InputData not stored");
        }

        return storedData;
    }
}
