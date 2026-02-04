package com.example.kakeibo.domain.exception;

public class InvalidAmountException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidAmountException(String message) {
		super(message);
	}
}
