package com.example.kakeibo.domain.strategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.valueobject.TransactionType;

public class CategorySummaryStrategy implements SummaryStrategy{

	@Override
	public SummaryResult calculate(List<Transaction> transactions, int year, int month) {
        // 1. transactions を year と month でフィルタリング
		List<Transaction> filtered = transactions.stream()
				.filter(t -> t.getTransactionDate().getYear() == year)
				.filter(t -> t.getTransactionDate().getMonthValue() == month)
				.collect(Collectors.toList());
		//費用
		Map<Long,Integer> grouped = filtered.stream()
				.filter(t-> t.getType() == TransactionType.EXPENSE)
				.collect(Collectors.groupingBy(
						t -> t.getCategoryId().getValue(),
						Collectors.summingInt(t->t.getAmount().getValue())
						));
		
		 List<CategorySummaryResult.CategoryTotal> categoryTotals = grouped.entrySet().stream()
	              .map(e -> new CategorySummaryResult.CategoryTotal(e.getKey(), e.getValue()))
	              .collect(Collectors.toList());

		return new CategorySummaryResult(categoryTotals);
	}
	
}
