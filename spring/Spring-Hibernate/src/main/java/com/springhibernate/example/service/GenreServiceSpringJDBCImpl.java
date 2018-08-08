package com.springhibernate.example.service;

import com.springhibernate.example.dao.GenreDAO;
import com.springhibernate.example.model.Genre;

public class GenreServiceSpringJDBCImpl implements GenreService {

    GenreDAO genreDAO;
    public void setGenreDAO (GenreDAO genreDAO){
        this.genreDAO = genreDAO;
    }

    @Override
    public Integer createGenre(Genre genre) {
        return null;
    }

    @Override
    public void deleteGenre(Genre genre) {
        genreDAO.deleteGenre(genre);
    }

    @Override
    public Genre getGenre(String genre_name) {
       return genreDAO.getGenre(genre_name);
    }

    @Override
    public void readOnly(String genre_name) {

    }
}
