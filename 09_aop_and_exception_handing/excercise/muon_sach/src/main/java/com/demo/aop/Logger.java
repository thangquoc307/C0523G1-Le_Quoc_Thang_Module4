package com.demo.aop;

import com.demo.model.Bill;
import com.demo.model.Book;
import com.demo.service.IBillService;
import com.demo.service.IBookService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class Logger {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBillService iBillService;
    private List<String> log = new ArrayList<>();
    @AfterReturning(value = "execution(* com.demo.controller.BookController.hire(..))")
    public void writeHireBook(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Book book = iBookService.getById((Integer) args[0]);
        String detailLog = "Cho mượn : " + book.getName();
        log.add(detailLog);
        System.out.println(log);
    }
    @Around("execution(* com.demo.controller.BookController.returnBook(..))")
    public Object writeReturnBook(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        Bill bill = iBillService.findByCode((String) args[0]);
        Book book = bill.getBook();
        String detailLog = "Trả sách : " + book.getName();

        Object proceed = proceedingJoinPoint.proceed();

        log.add(detailLog);
        System.out.println(log);
        return proceed;
    }
}
