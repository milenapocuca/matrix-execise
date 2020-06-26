package com.pannonia.execise.array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pannonia.exercise.array.exception.IllegalArgumentException;

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
	public void testSum() {

		// GIVEN
		Integer[] numbers = new Integer[] { 1, 2, 3, 4, 5, 6 };

		// WHEN
		Integer sum = arraySum.sum(numbers);

		// THEN
		assertThat(sum).isEqualTo(21);
	}

	@Test
	public void testSumWhenArrayIsNull() {

		// GIVEN
		Integer[] numbers = null;

		// WHEN
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			arraySum.sum(numbers);
		});

		// THEN
		assertThat(exception).hasMessage("Array cant be null");
	}

	@Test
	public void testElementIsNull() {

		// GIVEN
		Integer[] numbers = new Integer[] { 1, null, 3, 4, 5, 6 };

		// WHEN
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			arraySum.sum(numbers);
		});

		// THEN
		assertThat(exception).hasMessage("Array element cant be null");
	}

	@Test
	public void testSumTooHigh() {

		// GIVEN
		Integer[] numbers = new Integer[] { 1, Integer.MAX_VALUE };

		// WHEN
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			arraySum.sum(numbers);
		});

		// THEN
		assertThat(exception).hasMessage("Cannot calculate sum, numbers are too high (positive)");
	}

	@Test
	public void testSumTooLow() {

		// GIVEN
		Integer[] numbers = new Integer[] { -1, Integer.MIN_VALUE };

		// WHEN
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			arraySum.sum(numbers);
		});

		// THEN
		assertThat(exception).hasMessage("Cannot calculate sum, numbers are too low (negative)");
	}

	@AfterEach
	public void afterEach() {
		// release resources that are used by the tests
		// e.g. clear system properties if set or changed during the test
		System.clearProperty("property.used.in.the.test");
	}
}
