package com.example.kakeibo.presentation.dto;

import java.time.LocalDate;

import com.example.kakeibo.domain.valueobject.TransactionType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateTransactionRequest {
	@NotNull(message = "収支タイプは必須です")
	private TransactionType type;
	@NotNull(message = "金額は必須です")
	@Min(value = 1, message = "金額は1以上である必要があります")
	private Integer amount;
	private String description;
	@NotNull(message = "カテゴリIDは必須です")
	private Long categoryId;
	@NotNull(message = "取引日は必須です")
	private LocalDate transactionDate;
}
