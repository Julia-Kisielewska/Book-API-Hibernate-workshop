package pl.coderslab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Book {

    private long id;
    private String isbn;
    private String title;
    private String author;
    private String editor;
    private String tag;

}
