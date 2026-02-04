package com.example.kakeibo.domain.entity;

import com.example.kakeibo.domain.valueobject.CategoryId;
import com.example.kakeibo.domain.valueobject.CategoryName;

public class Category {
	
	private final CategoryId id;
	private CategoryName name;
	
	public Category(CategoryId id,CategoryName name) {
		this.id = id;
		this.name = name;
	}
	
	public CategoryId getId() {
		return this.id;
	}
	
	public CategoryName getName() {
		return this.name;
	}
}
