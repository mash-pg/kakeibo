package com.example.kakeibo.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kakeibo.infrastructure.jpa.TransactionJpaEntity;



interface TransactionJpaRepository extends JpaRepository<TransactionJpaEntity, Long> {

}
