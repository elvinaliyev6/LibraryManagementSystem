package az.company.library.service;

import az.company.library.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthorList();

    void addAuthor(Author author);

    void deleteAuthor(long authorId);

    void updateAuthor(Author author);

    Author getAuthorById(long authorId);
}
