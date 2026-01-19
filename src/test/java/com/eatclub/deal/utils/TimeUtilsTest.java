package com.eatclub.deal.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.eatclub.deal.exception.InvalidInputException;
import com.eatclub.deal.util.TimeUtils;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TimeUtilsTest {

  @ParameterizedTest
  @MethodSource("provideDataForConvertTo24HourClock")
  void testConvertTo24HourClock(String input, int expectedOutput) {
    int output = TimeUtils.convertTo24HourClock(input);
    assertEquals(expectedOutput, output);
  }

  static Stream<Arguments> provideDataForConvertTo24HourClock() {
    return Stream.of(
        Arguments.of("11:00am", 1100),
        Arguments.of("12:00am", 0),
        Arguments.of("11:00pm", 2300),
        Arguments.of("12:00pm", 1200)
    );
  }

  @ParameterizedTest
  @MethodSource("provideDataForConvertTo12HourClock")
  void testConvertTo12HourClock(int input, String expectedOutput) {
    String output = TimeUtils.convertTo12HourClock(input);
    assertEquals(expectedOutput, output);
  }

  static Stream<Arguments> provideDataForConvertTo12HourClock() {
    return Stream.of(
        Arguments.of(1100, "11:00am"),
        Arguments.of( 0, "12:00am"),
        Arguments.of( 100, "1:00am"),
        Arguments.of( 900, "9:00am"),
        Arguments.of(2300, "11:00pm"),
        Arguments.of(1200, "12:00pm")
    );
  }

  @Test
  void whenInvalidAMPM_thenException() {
    String input = "11:00rt";
    assertThrows(InvalidInputException.class, () -> TimeUtils.convertTo24HourClock(input));
  }

  @Test
  void whenInvalidTime_thenException() {
    String input = "11:68pm";
    assertThrows(InvalidInputException.class, () -> TimeUtils.convertTo24HourClock(input));
  }

  @Test
  void whenInvalid24HourTime_thenException() {
    int input = 1168;
    assertThrows(InvalidInputException.class, () -> TimeUtils.convertTo12HourClock(input));
  }
}
