package com.example.kakeibo.domain.valueobject;


public class CategoryId {
	private final Long value;
	
	public CategoryId(Long value) {
		if(value == null) {
			throw new IllegalArgumentException("カテゴリIDを設定してください");
		}
		
		this.value =value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
