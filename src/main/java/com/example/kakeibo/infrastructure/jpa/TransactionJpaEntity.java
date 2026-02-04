package com.example.kakeibo.infrastructure.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.kakeibo.domain.valueobject.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "transactions")  
public class TransactionJpaEntity {
	@Id  // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // DBが自動でIDを振る
	private Long id;
	
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)  // Enumを文字列で保存。これがないと0,1の数字になる
	private TransactionType type;
	
	@Column(nullable = false)
	private int amount;
	
	@Column(nullable = false,name = "category_id")
	private Long categoryId;
	
	@Column(nullable = true)  
	private String description;// IS NULL、文字数無制限
	
	@Column(nullable = false,name = "transaction_date")
	private LocalDate transactionDate;
	
	@Column(nullable = true,name = "created_at")
	private LocalDateTime createdAt;
	
	
	public TransactionJpaEntity() {}
	public TransactionJpaEntity(Long id,TransactionType type,Long categoryId,
			int amount,String description,LocalDate transactionDate,
			LocalDateTime createdAt
			) {
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.categoryId = categoryId;
		this.description = description;
		this.transactionDate = transactionDate;
		this.createdAt = createdAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	
}
