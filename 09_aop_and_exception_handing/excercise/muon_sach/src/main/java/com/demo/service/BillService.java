package com.demo.service;

import com.demo.model.Bill;
import com.demo.model.Book;
import com.demo.repository.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BillService implements IBillService{
    @Autowired
    private IBillRepository billRepository;
    @Override
    public List<Bill> showAllBill() {
        return billRepository.findAll();
    }

    @Override
    @Transactional
    public String createBill(Book book) {
        System.out.println(1 / book.getQuality());

        String hireCode = getHireCode();
        Bill bill = new Bill(hireCode, book);
        billRepository.save(bill);

        return hireCode;
    }

    @Override
    public void deleteBillByCode(String code) {
        billRepository.deleteById(code);
    }

    @Override
    public Bill findByCode(String code) {
        return billRepository.findById(code).get();
    }

    @Override
    public List<String> getAllHireCode() {
        List<Bill> list = showAllBill();
        List<String> hireCodeList = new ArrayList<>();
        for (Bill bill : list){
            hireCodeList.add(bill.getHireCode());
        }
        return hireCodeList;
    }

    @Override
    public String getHireCode() {
        String i;
        while (true) {
            i = new Random().nextInt(100000) + "";
            for (int k = 0; k < 4 - i.length(); k++){
                i = "0" + i;
            }
            if (!getAllHireCode().contains(i)){
                break;
            }
        }
        return i;
    }
}
