package com.example.queryservice.controller.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ControllerUtility {


  /**
   * Converter for converting LocalDate string to LocalDateTime object at the start of the day.
   * @param dateTime string in format yyyy-MM-dd
   * @return LocalDateObject in format yyyy-MM-dd hh:mm:ss
   */
  public static final LocalDateTime convertDateTimeStringToLDT(String dateTime) {
    return LocalDate.parse(dateTime).atStartOfDay();
  }
}
