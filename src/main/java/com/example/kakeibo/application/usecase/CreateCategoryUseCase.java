package com.example.kakeibo.application.usecase;


import org.springframework.stereotype.Service;

import com.example.kakeibo.domain.entity.Category;
import com.example.kakeibo.domain.exception.InvalidCategoryException;
import com.example.kakeibo.domain.repository.CategoryRepository;
import com.example.kakeibo.domain.valueobject.CategoryName;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CreateCategoryUseCase {
	private final CategoryRepository categoryRepository;
	
	public CreateCategoryUseCase(
			CategoryRepository categoryRepository) {
		this.categoryRepository =  categoryRepository;
	}
	public void execute(CategoryName name) {
		boolean isUse = categoryRepository.existsByName(name);
		if(isUse) {
			throw new InvalidCategoryException("すでにカテゴリが存在しております");
		}
		categoryRepository.save(new Category(null,name));
	}
	
}
