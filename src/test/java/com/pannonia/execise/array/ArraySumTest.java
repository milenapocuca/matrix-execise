package com.pannonia.execise.array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ArraySumTest {

  private ArraySum arraySum;

  @BeforeEach
  public void beforeEach() {
    // mock dependent components if needed
    // and initialize components here
    arraySum = new ArraySum();
  }

  /**
   * <b>GIVEN</b> array of integer values</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> sum value is as expected</br>
   */
  @Test
  @Disabled // TODO remove @Disabled annotation in order to enable the test
  public void testSum() {

    // GIVEN
    Integer[] numbers = new Integer[] { 1, 2, 3, 4, 5 };

    // WHEN
    Integer sum = arraySum.sum(numbers);

    // THEN
    assertThat(sum).isEqualTo(15);
  }

  /**
   * <b>GIVEN</b> array is null</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> {@link IllegalArgumentException} is thrown with appropriate
   * message </br>
   */
  @Test
  @Disabled // TODO remove @Disabled annotation in order to enable the test
  public void testNullInput() {

    // GIVEN
    Integer[] numbers = null;

    // WHEN
    Throwable thrown = catchThrowable(() -> {//
      arraySum.sum(numbers);
    });

    // THEN
    assertThat(thrown)//
        .isInstanceOf(IllegalArgumentException.class)//
        .hasMessageContaining("array is null");
  }

  /**
   * <b>GIVEN</b> array contains multiple values including highest integer number</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> {@link IllegalArgumentException} is thrown with appropriate
   * message </br>
   */
  @Test
  @Disabled // TODO remove @Disabled annotation in order to enable the test
  public void testMaxValue() {

    // GIVEN
    Integer[] numbers = new Integer[] { 1, 2, Integer.MAX_VALUE };

    // WHEN
    Throwable thrown = catchThrowable(() -> {//
      arraySum.sum(numbers);
    });

    // THEN
    assertThat(thrown)//
        .isInstanceOf(IllegalArgumentException.class)//
        .hasMessageContaining("could not calculate the sum, numbers are too high");
  }

  @AfterEach
  public void afterEach() {
    // release resources that are used by the tests
    // e.g. clear system properties if set or changed during the test
    System.clearProperty("property.used.in.the.test");
  }
}
