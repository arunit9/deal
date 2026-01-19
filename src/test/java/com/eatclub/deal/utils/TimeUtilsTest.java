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
  @MethodSource("provideInputAndOutput")
  void testIsBlankWithVariousBlanks(String input, int expectedOutput) {
    int output = TimeUtils.convertClock(input);
    assertEquals(expectedOutput, output);
  }

  static Stream<Arguments> provideInputAndOutput() {
    return Stream.of(
        Arguments.of("11:00am", 1100),
        Arguments.of("12:00am", 0),
        Arguments.of("11:00pm", 2300),
        Arguments.of("12:00pm", 1200)
    );
  }

  @Test
  void whenInvalidAMPM_thenException() {
    String input = "11:00rt";
    assertThrows(InvalidInputException.class, () -> TimeUtils.convertClock(input));
  }

  @Test
  void whenInvalidTime_thenException() {
    String input = "11:68pm";
    assertThrows(InvalidInputException.class, () -> TimeUtils.convertClock(input));
  }
}
