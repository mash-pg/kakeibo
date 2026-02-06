package com.example.kakeibo.presentation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakeibo.application.usecase.CreateCategoryUseCase;
import com.example.kakeibo.application.usecase.DeleteCategoryUseCase;
import com.example.kakeibo.application.usecase.ListCategoriesUseCase;
import com.example.kakeibo.domain.entity.Category;
import com.example.kakeibo.presentation.dto.CategoryResponse;
import com.example.kakeibo.presentation.dto.CreateCategoryRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	private final CreateCategoryUseCase createCategoryUseCase;
	private final ListCategoriesUseCase listCategoriesUseCase;
	private final DeleteCategoryUseCase  deleteCategoryUseCase;
	
	
	
	public CategoryController(
			CreateCategoryUseCase createCategoryUseCase,
			ListCategoriesUseCase listCategoriesUseCase,
			DeleteCategoryUseCase  deleteCategoryUseCase
			) {
		this.createCategoryUseCase = createCategoryUseCase;
		this.listCategoriesUseCase = listCategoriesUseCase;
		this.deleteCategoryUseCase = deleteCategoryUseCase;
	}
	@PostMapping
	public ResponseEntity<CategoryResponse> create(
			@Valid @RequestBody CreateCategoryRequest request
			)
	{
		Category category = createCategoryUseCase.execute(request.getName());
		
		CategoryResponse response = CategoryResponse.from(category);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryResponse>> list(
			){
		
		List<Category> category = listCategoriesUseCase.execute();
		
		List<CategoryResponse> response = category.stream()
								.map(CategoryResponse::from)
								.collect(Collectors.toList());
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		deleteCategoryUseCase.execute(id);
		return ResponseEntity.noContent().build();
		
	}
}
