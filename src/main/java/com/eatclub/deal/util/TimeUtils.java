package com.eatclub.deal.util;

import com.eatclub.deal.exception.InvalidInputException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * This is a utility class to handle time related methods such as conversion from 12-hour to 24-hour format
 */
public class TimeUtils {
  private TimeUtils() {}

  /**
   * Utility method to convert timeOfDay to 24-hour time notation
   *
   * @param timeOfDay the time in am/pm format
   * @return          the time in 24-hour notation
   */
  public static int convertClock(String timeOfDay) {
    try {
      String time = LocalTime.parse(timeOfDay.toUpperCase(),
              DateTimeFormatter.ofPattern("h:mma", Locale.US))
          .format(DateTimeFormatter.ofPattern("HHmm"));
      return Integer.parseInt(time);
    } catch (DateTimeParseException e) {
      throw new InvalidInputException("invalid timeOfDay");
    }
  }
}
