package com.demo.service;

import com.demo.model.Bill;
import com.demo.model.Book;

import java.util.List;

public interface IBillService {
    List<Bill> showAllBill();
    String createBill(Book book);
    void deleteBillByCode(String code);
    Bill findByCode(String code);
    List<String> getAllHireCode();
    String getHireCode();
}
