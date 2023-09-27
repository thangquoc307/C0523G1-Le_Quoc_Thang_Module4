package com.demo.service;

import com.demo.model.Book;

import java.util.List;

public interface IBookService {
    void createBook(Book book);
    void update(Book book);
    List<Book> getAllBook();
    void deleteBookById(int id);
    Book getById(int id);
}
