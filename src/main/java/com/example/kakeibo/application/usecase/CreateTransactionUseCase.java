package com.example.kakeibo.application.usecase;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.exception.CategoryNotFoundException;
import com.example.kakeibo.domain.repository.CategoryRepository;
import com.example.kakeibo.domain.repository.TransactionRepository;
import com.example.kakeibo.domain.valueobject.Amount;
import com.example.kakeibo.domain.valueobject.CategoryId;
import com.example.kakeibo.domain.valueobject.TransactionType;

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
	public Transaction execute(
			TransactionType type,
			Integer amount,
			Long categoryId,
			String description,
			LocalDate transactionDate
			){
		//VO変換
		CategoryId catId = new CategoryId(categoryId);
		Amount amt = new Amount(amount);
		
		categoryRepository.findById(catId)
		.orElseThrow(()->new CategoryNotFoundException("カテゴリがみつかりません"));
		
		Transaction transaction = new Transaction(
				null,
				amt,
				type,
				catId,
				description,
				transactionDate,
				LocalDateTime.now()
				);
		//登録処理
		return transactionRepository.save(transaction);
	}
	
	
}
