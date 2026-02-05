package com.example.kakeibo.domain.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MonthlySummaryResult implements SummaryResult {
    private int year;
    private int month;
    private int totalIncome;
    private int totalExpense;
    private int balance;
}
