package com.example.kakeibo.presentation.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.valueobject.TransactionType;

import lombok.Getter;

@Getter
public class TransactionResponse {
	private Long id;
	private TransactionType type;
	private Integer amount;
	private Long categoryId;
	private String description;
	private LocalDate transactionDate;
	private LocalDateTime createdAt;
	
	public static TransactionResponse from(Transaction transaction) {
		TransactionResponse response = new TransactionResponse();
		response.id = (transaction.getId() != null) ? transaction.getId().getValue():null;
		response.type = transaction.getType();
		response.amount = transaction.getAmount().getValue();
		response.categoryId = (transaction.getCategoryId() != null) ? transaction.getCategoryId().getValue():null;
		response.description = transaction.getDescription();
		response.transactionDate = transaction.getTransactionDate();
		response.createdAt = transaction.getCreatedAt();
		
		return response;
	}	
}
