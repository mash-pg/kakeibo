package com.example.kakeibo.application.usecase;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.exception.CategoryNotFoundException;
import com.example.kakeibo.domain.exception.TransactionNotFoundException;
import com.example.kakeibo.domain.repository.CategoryRepository;
import com.example.kakeibo.domain.repository.TransactionRepository;
import com.example.kakeibo.domain.valueobject.Amount;
import com.example.kakeibo.domain.valueobject.CategoryId;
import com.example.kakeibo.domain.valueobject.TransactionId;
import com.example.kakeibo.domain.valueobject.TransactionType;

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
	public Transaction execute(
				Long id,
				Integer amount,
				TransactionType type,
				Long categoryId,
				String description,
				LocalDate transactionDate
			) {
		
		//VO変換
		TransactionId traId = new TransactionId(id);
		CategoryId catId = new CategoryId(categoryId);
		Amount amt = new Amount(amount);
		
		transactionRepository.findById(traId)
		.orElseThrow(()->new TransactionNotFoundException("収支がみつかりません"));
		
		categoryRepository.findById(catId)
		.orElseThrow(()->new CategoryNotFoundException("選択したカテゴリが見つかりません"));
		Transaction transaction = new Transaction(
				traId, 
				amt,
				type,
				catId,
				description, 
				transactionDate, 
				LocalDateTime.now());
		return transactionRepository.save(transaction);
	}
	
	
}
