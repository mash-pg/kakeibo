package com.example.kakeibo.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.kakeibo.domain.valueobject.Amount;
import com.example.kakeibo.domain.valueobject.CategoryId;
import com.example.kakeibo.domain.valueobject.TransactionId;
import com.example.kakeibo.domain.valueobject.TransactionType;

public class Transaction {
	private final TransactionId id;
	private TransactionType type;
	private Amount amount;
	private final CategoryId categoryId;
	private String description;
	private LocalDate transactionDate;
	private LocalDateTime createdAt;
	
	public Transaction(
			TransactionId id,
			Amount amount,
			TransactionType type,
			CategoryId categoryId,
			String description,
			LocalDate transactionDate,
			LocalDateTime createdAt
			) {
				this.id = id;
				this.type = type;
				this.amount = amount;
				this.categoryId = categoryId;
				this.description = description;
				this.transactionDate = transactionDate;
				this.createdAt = createdAt;
	}
	
	public TransactionId getId() {
		return this.id;
	}

	public TransactionType getType() {
		return this.type;
	}
	
	public Amount getAmount() {
		return this.amount;
	}
	
	public CategoryId getCategoryId() {
		return this.categoryId;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public LocalDate getTransactionDate() {
		return this.transactionDate;
	}
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}
	
}
