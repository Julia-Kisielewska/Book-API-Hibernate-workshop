package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    public List<Book> listBooks() {

        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book bookById(@PathVariable("id") String id) {

        return bookService.getBookById(id);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
//
//        Book book = new Book(5L, "8377580284", "Harry Potter 1 and the Philosopher's Stone",
//                " Joanne K. Rowling", "Bloomsbury UK", "fantasy");
bookService.addBook(book);
//        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public List<Book> updateBook(@PathVariable("id") String id, @RequestBody Book book) {

        Long bookId = Long.parseLong(id);

//        Book book = new Book(bookId, "8377580284", "Harry Potter 2 and the Chamber of Secrets",
//                " Joanne K. Rowling", "Bloomsbury UK", "fantasy");

        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public List<Book> deleteBook(@PathVariable("id") String id) {

        return bookService.deleteBook(id);
    }
}

