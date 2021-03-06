package app.interfaces;

import app.models.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);

    Book getBookById(Long id);

    List<Book> getBooks();

    Book updateBook(Book book);

    void deleteBookById(Long id);

}
