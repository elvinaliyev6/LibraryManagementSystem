package az.company.library.service;

import az.company.library.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getGenreList();

    Genre findGenreById(long genreId);

    void addGenre(Genre genre);

    void deleteGenre(long genreId);

    void updateGenre(Genre genre);
}
