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
   * Utility method to convert 12-hour timeOfDay to 24-hour time notation
   *
   * @param timeOfDay the time in am/pm notation
   * @return          the time in 24-hour notation
   */
  public static int convertTo24HourClock(String timeOfDay) {
    try {
      String time = LocalTime.parse(timeOfDay.toUpperCase(),
              DateTimeFormatter.ofPattern("h:mma", Locale.US))
          .format(DateTimeFormatter.ofPattern("HHmm"));
      return Integer.parseInt(time);
    } catch (DateTimeParseException e) {
      throw new InvalidInputException("invalid timeOfDay");
    }
  }

  /**
   * Utility method to convert 24-hour time to 12-hour time notation
   *
   * @param time  the time in 24-hour notation
   * @return      the time in am/pm notation
   */
  public static String convertTo12HourClock(int time) {
    try {
      String pattern = null;
      if (time == 0) {
        pattern = "H";
      } else if (time > 0 && time < 10) {
        pattern = "m";
      } else if (time >= 10 && time < 60) {
        pattern = "mm";
      } else if (time >= 60 && time < 1000) {
        pattern = "Hmm";
      } else {
        pattern = "HHmm";
      }
      String timeOfDay = LocalTime.parse(String.valueOf(time),
              DateTimeFormatter.ofPattern(pattern, Locale.US))
          .format(DateTimeFormatter.ofPattern("h:mma"));
      return timeOfDay.toLowerCase();
    } catch (DateTimeParseException e) {
      throw new InvalidInputException("invalid time");
    }
  }
}
