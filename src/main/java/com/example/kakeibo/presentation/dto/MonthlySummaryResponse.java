package com.example.kakeibo.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MonthlySummaryResponse {
	private int year;
	private int month;
	private int totalIncome;
	private int totalExpense;
	private int balance;
}
