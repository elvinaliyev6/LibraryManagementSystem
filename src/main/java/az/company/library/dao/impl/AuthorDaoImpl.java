package az.company.library.dao.impl;

import az.company.library.dao.AuthorDao;
import az.company.library.dao.DbHelper;
import az.company.library.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    @Override
    public List<Author> getAuthorList() {
        String sql = "select * from author where active=1";
        List<Author> authorList = new ArrayList<>();
        try (Connection c = DbHelper.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getLong("id"));
                author.setName(rs.getString("name"));
                author.setSurname(rs.getString("surname"));
                author.setDob(rs.getDate("dob"));

                authorList.add(author);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorList;
    }

    @Override
    public void addAuthor(Author author) {
        String sql = "insert into author (name,surname,dob) " + "values(?,?,?)";

        try (Connection c = DbHelper.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, author.getName());
            ps.setString(2, author.getSurname());
            ps.setDate(3, new java.sql.Date(author.getDob().getTime()));

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAuthor(long authorId) {

    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public Author getAuthorById(long authorId) {
        return null;
    }
}
