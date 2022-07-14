package pl.coderslab.model;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Book {

    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;

}
