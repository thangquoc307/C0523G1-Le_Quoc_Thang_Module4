package com.blogresrful.repository;

import com.blogresrful.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
