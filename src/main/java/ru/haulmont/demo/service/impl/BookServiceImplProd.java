package ru.haulmont.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.haulmont.demo.entity.Book;
import ru.haulmont.demo.repository.BookRepository;
import ru.haulmont.demo.service.BookService;

import java.util.List;
import java.util.UUID;

@Service("BookService")
@Profile("prod")
public class BookServiceImplProd implements BookService {

    private final BookRepository bookRepository;
    
    public BookServiceImplProd(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void createBook(String name, int year, String man) {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setName(name);
        book.setYear(year);
        book.setMan(man);

        bookRepository.save(book);
    }
}
