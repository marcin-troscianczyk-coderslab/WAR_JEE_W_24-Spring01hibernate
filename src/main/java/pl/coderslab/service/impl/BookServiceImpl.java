package pl.coderslab.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final PublisherService publisherService;


    private final AuthorService authorService;

    public BookServiceImpl(BookDao bookDao, PublisherService publisherService, AuthorService authorService) {
        this.bookDao = bookDao;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @Override
    public void save(Book book) {

        final Publisher publisher = book.getPublisher();
        publisherService.save(publisher);

        List<Author> authors = new ArrayList<>();
        authors.add(authorService.findById(1l));
        authors.add(authorService.findById(2l));
        //book.setAuthors(authors);

        bookDao.save(book);
    }

    @Override
    public void save(pl.coderslab.model.Book book) {

        Book bookEntity = new Book();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setDescription(book.getDescription());
        bookEntity.setRating(book.getRating());

        Publisher publisher = new Publisher();
        publisher.setId(book.getPublisher().getId());

        bookEntity.setPublisher(publisher);

        bookDao.save(bookEntity);

        book.setId(bookEntity.getId());
    }

    @Override
    public Book findById(Long id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findAllByRating(int rating) {
        return bookDao.findByRating(rating);
    }

    @Override
    public List<Book> findByPublisherIsNotNull() {
        return bookDao.findByPublisherIsNotNull();
    }

    @Override
    public List<Book> findByPublisher(Publisher publisher) {
        return bookDao.findByPublisher(publisher);
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        return bookDao.findByAuthor(author);
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
