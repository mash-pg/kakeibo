package com.example.kakeibo.domain.exception;

public class InvalidAmountException extends RuntimeException{
	public InvalidAmountException(String message) {
		super(message);
	}
}
