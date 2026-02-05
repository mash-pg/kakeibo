package com.example.kakeibo.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategorySummaryResponse {
	private Long categoryId;
	private int totalAmount;
}
