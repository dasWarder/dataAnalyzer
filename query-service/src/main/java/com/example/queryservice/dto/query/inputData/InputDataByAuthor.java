package com.example.queryservice.dto.query.inputData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputDataByAuthor {

    private String author;

    private Pageable pageable;
}
