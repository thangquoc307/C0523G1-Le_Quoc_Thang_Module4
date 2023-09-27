package com.demo.service;

import com.demo.model.Bill;

import java.util.List;

public interface IBillService {
    List<Bill> showAllBill();
    void createBill(Bill bill);
    void deleteBillByCode(String code);
    Bill findByCode(String code);
}
