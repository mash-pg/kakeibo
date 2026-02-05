package com.example.kakeibo.domain.factory;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.valueobject.Amount;
import com.example.kakeibo.domain.valueobject.CategoryId;
import com.example.kakeibo.domain.valueobject.TransactionType;

public class TransactionFactory {
	public static Transaction create(
			
			TransactionType type,
			Amount amount,
			CategoryId categoryId,
			String description,
			LocalDate transactionDate
			) {
			
			//生成ルールを一か所に集約
			LocalDate date = (transactionDate != null)
					? transactionDate : LocalDate.now();
		
		return new Transaction(
					null, 
					amount, 
					type, 
					categoryId, 
					description, 
					date,
					LocalDateTime.now()
				);
		
	}
}
