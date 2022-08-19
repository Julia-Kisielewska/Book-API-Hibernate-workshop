package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> listBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book bookById(@PathVariable("id") String id) {
        return bookService.getBookById(id).get();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public List<Book> updateBook(@PathVariable("id") String id, @RequestBody Book book) {
        Long bookId = Long.parseLong(id);
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public List<Book> deleteBook(@PathVariable("id") String id) {
        return bookService.deleteBook(id);
    }
}

