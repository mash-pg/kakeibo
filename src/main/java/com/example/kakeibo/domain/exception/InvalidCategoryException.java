package com.example.kakeibo.domain.exception;

public class InvalidCategoryException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidCategoryException(String message) {
		super(message);
	}
}
