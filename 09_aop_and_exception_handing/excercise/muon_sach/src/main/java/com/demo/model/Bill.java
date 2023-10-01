package com.demo.model;

import javax.persistence.*;

@Entity
public class Bill {
    @Id
    @Column(unique = true, nullable = false)
    private String hireCode;
    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public Bill(String hireCode, Book book) {
        this.hireCode = hireCode;
        this.book = book;
    }

    public Bill() {
    }

    public String getHireCode() {
        return hireCode;
    }

    public void setHireCode(String hireCode) {
        this.hireCode = hireCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
