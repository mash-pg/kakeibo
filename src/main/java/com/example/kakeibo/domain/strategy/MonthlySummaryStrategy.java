package com.example.kakeibo.domain.strategy;

import java.util.List;
import java.util.stream.Collectors;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.valueobject.TransactionType;

public class MonthlySummaryStrategy implements SummaryStrategy{

	@Override
	public SummaryResult calculate(List<Transaction> transactions, int year, int month) {
        // 1. transactions を year と month でフィルタリング
		List<Transaction> filtered = transactions.stream()
				.filter(t -> t.getTransactionDate().getYear() == year)
				.filter(t -> t.getTransactionDate().getMonthValue() == month)
				.collect(Collectors.toList());
        // 2. INCOME の合計を計算
		int totalIncome = filtered.stream()
				.filter(t -> t.getType() == TransactionType.INCOME)
				.mapToInt(t -> t.getAmount().getValue())
				.sum();
        // 3. EXPENSE の合計を計算
		int totalExpense = filtered.stream()
				.filter(t -> t.getType() == TransactionType.EXPENSE)
				.mapToInt(t -> t.getAmount().getValue())
				.sum();
        // 4. 残高（INCOME - EXPENSE）を計算
		int balance = totalIncome - totalExpense;
		
		return new MonthlySummaryResult(year, month, totalIncome, totalExpense, balance);
	}
	
}
