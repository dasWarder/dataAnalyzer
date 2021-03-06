package com.example.queryservice.dto.query.analysisData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisDataCountByAuthor {
    
    private String author;
}
