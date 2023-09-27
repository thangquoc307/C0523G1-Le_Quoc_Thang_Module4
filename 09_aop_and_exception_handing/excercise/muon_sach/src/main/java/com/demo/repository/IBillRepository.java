package com.demo.repository;

import com.demo.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepository extends JpaRepository<Bill, String> {
}
