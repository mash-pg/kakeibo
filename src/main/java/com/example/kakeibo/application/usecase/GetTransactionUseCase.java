package com.example.kakeibo.application.usecase;



import org.springframework.stereotype.Service;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.exception.TransactionNotFoundException;
import com.example.kakeibo.domain.repository.TransactionRepository;
import com.example.kakeibo.domain.valueobject.TransactionId;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class GetTransactionUseCase {
	private final TransactionRepository transactionRepository;
	
	public GetTransactionUseCase(TransactionRepository transactionRepository
	) {
		this.transactionRepository = transactionRepository;
	}
	public Transaction execute(Long id) {
		 TransactionId transactionId = new TransactionId(id); 
		 return transactionRepository.findById(transactionId)
				.orElseThrow(()->new TransactionNotFoundException("収支がみつかりません"));
	}
	
	
}
