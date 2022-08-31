package ru.haulmont.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.haulmont.demo.Dto.BookDto;
import ru.haulmont.demo.entity.Book;
import ru.haulmont.demo.service.BookService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Value("${book.custom.man}")
    private String myConfig;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/all")
    public List<BookDto> getAllBooks(){
        List<Book> books = bookService.getBooks();
        List<BookDto> bookDtoList = new ArrayList<>();
        books.forEach(book -> {
            BookDto bookDto = new BookDto();
            bookDto.setId(book.getId());
            bookDto.setName(book.getName());
            bookDto.setYear(book.getYear());
            bookDto.setMan(myConfig);
            bookDtoList.add(bookDto);
        });
        return bookDtoList;
    }

    @RequestMapping("/create")
    public void crateBook(@RequestParam String name, int year, String man){
        bookService.createBook(name, year, man);
    }
}
