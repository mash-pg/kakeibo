package com.example.kakeibo.presentation.dto;


import com.example.kakeibo.domain.entity.Category;

import lombok.Getter;

@Getter
public class CategoryResponse {
	private Long id;
	private String name;
	
	public static CategoryResponse from(Category category) {
		CategoryResponse response = new CategoryResponse();
		response.id = (category.getId() != null) ? category.getId().getValue() : null;
		response.name = category.getName().getValue();
		return response;
	}
}
