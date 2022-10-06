package az.company.library.dao.impl;

import az.company.library.dao.DbHelper;
import az.company.library.dao.GenreDao;
import az.company.library.model.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoImpl implements GenreDao {
    @Override
    public List<Genre> getGenreList() {
        String sql = "select * from genre where active=1";
        List<Genre> genreList = new ArrayList<>();
        try (Connection c = DbHelper.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Genre genre = new Genre();
                genre.setId(rs.getLong("id"));
                genre.setName(rs.getString("name"));
                genreList.add(genre);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return genreList;
    }

    @Override
    public Genre findGenreById(long genreId) {
        return null;
    }

    @Override
    public void addGenre(Genre genre) {
        String sql="insert into genre (name) " + "values(?)";

        try(Connection c=DbHelper.getConnection()){
                PreparedStatement ps=c.prepareStatement(sql);
                ps.setString(1,genre.getName());
                ps.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteGenre(long genreId) {

    }

    @Override
    public void updateGenre(Genre genre) {

    }
}
