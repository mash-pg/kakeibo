package com.example.kakeibo.domain.exception;

public class CategoryInUseException extends RuntimeException{
	public CategoryInUseException(String message) {
		super(message);
	}
}
