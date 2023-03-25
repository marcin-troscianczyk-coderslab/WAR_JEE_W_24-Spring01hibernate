package pl.coderslab.service;

import pl.coderslab.entity.Person;

import java.util.List;

public interface PersonService {
    void save(Person person);

    Person findById(Long id);

    List<Person> findAll();

    void update(Person person);

    void deleteById(Long id);
}
