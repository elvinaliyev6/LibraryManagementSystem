package az.company.library.service.impl;

import az.company.library.dao.BookDao;
import az.company.library.model.AuthorBookGenre;
import az.company.library.model.Book;
import az.company.library.service.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class BookServiceImpl implements BookService {

    private BookDao bookDao;


    @Override
    public List<AuthorBookGenre> getBookList() {
        return bookDao.getBookList();
    }

    @Override
    public Book getBookById(long id) {
        return bookDao.getBookById(id);
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(long bookId) {
        bookDao.deleteBook(bookId);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

}
