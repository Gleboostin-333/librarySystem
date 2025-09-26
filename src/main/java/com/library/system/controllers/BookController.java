package com.library.system.controllers;


import com.library.system.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> books = new ArrayList<>();

     @PostConstruct
    public void RestCreateBook() {
        books.addAll(List.of(
                 new Book(1, "Капитанская дочка", "Александр Пушкин", "Историческая повесть о крестьянской войне под предводительством Пугачёва.", 350.0),
                 new Book(2, "Герой нашего времени", "Михаил Лермонтов", "Роман в новеллах о сложной личности Печорина.", 400.0),
                 new Book(3, "Ревизор", "Николай Гоголь", "Комедия о чиновничьем произволе и глупости.", 300.0),
                 new Book(4, "Муму", "Иван Тургенев", "Трогательный рассказ о глухонемом крепостном и его собаке.", 200.0),
                 new Book(5, "После бала", "Лев Толстой", "Морально-философский рассказ о влиянии власти и насилия.", 220.0),
                 new Book(6, "Хамелеон", "Антон Чехов", "Юмористический рассказ о приспособленчестве и лицемерии.", 150.0),
                 new Book(7, "Толстый и тонкий", "Антон Чехов", "Сатирический рассказ о сословных различиях и раболепии.", 150.0),
                 new Book(8, "Чучело", "Владислав Крапивин", "Рассказ о школьной травле и нравственном выборе.", 280.0),
                 new Book(9, "Судьба человека", "Михаил Шолохов", "История советского солдата, прошедшего через войну и плен.", 320.0),
                 new Book(10, "Матренин двор", "Александр Солженицын", "Рассказ о тяжёлой жизни простой русской женщины.", 360.0)

        ));;
    }

    @GetMapping
    Iterable<Book> getUsers() {
        return books;
    }

    @GetMapping("/{id}")
    Optional<Book> getBookById(@PathVariable String id) {

        Integer idL = Integer.parseInt(id);

        for (Book user : books) {

            if (user.getId().equals(idL)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

    @PostMapping
    Book createUser(@RequestBody Book book) {
        books.add(book);
        return book;
    }
}
