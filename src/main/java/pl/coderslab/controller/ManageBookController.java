package pl.coderslab.controller;

import com.google.protobuf.StringValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {
    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/books/add";
    }

    @PostMapping("/add")
    public String saveBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/add";
        }
        bookService.addBook(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/show")
    public String showBook(@RequestParam(name = "id") String id, Model model) {
        Book book = bookService.getBookById(id).get();
        model.addAttribute("book", book);
        return "/books/show";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id") String id) {
        Book book = bookService.getBookById(id).get();
        model.addAttribute("book", book);
        return "/books/edit";
    }

    @PostMapping("/edit")
    public String edit (Book book, Model model){
        String id = String.valueOf(book.getId());
        bookService.updateBook(id, book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") String id, Model model) {
        Book book = bookService.getBookById(id).get();
        model.addAttribute("book", book);
        return "/books/delete";
    }

    @PostMapping("/delete")
    public String delete(Book book, Model model){
        bookService.deleteBook(String.valueOf(book.getId()));
        return "redirect:/admin/books/all";
    }

}
