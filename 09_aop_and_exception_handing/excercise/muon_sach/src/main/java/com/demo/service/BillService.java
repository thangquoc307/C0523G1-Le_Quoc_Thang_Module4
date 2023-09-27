package com.demo.service;

import com.demo.model.Bill;
import com.demo.repository.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillService implements IBillService{
    @Autowired
    private IBillRepository billRepository;
    @Override
    public List<Bill> showAllBill() {
        return billRepository.findAll();
    }

    @Override
    public void createBill(Bill bill) {
        billRepository.save(bill);

    }

    @Override
    public void deleteBillByCode(String code) {
        billRepository.deleteById(code);
    }

    @Override
    public Bill findByCode(String code) {
        return billRepository.findById(code).get();
    }
}
