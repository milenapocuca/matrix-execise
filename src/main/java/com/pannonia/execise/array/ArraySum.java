package com.pannonia.execise.array;

import com.pannonia.exercise.array.exception.IllegalArgumentException;

public class ArraySum {

	public Integer sum(Integer[] array) {

		if (array == null) {
			throw new IllegalArgumentException("Array cant be null");
		}
		Integer summed = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				throw new IllegalArgumentException("Array element cant be null");
			}

			try {
				summed = Math.addExact(summed, array[i]);
			} catch (ArithmeticException e) {
				if (summed > 0) {
					throw new IllegalArgumentException("Cannot calculate sum, numbers are too high (positive)", e);
				} else {
					throw new IllegalArgumentException("Cannot calculate sum, numbers are too low (negative)", e);
				}
			}
		}
		return summed;
	}
}
