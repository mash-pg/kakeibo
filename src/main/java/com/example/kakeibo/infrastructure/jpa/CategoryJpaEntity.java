package com.example.kakeibo.infrastructure.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "categories")  
public class CategoryJpaEntity {
	@Id  // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // DBが自動でIDを振る
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String name;
	public CategoryJpaEntity() {}
	public CategoryJpaEntity(Long id,String name) {
		this.id =id;
		this.name = name;
	}
	
	//Getter
	public Long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
