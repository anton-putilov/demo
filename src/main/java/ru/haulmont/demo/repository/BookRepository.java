package ru.haulmont.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.haulmont.demo.entity.Book;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
