package pl.coderslab.converter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.service.AuthorService;

@RequiredArgsConstructor
public class StringToAuthorConverter implements Converter<String, Author> {

    private final AuthorService authorService;

    @Override
    public Author convert(String id) {

        long authorId = Long.parseLong(id);
        return authorService.findById(authorId);
    }
}
