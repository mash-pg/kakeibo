package com.example.kakeibo.domain.valueobject;

import com.example.kakeibo.domain.exception.InvalidCategoryException;

public class CategoryName {
	private final String value;
	public CategoryName(String value) {
		
		if(value == null ) {
			throw new InvalidCategoryException("空文字が入っています");
		}
		
		if(value.isEmpty() || value.length() > 50) {
			throw new InvalidCategoryException("最大50文字までまたは空文字です" + value);
		}
		
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
