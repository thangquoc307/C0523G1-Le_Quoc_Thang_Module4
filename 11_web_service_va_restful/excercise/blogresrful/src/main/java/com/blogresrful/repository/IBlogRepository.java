package com.blogresrful.repository;

import com.blogresrful.model.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<BlogEntity, Integer> {
    List<BlogEntity> getBlogEntitiesByCategory_Id(Integer id);
}
