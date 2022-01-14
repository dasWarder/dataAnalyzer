package com.example.webservice.service;

import com.example.webservice.dto.analysisData.AnalysisAuthorData;
import com.example.webservice.dto.analysisData.AnalysisAuthorDateData;
import com.example.webservice.dto.analysisData.AnalysisDateData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

  private final RestTemplate restTemplate;

  @Value("${uri.input}")
  private String baseInputDataUri;

  @Value("${uri.analysis}")
  private String baseAnalysisDataUri;

//  @Override
//  public HttpEntity<Page<MainData>> getAllData(Pageable pageable) {
//
//    return null;
//  }
//
//  @Override
//  public HttpEntity<Page<MainData>> getDataByAuthor(String author, Pageable pageable) {
//    return null;
//  }
//
//  @Override
//  public HttpEntity<Page<MainData>> getDataByDate(LocalDateTime date, Pageable pageable) {
//    return null;
//  }

  @Override
  public HttpEntity<String> getDataByAuthor(String author) {

    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    HttpEntity<?> entity = new HttpEntity<>(headers);

    String urlTemplate =
        UriComponentsBuilder.fromHttpUrl(baseAnalysisDataUri + "/author")
            .queryParam("author", "{author}")
            .encode()
            .toUriString();

    Map<String, String> params = new HashMap<>();
    params.put("author", author);

    HttpEntity<String> exchange =
        restTemplate.exchange(
            urlTemplate, HttpMethod.GET, entity, String.class, params);

    return exchange;
  }

  @Override
  public HttpEntity<AnalysisDateData> getDataByCreatingDate(LocalDateTime creatingDate) {
    return null;
  }

  @Override
  public HttpEntity<AnalysisAuthorDateData> getDataByAuthorAndCreatingDate(
      String author, LocalDateTime creatingDate) {
    return null;
  }
}
