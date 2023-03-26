package ru.vyrostkov.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vyrostkov.project1.models.Book;
import ru.vyrostkov.project1.models.Person;

import java.util.List;
import java.util.Optional;

/**
 * Created by @m.vyrostkov on 23.03.2023 21:35
 */
@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

       @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooks() {
        return jdbcTemplate.query("SELECT * FROM Book ORDER BY id ASC", new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book){
        jdbcTemplate.update("INSERT INTO Book(bookname, first_name_author, last_name_author, middle_name_author, year_of_publishing) VALUES(?, ?, ?, ?, ?)", book.getBookName(), book.getFirstNameAuthor(),
                book.getLastNameAuthor(), book.getMiddleNameAuthor(), book.getYearOfPublishing());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET bookname=?, first_name_author=?, last_name_author=?, middle_name_author=?, year_of_publishing=? WHERE id=?", updatedBook.getBookName(), updatedBook.getFirstNameAuthor(),
                updatedBook.getLastNameAuthor(), updatedBook.getMiddleNameAuthor(), updatedBook.getYearOfPublishing(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.id " +
                        "WHERE Book.id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }

    public void release(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=NULL WHERE id=?", id);
    }

    public void assign(int id, Person selectedPerson) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", selectedPerson.getId(), id);
    }
}
