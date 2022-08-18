package pl.coderslab.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@Transactional
public class JpaBookService implements BookService {
    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(String id) {
        Long bookId = Long.valueOf(id);
            return bookRepository.findById(bookId);
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public List<Book> updateBook(String id, Book book) {
        return null;
    }

    @Override
    public List<Book> deleteBook(String id) {
        return null;
    }
}
