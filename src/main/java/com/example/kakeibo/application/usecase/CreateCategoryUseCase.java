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
	public Category execute(String name) {
		CategoryName categoryName = new CategoryName(name);
		boolean isUse = categoryRepository.existsByName(categoryName);
		if(isUse) {
			throw new InvalidCategoryException("すでにカテゴリが存在しております");
		}
		return categoryRepository.save(new Category(null,categoryName));
	}
	
}
