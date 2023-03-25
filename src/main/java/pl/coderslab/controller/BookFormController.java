package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookFormController {

    private final BookService bookService;
    private final PublisherService publisherService;

    @GetMapping(path = "/book/form")
    String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping(path = "/book/form")
    String processAddBookForm(Book book) {
        // walidacja
        bookService.save(book);

        return "book/success";
    }

    @ModelAttribute("publishers")
    List<Publisher> publishers() {
        return publisherService.findAllPublisherModel();
    }

}
