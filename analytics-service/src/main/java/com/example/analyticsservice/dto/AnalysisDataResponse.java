package com.example.analyticsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisDataResponse {

    private Long id;

    private String dataId;

    private String author;

    private String message;

    private LocalDateTime processingDate;
}
