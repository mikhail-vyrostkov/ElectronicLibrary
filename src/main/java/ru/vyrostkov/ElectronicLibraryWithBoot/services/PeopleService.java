package ru.vyrostkov.ElectronicLibraryWithBoot.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vyrostkov.ElectronicLibraryWithBoot.models.Book;
import ru.vyrostkov.ElectronicLibraryWithBoot.models.Person;
import ru.vyrostkov.ElectronicLibraryWithBoot.repositories.PeopleRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by @m.vyrostkov on 01.04.2023 21:54
 */
@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findById(int id) {
        Optional<Person> person = peopleRepository.findById(id);
        return person.orElse(null);
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatePerson){
        Optional<Person> person = peopleRepository.findById(id);
        if (person.isPresent()){
            updatePerson.setId(id);
            peopleRepository.save(updatePerson);
        }
    }

    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);
    }

    public List<Book> getBooksByPersonId(int id) {
        Optional<Person> person = peopleRepository.findById(id);

        if (person.isPresent()) {
            Hibernate.initialize(person.get().getBooks());
            // Проверка просроченности книг
            person.get().getBooks().forEach(book -> {
                long diffInMillies = Math.abs(book.getTakenAt().getTime() - new Date().getTime());
                // 864000000 милисекунд = 10 суток
                if (diffInMillies > 864000000)
                    book.setExpired(true); // книга просрочена
            });

            return person.get().getBooks();
        }
        else {
            return Collections.emptyList();
        }
    }

}
