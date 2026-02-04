package com.example.kakeibo.domain.valueobject;

public class TransactionId {
	private final Long value;
	public TransactionId(Long value) {
		if(value == null) {
			throw new IllegalArgumentException("transactionIdを設定してください");
		}
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
