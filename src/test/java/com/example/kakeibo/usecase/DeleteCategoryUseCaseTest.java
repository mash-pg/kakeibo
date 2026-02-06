package com.example.kakeibo.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.kakeibo.application.usecase.DeleteCategoryUseCase;
import com.example.kakeibo.domain.entity.Category;
import com.example.kakeibo.domain.exception.CategoryInUseException;
import com.example.kakeibo.domain.exception.CategoryNotFoundException;
import com.example.kakeibo.domain.repository.CategoryRepository;
import com.example.kakeibo.domain.repository.TransactionRepository;
import com.example.kakeibo.domain.valueobject.CategoryId;
import com.example.kakeibo.domain.valueobject.CategoryName;

public class DeleteCategoryUseCaseTest {
	private CategoryRepository categoryRepository;
	private TransactionRepository transactionRepository;
	private DeleteCategoryUseCase useCase; 
	
	
	@BeforeEach
	void setup() {
		categoryRepository = mock(CategoryRepository.class);
		transactionRepository = mock(TransactionRepository.class);
		useCase = new DeleteCategoryUseCase(transactionRepository, categoryRepository);	
	}
	@Test
	@DisplayName("Categoryを削除できる")
	void 正常に削除できる() {
		  //１．カテゴリが見つかる状態を作る
	      Category category = new Category(new CategoryId(1L), new CategoryName("食費"));
	      //２. モックの振る舞いを定義
		  when(categoryRepository.findById(any())).thenReturn(Optional.of(category));

		  //３. テスト対象を実行
		  useCase.execute(1L);

		  //４. 検証（メソッドが呼ばれたか確認）
		  verify(categoryRepository).deleteById(any());
	}
	
	
	  @Test
	  @DisplayName("カテゴリが存在しない場合は例外")
	  void カテゴリが存在しない場合は例外() {
		  
	      // findById が Optional.empty() を返す
	      when(categoryRepository.findById(any())).thenReturn(Optional.empty());
		  // → CategoryNotFoundException が発生することを確認
	      assertThrows(CategoryNotFoundException.class,
	    	      () -> useCase.execute(1L));
	  }

	  @Test
	  @DisplayName("カテゴリが使用中の場合は例外")
	  void カテゴリが使用中の場合は例外() {
	      // findById が Optional.of(category) を返す
	      Category category = new Category(new CategoryId(1L), new CategoryName("食費"));
	      
	      when(categoryRepository.findById(any())).thenReturn(Optional.of(category));
	      when(transactionRepository.existsByCategoryId(any())).thenReturn(true);
	      // existsByCategoryId が true を返す
	      assertThrows(CategoryInUseException.class,
	    	      () -> useCase.execute(1L));    
	      // → CategoryInUseException が発生することを確認
	  }
}
