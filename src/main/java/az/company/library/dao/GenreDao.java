package az.company.library.dao;

import az.company.library.model.Genre;

import java.util.List;

public interface GenreDao {

     List<Genre> getGenreList();

     Genre findGenreById(long genreId);

     void addGenre(Genre genre);

     void deleteGenre(long genreId);

     void updateGenre(Genre genre);

}
