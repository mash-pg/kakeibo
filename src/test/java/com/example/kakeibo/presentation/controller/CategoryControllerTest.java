package com.example.kakeibo.presentation.controller;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.kakeibo.application.usecase.CreateCategoryUseCase;
import com.example.kakeibo.application.usecase.DeleteCategoryUseCase;
import com.example.kakeibo.application.usecase.ListCategoriesUseCase;
import com.example.kakeibo.domain.entity.Category;
import com.example.kakeibo.domain.valueobject.CategoryId;
import com.example.kakeibo.domain.valueobject.CategoryName;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
    @MockitoBean
	private CreateCategoryUseCase createCategoryUseCase;
    
    @MockitoBean
    private  ListCategoriesUseCase listCategoriesUseCase; 
    
    @MockitoBean
    private  DeleteCategoryUseCase deleteCategoryUseCase;
    
    @Test
    void カテゴリ削除で204が返る() throws Exception{
        mockMvc.perform(delete("/api/categories/1"))
        .andExpect(status().isNoContent());  // 2
    	
    	verify(deleteCategoryUseCase).execute(1L);
    }
    
    @Test
    void カテゴリ作成で201が返る() throws Exception{
    	Category category = new Category(new CategoryId(1L),new CategoryName("食費"));
    	when(createCategoryUseCase.execute("食費")).thenReturn(category);
    	
    	
    	mockMvc.perform(post("/api/categories")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content("{\"name\": \"食費\"}"))
    			.andExpect(status().isCreated());
    }
}
