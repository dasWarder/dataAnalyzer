package com.example.queryservice.dto.read.analysisData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisAuthorDateData {

    private String author;

    private LocalDateTime creatingDate;

    private Long messagesCount;
}
