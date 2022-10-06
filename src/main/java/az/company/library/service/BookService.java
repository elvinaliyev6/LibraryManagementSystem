package az.company.library.service;

import az.company.library.model.AuthorBookGenre;
import az.company.library.model.Book;

import java.util.List;

public interface BookService {
    List<AuthorBookGenre> getBookList();

    Book getBookById(long id);

    void addBook(Book book);

    void deleteBook(long bookId);

    void updateBook(Book book);
}
