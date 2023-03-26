package ru.vyrostkov.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vyrostkov.project1.models.Book;
import ru.vyrostkov.project1.models.Person;

import java.util.List;

/**
 * @author Mikhail Vyrostkov
 */
@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person ORDER BY id ASC", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(lastname, firstname, middlename, birthday, email, phone, photo) VALUES(?, ?, ?, ?, ?, ?, ?)", person.getLastName(), person.getFirstName(), person.getMiddleName(),
                person.getBirthday(), person.getEmail(), person.getPhone(),person.getPhoto());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET lastname=?, firstname=?, middlename=?, birthday=?, email=?, phone=?, photo=? WHERE id=?", updatedPerson.getLastName(), updatedPerson.getFirstName(), updatedPerson.getMiddleName(),
                updatedPerson.getBirthday(), updatedPerson.getEmail(), updatedPerson.getPhone(),updatedPerson.getPhoto(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    public List<Book> getBookByPersonId(int id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }
}
