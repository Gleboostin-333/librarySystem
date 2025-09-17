package com.library.system.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private Long id;
    private String title;
    private String author;
    private String description;
    private Double price;


    public Book(Long id, String title, String author, String description, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
    }
}
