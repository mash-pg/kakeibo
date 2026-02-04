package com.example.kakeibo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.kakeibo.domain.entity.Category;
import com.example.kakeibo.domain.valueobject.CategoryId;
import com.example.kakeibo.domain.valueobject.CategoryName;

public interface CategoryRepository {
	Category save(Category category);
	
	//nullデータが入る可能性がある
	Optional<Category> findById(CategoryId id);
	
	//Listで受け取る
	List<Category> findAll();
	
	//削除処理のみ
	void deleteById(CategoryId id);
	
	//あるかどうかの確認
	boolean existsByName(CategoryName name);
	
}
