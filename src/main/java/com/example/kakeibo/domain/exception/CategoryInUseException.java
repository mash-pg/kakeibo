package com.example.kakeibo.domain.exception;

public class CategoryInUseException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CategoryInUseException(String message) {
		super(message);
	}
}
