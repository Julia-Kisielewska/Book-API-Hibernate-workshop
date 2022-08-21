package pl.coderslab.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Pattern(regexp = "\\d{10}")
    private String isbn;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotBlank
    private String publisher;
    private String type;

    public Book updateFields(Book book){
        this.setIsbn(book.getIsbn());
        this.setTitle(book.getTitle());
        this.setAuthor(book.getAuthor());
        this.setPublisher(book.getPublisher());
        this.setType(book.getType());
        return this;
    }
}
