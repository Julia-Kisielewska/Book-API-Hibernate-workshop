package pl.coderslab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


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

    private static Long nextId = 4L;

    @Override
    public List<Book> getBooks() {
        return this.getList();
    }

    @Override
    public Book getBookById(String id) {
        Long bookId = Long.parseLong(id);

        List<Book> books = this.getList();

        return books.stream()
                .filter(s -> Objects.equals(s.getId(), bookId))
                .findFirst().get();
    }

    @Override
    public List<Book> addBook(Book book) {

        List<Book> books = this.getList();
        book.setId(nextId++);
        nextId= nextId++;
        books.add(book);
        this.setList(books);
        return this.list;
    }

    @Override
    public List<Book> updateBook(String id, Book book) {
        Long bookId = Long.parseLong(id);

        List<Book> books = this.getList();

        List<Book> collect = books.stream()
                .filter(s -> !(Objects.equals(s.getId(), bookId)))
                .collect(Collectors.toList());

        collect.add(book);
        this.setList(collect);

        return this.list;
    }

    @Override
    public List<Book> deleteBook(String id) {
        Long bookId = Long.parseLong(id);

        List<Book> books = this.getList();

        List<Book> collect = books.stream()
                .filter(s -> !(Objects.equals(s.getId(), bookId)))
                .collect(Collectors.toList());

        this.setList(collect);

        return this.list;
    }
}
