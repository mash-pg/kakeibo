package com.example.kakeibo.domain.exception;

public class TransactionNotFoundException extends RuntimeException{
	public TransactionNotFoundException(String message) {
		super(message);
	}
}
