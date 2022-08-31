package ru.haulmont.demo.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.haulmont.demo.entity.Book;
import ru.haulmont.demo.repository.BookRepository;
import ru.haulmont.demo.service.BookService;

import java.util.*;

@Service("BookService")
@Profile("dev")
public class BookServiceImplDev implements BookService {
    @Value("${book.custom.man}")
    private String myConfig;

    private final BookRepository bookRepository;

    public BookServiceImplDev(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {

        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setName("StabBook");
        book.setYear(1984);
        book.setMan(myConfig);

        return List.of(book);
    }

    @Override
    public void createBook(String name, int date, String man) {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setName(name);
        book.setYear(date);
        book.setMan(man);

        bookRepository.save(book);
    }
}
