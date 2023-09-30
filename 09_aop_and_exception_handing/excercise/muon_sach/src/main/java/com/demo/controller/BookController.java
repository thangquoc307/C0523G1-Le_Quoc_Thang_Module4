package com.demo.controller;

import com.demo.model.Bill;
import com.demo.model.Book;
import com.demo.service.IBillService;
import com.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class BookController {
    private static List<String> listRandomNumber = new ArrayList<>();
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBillService iBillService;
    @GetMapping("/")
    public String showAllBook(Model model){
        updateRandomNumberList();
        model.addAttribute("books",iBookService.getAllBook());
        return "index";
    }
    @GetMapping("/hire/{id}")
    public String hire(@PathVariable int id,
                       RedirectAttributes redirectAttributes){

        Book book = iBookService.getById(id);

        //tạo exception
        System.out.println(1 / book.getQuality());

        String numberRandom = randomNumber();
        book.setQuality(book.getQuality() - 1);
        iBookService.update(book);
        Bill bill = new Bill(numberRandom, book);
        iBillService.createBill(bill);

        redirectAttributes.addFlashAttribute("numberRandom", numberRandom);
        return "redirect:/";
    }
    @GetMapping("/returnBook")
    public String returnBook(@RequestParam(defaultValue = "", required = false) String code,
                             RedirectAttributes redirectAttributes){
        System.out.println(listRandomNumber);
        if (!listRandomNumber.contains(code)){
            redirectAttributes.addFlashAttribute("messageFail",
                    "Không tìm thấy lịch sử mượn sách này");
            return "redirect:/";
        } else {
            Bill bill = iBillService.findByCode(code);
            Book book = bill.getBook();
            book.setQuality(book.getQuality() + 1);
            iBookService.update(book);
            iBillService.deleteBillByCode(code);
            return "redirect:/";
        }
    }
    private String randomNumber(){
        String i;
        while (true) {
            i = new Random().nextInt(100000) + "";
            switch (i.length()) {
                case 1:
                    i = "0000" + i;
                    break;
                case 2:
                    i = "000" + i;
                    break;
                case 3:
                    i = "00" + i;
                    break;
                case 4:
                    i = "0" + i;
                    break;
            }
            if (!listRandomNumber.contains(i)){
                break;
            }
        }
        return i;
    }
    private void updateRandomNumberList(){
        List<Bill> list = iBillService.showAllBill();
        List<String> stringList = new ArrayList<>();
        for (Bill bill : list){
            stringList.add(bill.getNumberRandom());
        }
        listRandomNumber = stringList;
    }
}
