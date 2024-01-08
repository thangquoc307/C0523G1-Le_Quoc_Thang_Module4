package com.demo.repository;

import com.demo.model.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INewsRepository extends JpaRepository<NewsEntity, Integer> {
    List<NewsEntity> findNewsEntitiesByTitleContaining(String key);
}
