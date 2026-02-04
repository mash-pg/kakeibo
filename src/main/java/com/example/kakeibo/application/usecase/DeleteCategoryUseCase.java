package com.example.kakeibo.application.usecase;


import org.springframework.stereotype.Service;

import com.example.kakeibo.domain.exception.CategoryInUseException;
import com.example.kakeibo.domain.exception.CategoryNotFoundException;
import com.example.kakeibo.domain.repository.CategoryRepository;
import com.example.kakeibo.domain.repository.TransactionRepository;
import com.example.kakeibo.domain.valueobject.CategoryId;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeleteCategoryUseCase {
	private final TransactionRepository transactionRepository;
	private final CategoryRepository categoryRepository;
	
	public DeleteCategoryUseCase(TransactionRepository transactionRepository
			,CategoryRepository categoryRepository) {
		this.transactionRepository = transactionRepository;
		this.categoryRepository =  categoryRepository;
	}
	
	public void execute(Long categoryId) {
		
		//１．カテゴリのチェック
		categoryRepository
				.findById(new CategoryId(categoryId))
				.orElseThrow(()-> new CategoryNotFoundException("カテゴリがみつかりません"));
		
		//２．カテゴリが使用中かチェック
		boolean isUse = transactionRepository.existsByCategoryId(new CategoryId(categoryId));
		if(isUse) {
			throw new CategoryInUseException("使用中のカテゴリは削除できません");
		}
		
		//削除処理
		categoryRepository.deleteById(new CategoryId(categoryId));
		
	}
	
	
}
