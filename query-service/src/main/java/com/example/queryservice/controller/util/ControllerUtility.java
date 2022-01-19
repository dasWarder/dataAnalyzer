package com.example.queryservice.controller.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ControllerUtility {

  public static final LocalDateTime convertDateTimeStringToLDT(String dateTime) {
    return LocalDate.parse(dateTime).atStartOfDay();
  }
}
