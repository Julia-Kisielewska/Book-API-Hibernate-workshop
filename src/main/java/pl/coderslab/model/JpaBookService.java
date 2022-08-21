package pl.coderslab.model;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
//@ConditionalOnProperty(value ="${myproperties}")
//tylko Spring Boot- jesli na danym serwerze chcemy użyć innej implementacji jakiegoś serwisu
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

    public Book getBookById(String id) {
        Long bookId = Long.valueOf(id);
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> updateBook(String id, Book book) {

        bookRepository.findById(Long.valueOf(id))
                .ifPresentOrElse(b -> b.updateFields(book), () -> {
                    throw new RuntimeException();
                });
        return bookRepository.findAll();


////        Book toReplace = bookRepository.findById(Long.valueOf(id)).get();
//        if (bookRepository.existsById(Long.valueOf(id))) {
//            Book toReplace = bookRepository.findById(Long.valueOf(id)).get();
//            toReplace.updateFields(book);
//
//            return bookRepository.findAll();
//        } else {
//            throw new RuntimeException();
//        }

//        toReplace.setIsbn(book.getIsbn());
//        toReplace.setTitle(book.getTitle());
//        toReplace.setAuthor(book.getAuthor());
//        toReplace.setPublisher(book.getPublisher());
//        toReplace.setType(book.getType());
//
//        return bookRepository.findAll();
    }

    @Override
    public List<Book> deleteBook(String id) {
        bookRepository.deleteById(Long.valueOf(id));
        return bookRepository.findAll();
    }
}
