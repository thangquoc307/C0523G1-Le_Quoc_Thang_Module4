package com.demo.repository;

import com.demo.model.NewsTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INewsType extends JpaRepository<NewsTypeEntity, Integer> {
}
