package com.example.kakeibo.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kakeibo.infrastructure.jpa.CategoryJpaEntity;


interface CategoryJpaRepository extends JpaRepository<CategoryJpaEntity, Long> {
	boolean existsByName(String name);
}
