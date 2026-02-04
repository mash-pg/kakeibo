package com.example.kakeibo.domain.valueobject;

import com.example.kakeibo.domain.exception.InvalidAmountException;
import com.example.kakeibo.domain.exception.TransactionNotFoundException;

public class Amount {
	private final Integer value;
	
	public Amount(Integer value) {
		if(value == null) {
			throw new TransactionNotFoundException("収支が見つかりません");
		}
		if(value <= 0 ) {
			throw new InvalidAmountException("金額が０以下です。");
		}
		this.value= value;
	}
	
	
	public Integer getValue() {
		return this.value;
	}
}
