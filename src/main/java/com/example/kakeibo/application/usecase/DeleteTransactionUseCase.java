package com.example.kakeibo.application.usecase;


import org.springframework.stereotype.Service;

import com.example.kakeibo.domain.repository.TransactionRepository;
import com.example.kakeibo.domain.valueobject.TransactionId;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class DeleteTransactionUseCase {
	private final TransactionRepository transactionRepository;
	
	public DeleteTransactionUseCase(TransactionRepository transactionRepository
	) {
		this.transactionRepository = transactionRepository;
	}
	public void execute(TransactionId id) {
		transactionRepository.deleteById(id);
	}
	
	
}
