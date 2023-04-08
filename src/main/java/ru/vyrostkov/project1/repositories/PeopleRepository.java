package ru.vyrostkov.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyrostkov.project1.models.Person;

/**
 * Created by @m.vyrostkov on 01.04.2023 21:49
 */
@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
