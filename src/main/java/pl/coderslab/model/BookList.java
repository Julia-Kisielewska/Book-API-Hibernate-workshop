package pl.coderslab.model;

import java.util.List;

public class BookList {
    public List<Book> getBooks(){
        Book book1 = new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
        Book book2 = new Book(2L, "8377580284", "Folwark zwierzecy",
                "George Orwell", "Muza", "story");
        Book book3 = new Book(3L, "9788324631766", "Nowy wspaniały świat",
                "Aldous Huxley", "Muza", "sci-fi");
        Book book4 = new Book(4L, "8377580284", "Krol Artur i Rycerze Okraglego Stolu",
                "Roger Lancelyn Green", "Zysk i S-ka", "history");

        return List.of(book1, book2, book3, book4);
    }
}
