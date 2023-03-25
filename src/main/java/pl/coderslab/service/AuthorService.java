package pl.coderslab.service;

import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorService {
    void save(Author author);

    Author findById(Long authorId);

    List<Author> findAll();

    void update(Author author);

    void deleteById(Long authorId);
}
