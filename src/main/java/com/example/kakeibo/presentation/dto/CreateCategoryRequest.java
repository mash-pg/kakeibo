package com.example.kakeibo.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateCategoryRequest {
	
	@NotBlank(message="カテゴリは必須です")
	@Size(max = 50,message = "カテゴリ名は50文字以内です")
	private String name;
	
}
