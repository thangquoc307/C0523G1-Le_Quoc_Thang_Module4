package com.demo.controller;

import com.demo.model.Bill;
import com.demo.model.Book;
import com.demo.service.IBillService;
import com.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private static List<String> hireCodeList = new ArrayList<>();
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBillService iBillService;
    @GetMapping("/")
    public String showAllBook(Model model){
        model.addAttribute("books",iBookService.getAllBook());
        return "index";
    }
    @GetMapping("/hire/{id}")
    @Transactional
    public String hire(@PathVariable int id,
                       RedirectAttributes redirectAttributes){
        Book book = iBookService.getById(id);
        book.setQuality(book.getQuality() - 1);

        String hireCode = iBillService.createBill(book);
        iBookService.update(book);

        redirectAttributes.addFlashAttribute("numberRandom", hireCode);
        return "redirect:/";
    }
    @GetMapping("/returnBook")
    @Transactional
    public String returnBook(@RequestParam(defaultValue = "", required = false) String code,
                             RedirectAttributes redirectAttributes){

        if (!hireCodeList.contains(code)){
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
}
