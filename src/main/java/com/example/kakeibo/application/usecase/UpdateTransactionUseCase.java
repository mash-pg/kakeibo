package com.example.kakeibo.application.usecase;


import org.springframework.stereotype.Service;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.exception.CategoryNotFoundException;
import com.example.kakeibo.domain.exception.TransactionNotFoundException;
import com.example.kakeibo.domain.repository.CategoryRepository;
import com.example.kakeibo.domain.repository.TransactionRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class UpdateTransactionUseCase {
	private final TransactionRepository transactionRepository;
	private final CategoryRepository categoryRepository;
	
	public UpdateTransactionUseCase(TransactionRepository transactionRepository
			,CategoryRepository categoryRepository) {
		this.transactionRepository = transactionRepository;
		this.categoryRepository =  categoryRepository;
	}
	public void execute(Transaction transaction ) {
		
		transactionRepository.findById(transaction.getId())
		.orElseThrow(()->new TransactionNotFoundException("収支がみつかりません"));
		
		categoryRepository.findById(transaction.getCategoryId())
		.orElseThrow(()->new CategoryNotFoundException("選択したカテゴリが見つかりません"));
		
		transactionRepository.save(transaction);
	}
	
	
}
