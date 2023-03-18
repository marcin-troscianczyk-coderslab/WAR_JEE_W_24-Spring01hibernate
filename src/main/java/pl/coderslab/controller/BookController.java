package pl.coderslab.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;

import java.util.Objects;

@RestController
class BookController {

    private final BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // create book
    @PostMapping(path = "/book")
    void save(@RequestParam String title, @RequestParam int rating, @RequestParam String description, @RequestParam String publisherName) {

        final Book book = new Book();

        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);

        Publisher publisher = new Publisher();
        publisher.setName(publisherName);

        book.setPublisher(publisher);

        bookService.save(book);
    }

    // get book by id
    @GetMapping(path = "/book/{id}", produces = "text/plain;charset=utf-8")
    String findById(@PathVariable Long id) {

        final Book book = bookService.findById(id);

        return Objects.nonNull(book) ? book.toString() : "Nie znaleziono książki o podanym id " + id;
    }

    // update book
    @PutMapping(path = "/book/{id}")
    void update(@PathVariable Long id, @RequestParam String title, @RequestParam int rating, @RequestParam String description) {

        final Book book = bookService.findById(id);

        if (Objects.nonNull(book)) {

            book.setTitle(title);
            book.setRating(rating);
            book.setDescription(description);

            bookService.update(book);
        }
    }

    // delete book by id
    @DeleteMapping(path = "/book/{id}")
    void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
