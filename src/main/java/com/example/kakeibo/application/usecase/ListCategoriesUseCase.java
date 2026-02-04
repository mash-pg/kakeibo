package com.example.kakeibo.application.usecase;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kakeibo.domain.entity.Category;
import com.example.kakeibo.domain.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ListCategoriesUseCase {
	private final CategoryRepository categoryRepository;
	
	public ListCategoriesUseCase(CategoryRepository categoryRepository) {
		this.categoryRepository =  categoryRepository;
	}
	public List<Category> execute() {
		List<Category> categorylist = categoryRepository.findAll();
		return categorylist;
	}
	
}
