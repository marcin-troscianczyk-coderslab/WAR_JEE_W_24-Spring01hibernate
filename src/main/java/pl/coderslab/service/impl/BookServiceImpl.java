package pl.coderslab.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final PublisherService publisherService;

    public BookServiceImpl(BookDao bookDao, PublisherService publisherService) {
        this.bookDao = bookDao;
        this.publisherService = publisherService;
    }

    @Override
    public void save(Book book) {

        final Publisher publisher = book.getPublisher();
        publisherService.save(publisher);

        bookDao.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookDao.findById(id);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void deleteById(Long id) {
        bookDao.deleteById(id);
    }
}
