package az.company.library.dao.impl;

import az.company.library.dao.BookDao;
import az.company.library.dao.DbHelper;
import az.company.library.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {


        @Override
    public List<AuthorBookGenre> getBookList() {
        String sql = "select abg.id,\n" +
                "b.name,b.price,b.description,b.id,\n" +
                "a.name author_name,a.surname author_surname,a.id author_id,\n" +
                "g.name genre_name, g.id genre_id\n" +
                " from author_book_genre abg\n" +
                "inner join author a on abg.author_id=a.id\n" +
                "inner join book_genre bg on abg.book_genre_id=bg.id\n" +
                "inner join book b on bg.book_id=b.id\n" +
                "inner join genre g on bg.genre_id=g.id where abg.active=1";
        List<AuthorBookGenre> bookList = new ArrayList<>();

        try (Connection c = DbHelper.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setDescription(rs.getString("description"));
                book.setPrice(rs.getDouble("price"));
                book.setId(rs.getLong("id"));

                Genre genre = new Genre();
                genre.setName(rs.getString("genre_name"));
                genre.setId(rs.getLong("genre_id"));

                Author author = new Author();
                author.setName(rs.getString("author_name"));
                author.setSurname(rs.getString("author_surname"));
                author.setId(rs.getLong("author_id"));

                BookGenre bg=new BookGenre();
                bg.setBook(book);
                bg.setGenre(genre);

                AuthorBookGenre abg = new AuthorBookGenre();
                abg.setAuthor(author);
                abg.setBookGenre(bg);
                abg.setId(rs.getLong("id"));

                bookList.add(abg);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Book getBookById(long id) {
        return null;
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void deleteBook(long bookId) {

    }

    @Override
    public void updateBook(Book book) {

    }
}
