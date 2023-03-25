package pl.coderslab.model;

import lombok.Data;

@Data
public class Book {

    private Long id;
    private String title;
    private int rating;
    private String description;

    private Publisher publisher;
}
