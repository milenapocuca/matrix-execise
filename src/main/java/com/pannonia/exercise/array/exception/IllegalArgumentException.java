package com.pannonia.exercise.array.exception;

public class IllegalArgumentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2283665049458630473L;

	public IllegalArgumentException(String message) {
		super(message);
	}

	public IllegalArgumentException(String message, Throwable cause) {
		super(message, cause);
	}
}
