package pl.coderslab.service;

import pl.coderslab.entity.Publisher;

import java.util.List;

public interface PublisherService {
    void save(Publisher publisher);

    Publisher findById(Long id);

    List<Publisher> findAll();
    List<pl.coderslab.model.Publisher> findAllPublisherModel();

    void update(Publisher publisher);

    void deleteById(Long id);
}
