package az.company.library.service.impl;

import az.company.library.dao.AuthorDao;
import az.company.library.model.Author;
import az.company.library.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao;

    @Override
    public List<Author> getAuthorList() {
        return authorDao.getAuthorList();
    }

    @Override
    public void addAuthor(Author author) {
        authorDao.addAuthor(author);
    }

    @Override
    public void deleteAuthor(long authorId) {
        authorDao.deleteAuthor(authorId);
    }

    @Override
    public void updateAuthor(Author author) {
        authorDao.updateAuthor(author);
    }

    @Override
    public Author getAuthorById(long authorId) {
        return authorDao.getAuthorById(authorId);
    }
}
