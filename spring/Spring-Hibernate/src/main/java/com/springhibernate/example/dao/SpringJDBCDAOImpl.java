package com.springhibernate.example.dao;

import com.springhibernate.example.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpringJDBCDAOImpl implements GenreDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer createGenre(Genre genre) {

        return null;
    }

    @Override
    public void deleteGenre(Genre genre) {
        jdbcTemplate.update("delete from music_blog.genres where genres.genre_name = ?", genre.getGenre_name());
    }


    //(resultSet, i) -> new Genre(resultSet.getString(genre_name))
    @Override
    public Genre getGenre(String genre_name) {
        Genre genre = jdbcTemplate.queryForObject("select music_blog.genres.genre_name from music_blog.genres where music_blog.genres.genre_name = ?", new Object[]{genre_name}, new RowMapper<Genre>() {
                    @Override
                    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
                        return new Genre(resultSet.getString("genre_name"));
                    }
                }
        );
        return genre;
    }
}
