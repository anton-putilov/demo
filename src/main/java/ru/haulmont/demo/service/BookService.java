package ru.haulmont.demo.service;

import ru.haulmont.demo.Dto.BookDto;
import ru.haulmont.demo.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();
    void createBook(String name, int date, String man);
}
