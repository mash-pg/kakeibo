package com.example.kakeibo.application.usecase;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.repository.TransactionRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ListTransactionsUseCase {
	private final TransactionRepository transactionRepository;
	
	public ListTransactionsUseCase(TransactionRepository transactionRepository
	) {
		this.transactionRepository = transactionRepository;
	}
	public List<Transaction> execute() {
		return transactionRepository.findAll();
		
	}
	
	
}
