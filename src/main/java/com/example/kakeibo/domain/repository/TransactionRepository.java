package com.example.kakeibo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.valueobject.CategoryId;
import com.example.kakeibo.domain.valueobject.TransactionId;

public interface TransactionRepository {
	Transaction save(Transaction transaction);
	
	//nullデータが入る可能性がある
	Optional<Transaction> findById(TransactionId id);
	
	//Listで受け取る
	List<Transaction> findAll();
	
	//削除処理のみ
	void deleteById(TransactionId id);
	
	//あるかどうかの確認
	boolean existsByCategoryId(CategoryId id);
	
}
