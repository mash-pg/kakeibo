package com.example.kakeibo.domain.valueobject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.kakeibo.domain.exception.InvalidCategoryException;

public class CategoryNameTest {
	/*
	
    - カテゴリ名がnull null　InvalidCategoryException
    - カテゴリ名が空文字 ""　InvalidCategoryException
    - カテゴリ名が1文字の時　1 正常
    - カテゴリ名が50文字の時 50 正常
    - カテゴリ名が51文字の時 51　InvalidCategoryException
	 * */
	
	@Test
	@DisplayName("カテゴリ名がnull")
	void カテゴリ名がnull(){
		String input = null;
		
		assertThrows(InvalidCategoryException.class,
				()-> new CategoryName(input));
	}
	
	@Test
	@DisplayName("カテゴリ名が空文字")
	void カテゴリ名が空文字(){
		String input = "";
		
		assertThrows(InvalidCategoryException.class,
				()-> new CategoryName(input));
	}
	@Test
	@DisplayName("カテゴリ名が51文字")
	void カテゴリ名が51文字(){
		String input = "a".repeat(51);
		
		assertThrows(InvalidCategoryException.class,
				()-> new CategoryName(input));
	}
	
	@Test
	@DisplayName("カテゴリ名が1文字の場合")
	void カテゴリ名が1文字の場合(){
		String input = "a";
		CategoryName categoryName = new CategoryName(input);
		
		assertEquals(input, categoryName.getValue());
	}
	
	@Test
	@DisplayName("カテゴリ名が50文字の場合")
	void カテゴリ名が50文字の場合(){
		String input = "a".repeat(50);
		CategoryName categoryName = new CategoryName(input);
		
		assertEquals(input, categoryName.getValue());
	}
	
}
