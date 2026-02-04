package com.example.kakeibo.application.usecase;


import org.springframework.stereotype.Service;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.exception.CategoryNotFoundException;
import com.example.kakeibo.domain.repository.CategoryRepository;
import com.example.kakeibo.domain.repository.TransactionRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class CreateTransactionUseCase {
	private final TransactionRepository transactionRepository;
	private final CategoryRepository categoryRepository;
	
	public CreateTransactionUseCase(TransactionRepository transactionRepository
			,CategoryRepository categoryRepository) {
		this.transactionRepository = transactionRepository;
		this.categoryRepository =  categoryRepository;
	}
	public void execute(Transaction transaction) {
		
		categoryRepository.findById(transaction.getCategoryId())
		.orElseThrow(()->new CategoryNotFoundException("カテゴリがみつかりません"));
		
		//登録処理
		transactionRepository.save(transaction);
	}
	
	
}
