package ru.vyrostkov.ElectronicLibraryWithBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyrostkov.ElectronicLibraryWithBoot.models.Book;


import java.util.List;

/**
 * Created by @m.vyrostkov on 01.04.2023 21:53
 */
@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findByBookNameStartingWith(String bookName);

    Book findByBookName(String bookName);

}
