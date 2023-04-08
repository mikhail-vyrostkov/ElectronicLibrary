package ru.vyrostkov.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyrostkov.project1.models.Book;
import ru.vyrostkov.project1.models.Person;

import java.util.List;

/**
 * Created by @m.vyrostkov on 01.04.2023 21:53
 */
@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findByBookNameStartingWith(String bookName);

    Book findByBookName(String bookName);

}
