package com.example.kakeibo.domain.exception;

public class InvalidCategoryException extends RuntimeException{
	public InvalidCategoryException(String message) {
		super(message);
	}
}
