package com.blog_ajax.repository;

import com.blog_ajax.model.BlogEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<BlogEntity, Integer> {
    List<BlogEntity> findBlogEntityByTitleContaining(String keyword);
}
