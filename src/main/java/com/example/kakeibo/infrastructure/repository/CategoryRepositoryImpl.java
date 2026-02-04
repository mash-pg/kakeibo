package com.example.kakeibo.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.kakeibo.domain.entity.Category;
import com.example.kakeibo.domain.repository.CategoryRepository;
import com.example.kakeibo.domain.valueobject.CategoryId;
import com.example.kakeibo.domain.valueobject.CategoryName;
import com.example.kakeibo.infrastructure.jpa.CategoryJpaEntity;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{
	private final CategoryJpaRepository jpaRepository;
	
	public CategoryRepositoryImpl(CategoryJpaRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public Category save(Category category) {
		CategoryJpaEntity jpaEntity = toJpaEntity(category);
		CategoryJpaEntity savedEntity = jpaRepository.save(jpaEntity);
		return toDomainEntity(savedEntity);
	}

	@Override
	public Optional<Category> findById(CategoryId id) {
		// TODO Auto-generated method stub
		return jpaRepository.findById(id.getValue()).map(this::toDomainEntity);
	}

	@Override
	public List<Category> findAll() {
		return jpaRepository.findAll().stream()
				.map(this::toDomainEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(CategoryId id) {
		jpaRepository.deleteById(id.getValue());
	}

	@Override
	public boolean existsByName(CategoryName name) {
		boolean isNameFlag = jpaRepository.existsByName(name.getValue());
		return isNameFlag;
	}

	private CategoryJpaEntity toJpaEntity(Category category) {
		CategoryJpaEntity entity = new CategoryJpaEntity();
		if(category.getId() != null) {
			entity.setId(category.getId().getValue());
		}
		entity.setName(category.getName().getValue());
		return entity;
	}
	
	private Category toDomainEntity(CategoryJpaEntity jpaEntity) {
		return new Category(
			new CategoryId(jpaEntity.getId()),
			new CategoryName(jpaEntity.getName())
		);
	}




	

}
