package com.example.webservice.service;

import com.example.webservice.dto.analysisData.AnalysisAuthorData;
import com.example.webservice.dto.analysisData.AnalysisAuthorDateData;
import com.example.webservice.dto.analysisData.AnalysisDateData;
import com.example.webservice.dto.inputData.MainData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

  private final RestTemplate restTemplate;

  @Value("${uri.input}")
  private String baseInputDataUri;

  @Value("${uri.analysis}")
  private String baseAnalysisDataUri;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Param {

    private String paramName;

    private String paramValue;
  }

  @Override
  public HttpEntity<List<MainData>> getAllData() {

    HttpEntity<?> entity = getHttpEntity();
    String urlTemplate = formulateUriTemplate(baseInputDataUri);

    HttpEntity<List<MainData>> exchange =
        restTemplate.exchange(
            urlTemplate,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<List<MainData>>() {});

    log.info("In DataServiceImpl.getAllData - HttpEntity processed");

    return exchange;
  }

  @Override
  public HttpEntity<List<MainData>> getDataByAuthor(String author) {

    HttpEntity<?> entity = getHttpEntity();
    String uriTemplate = formulateUriTemplate(baseInputDataUri + "/author", "author");
    Map<String, String> params = getParamsMap(new Param("author", author));

    ResponseEntity<List<MainData>> exchange =
        restTemplate.exchange(
            uriTemplate,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<List<MainData>>() {},
            params);

    log.info("In DataServiceImpl.getDataByAuthor - HttpEntity by author = {} processed", author);

    return exchange;
  }

  @Override
  public HttpEntity<AnalysisAuthorData> getAnalysedDataByAuthor(String author) {

    HttpEntity<?> entity = getHttpEntity();
    String uriTemplate = formulateUriTemplate(baseAnalysisDataUri + "/author", "author");
    Map<String, String> params = getParamsMap(new Param("author", author));

    HttpEntity<AnalysisAuthorData> exchange =
        restTemplate.exchange(
            uriTemplate, HttpMethod.GET, entity, AnalysisAuthorData.class, params);

    log.info(
        "In DataServiceImpl.getAnalysedDataByAuthor - HttpEntity by author = {} processed", author);

    return exchange;
  }

  @Override
  public HttpEntity<AnalysisDateData> getAnalysedDataByCreatingDate(String creatingDate) {

    HttpEntity<?> entity = getHttpEntity();
    String uriTemplate =
        formulateUriTemplate(baseAnalysisDataUri + "/creatingDate", "creatingDate");
    Map<String, String> params = getParamsMap(new Param("creatingDate", creatingDate));

    ResponseEntity<AnalysisDateData> exchange =
        restTemplate.exchange(uriTemplate, HttpMethod.GET, entity, AnalysisDateData.class, params);

    log.info(
        "In DataServiceImpl.getAnalysedDataByCreatingDate - HttpEntity by creatingDate = {} processed",
        creatingDate);

    return exchange;
  }

  @Override
  public HttpEntity<AnalysisAuthorDateData> getAnalysedDataByAuthorAndCreatingDate(
      String author, String creatingDate) {

    HttpEntity<?> entity = getHttpEntity();
    String uriTemplate = formulateUriTemplate(baseAnalysisDataUri, "author", "creatingDate");
    Map<String, String> params =
        getParamsMap(
            new Param("author", author), new Param("creatingDate", creatingDate));

    ResponseEntity<AnalysisAuthorDateData> exchange =
        restTemplate.exchange(
            uriTemplate, HttpMethod.GET, entity, AnalysisAuthorDateData.class, params);

    log.info(
        "In DataServiceImpl.getAnalysedDataByAuthorAndCreatingDate - HttpEntity by author = {} and creatingDate = {} processed",
        author,
        creatingDate);

    return exchange;
  }

  private HttpEntity<?> getHttpEntity() {
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

    return new HttpEntity<>(headers);
  }

  private String formulateUriTemplate(String uri, String... params) {

    if (Objects.isNull(params) || params.length == 0) {
      return UriComponentsBuilder.fromHttpUrl(uri).encode().toUriString();
    }

    MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
    Stream.of(params).forEach(p -> paramsMap.add(p, "{" + p + "}"));

    return UriComponentsBuilder.fromHttpUrl(uri).queryParams(paramsMap).encode().toUriString();
  }

  private Map<String, String> getParamsMap(Param... params) {

    Map<String, String> paramMap = new HashMap<>();
    Stream.of(params).forEach(p -> paramMap.put(p.getParamName(), p.getParamValue()));

    return paramMap;
  }
}
