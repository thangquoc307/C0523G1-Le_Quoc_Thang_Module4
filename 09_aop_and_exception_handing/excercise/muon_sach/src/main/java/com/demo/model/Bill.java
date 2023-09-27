package com.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Bill {
    @Id
    @Column(unique = true, nullable = false)
    private String numberRandom;
    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public Bill(String numberRandom, Book book) {
        this.numberRandom = numberRandom;
        this.book = book;
    }

    public Bill() {
    }

    public String getNumberRandom() {
        return numberRandom;
    }

    public void setNumberRandom(String numberRandom) {
        this.numberRandom = numberRandom;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
