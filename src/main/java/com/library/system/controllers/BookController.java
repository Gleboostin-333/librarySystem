package com.library.system.controllers;


import com.library.system.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> books = new ArrayList<>();

     @PostConstruct
    public void RestCreateBook() {
        books.addAll(List.of(
                 new Book(1L, "Капитанская дочка", "Александр Пушкин", "Историческая повесть о крестьянской войне под предводительством Пугачёва.", 350.0),
                 new Book(2L, "Герой нашего времени", "Михаил Лермонтов", "Роман в новеллах о сложной личности Печорина.", 400.0),
                 new Book(3L, "Ревизор", "Николай Гоголь", "Комедия о чиновничьем произволе и глупости.", 300.0),
                 new Book(4L, "Муму", "Иван Тургенев", "Трогательный рассказ о глухонемом крепостном и его собаке.", 200.0),
                 new Book(5L, "После бала", "Лев Толстой", "Морально-философский рассказ о влиянии власти и насилия.", 220.0),
                 new Book(6L, "Хамелеон", "Антон Чехов", "Юмористический рассказ о приспособленчестве и лицемерии.", 150.0),
                 new Book(7L, "Толстый и тонкий", "Антон Чехов", "Сатирический рассказ о сословных различиях и раболепии.", 150.0),
                 new Book(8L, "Чучело", "Владислав Крапивин", "Рассказ о школьной травле и нравственном выборе.", 280.0),
                 new Book(9L, "Судьба человека", "Михаил Шолохов", "История советского солдата, прошедшего через войну и плен.", 320.0),
                 new Book(10L, "Матренин двор", "Александр Солженицын", "Рассказ о тяжёлой жизни простой русской женщины.", 360.0)

        ));;
    }

    @GetMapping
    Iterable<Book> getUsers() {
        return books;
    }
}
