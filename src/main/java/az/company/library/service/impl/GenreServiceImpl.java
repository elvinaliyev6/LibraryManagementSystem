package az.company.library.service.impl;

import az.company.library.dao.GenreDao;
import az.company.library.model.Genre;
import az.company.library.service.GenreService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class GenreServiceImpl implements GenreService {

    private GenreDao genreDao;

    @Override
    public List<Genre> getGenreList() {
        return genreDao.getGenreList();
    }

    @Override
    public Genre findGenreById(long genreId) {
        return genreDao.findGenreById(genreId);
    }

    @Override
    public void addGenre(Genre genre) {
        genreDao.addGenre(genre);
    }

    @Override
    public void deleteGenre(long genreId) {
        genreDao.deleteGenre(genreId);
    }

    @Override
    public void updateGenre(Genre genre) {
        genreDao.updateGenre(genre);
    }
}
