package az.company.library.dao;

import az.company.library.model.Author;

import java.util.*;

public interface AuthorDao {

    List<Author> getAuthorList();

    void addAuthor(Author author);

    void deleteAuthor(long authorId);

    void updateAuthor(Author author);

    Author getAuthorById(long authorId);
}
