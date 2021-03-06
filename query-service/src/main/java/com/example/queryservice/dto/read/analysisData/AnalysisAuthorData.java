package com.example.queryservice.dto.read.analysisData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisAuthorData {

    private String author;

    private Long messagesCount;
}
