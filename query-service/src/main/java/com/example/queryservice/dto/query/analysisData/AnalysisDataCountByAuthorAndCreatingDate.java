package com.example.queryservice.dto.query.analysisData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisDataCountByAuthorAndCreatingDate {

    private String author;

    private LocalDateTime creatingDate;
}
