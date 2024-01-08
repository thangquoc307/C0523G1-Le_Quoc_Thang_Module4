package com.test.repository;

import com.test.model.PigEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPigRepository extends JpaRepository<PigEntity, Integer> {
}
