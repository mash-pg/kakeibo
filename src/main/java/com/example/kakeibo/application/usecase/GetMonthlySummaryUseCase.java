package com.example.kakeibo.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.repository.TransactionRepository;
import com.example.kakeibo.domain.strategy.CategorySummaryStrategy;
import com.example.kakeibo.domain.strategy.MonthlySummaryStrategy;
import com.example.kakeibo.domain.strategy.SummaryStrategy;

@Service
public class GetMonthlySummaryUseCase {
	private final TransactionRepository transactionRepository;
	
	public GetMonthlySummaryUseCase(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}
	public Object execute(int year,int month,String type) {
		List<Transaction> transactions = transactionRepository.findAll();
		
		SummaryStrategy strategy;
		if("category".equals(type)) {
			strategy = new CategorySummaryStrategy();
		}else {
			strategy = new MonthlySummaryStrategy();
		}
		
		return strategy.calculate(transactions, year, month);
	}
}
