package pl.coderslab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;


@Data
@ToString
@Component
public class MockBookService implements BookService {

    private List<Book> list;

    @Autowired
    public MockBookService(List<Book> list) {
        list.add(new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming"));

        list.add(new Book(2L, "8377580284", "Folwark zwierzecy",
                "George Orwell", "Muza", "story"));

        list.add(new Book(3L, "9788324631766", "Nowy wspaniały świat",
                "Aldous Huxley", "Muza", "sci-fi"));

        list.add(new Book(4L, "8377580284", "Krol Artur i Rycerze Okraglego Stolu",
                "Roger Lancelyn Green", "Zysk i S-ka", "history"));

        this.list = list;
    }

    @Override
    public List<Book> getBooks() {
        return this.getList();
    }

    @Override
    public Book getBookById(String id) {
                Long bookId = Long.parseLong(id);

        BookList list = new BookList();
        List<Book> books = list.getBooks();

        return books.stream()
                .filter(s -> Objects.equals(s.getId(), bookId))
                .findFirst().get();
    }
}
