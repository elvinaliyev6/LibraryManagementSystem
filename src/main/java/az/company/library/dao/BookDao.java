package az.company.library.dao;

import az.company.library.model.AuthorBookGenre;
import az.company.library.model.Book;

import java.util.*;

public interface BookDao {

    List<AuthorBookGenre> getBookList();

    Book getBookById(long id);

    void addBook(Book book);

    void deleteBook(long bookId);

    void updateBook(Book book);

}
