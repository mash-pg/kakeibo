package com.example.kakeibo.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.domain.repository.TransactionRepository;
import com.example.kakeibo.domain.valueobject.Amount;
import com.example.kakeibo.domain.valueobject.CategoryId;
import com.example.kakeibo.domain.valueobject.TransactionId;
import com.example.kakeibo.infrastructure.jpa.TransactionJpaEntity;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{
	private final TransactionJpaRepository jpaRepository;
	
	public TransactionRepositoryImpl(TransactionJpaRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public Transaction save(Transaction transaction) {
		TransactionJpaEntity jpaEntity = toJpaEntity(transaction);
		TransactionJpaEntity savedEntity = jpaRepository.save(jpaEntity);
		
		return toDomainEntity(savedEntity);
	}



	@Override
	public Optional<Transaction> findById(TransactionId id) {
		// TODO Auto-generated method stub
		return jpaRepository.findById(id.getValue()).map(this::toDomainEntity);
	}



	@Override
	public List<Transaction> findAll() {
		return jpaRepository.findAll().stream()
				.map(this::toDomainEntity)
				.collect(Collectors.toList());
	}



	@Override
	public void deleteById(TransactionId id) {
		jpaRepository.deleteById(id.getValue());
		
	}


	@Override
	public boolean existsByCategoryId(CategoryId id) {
		boolean isNameFlag = jpaRepository.existsById(id.getValue());
		return isNameFlag;
	}



	private TransactionJpaEntity toJpaEntity(Transaction transaction) {
		TransactionJpaEntity entity = new TransactionJpaEntity();
		if(transaction.getId() != null) {
			entity.setId(transaction.getId().getValue());
		}
		entity.setType(transaction.getType());
		entity.setAmount(transaction.getAmount().getValue());
		entity.setCategoryId(transaction.getCategoryId().getValue());
		entity.setDescription(transaction.getDescription());
		entity.setTransactionDate(transaction.getTransactionDate());
		entity.setCreatedAt(transaction.getCreatedAt());
		return entity;
	}
	
	private Transaction toDomainEntity(TransactionJpaEntity jpaEntity) {
		return new Transaction(
			new TransactionId(jpaEntity.getId()),
			new Amount(jpaEntity.getAmount()),
			jpaEntity.getType(),
			new CategoryId(jpaEntity.getCategoryId()),
			jpaEntity.getDescription(),
			jpaEntity.getTransactionDate(),
			jpaEntity.getCreatedAt()
		);
	}
}
