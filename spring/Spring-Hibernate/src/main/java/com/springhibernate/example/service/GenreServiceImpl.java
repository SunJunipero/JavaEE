package com.springhibernate.example.service;

import com.springhibernate.example.dao.GenreDAO;
import com.springhibernate.example.model.Genre;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class GenreServiceImpl implements GenreService {

    GenreDAO genreDAO;

    public void setGenreDAO (GenreDAO genreDAO){
        this.genreDAO = genreDAO;
    }

    @Override
    @Transactional
    public Integer createGenre(Genre genre) {
        Integer id = genreDAO.createGenre(genre);
        System.out.println("Genre " + id + "  " +  genre.getGenre_name() + "  created...");
        return null;
    }

    @Override
    @Transactional
    public void deleteGenre(Genre genre) {
        genreDAO.deleteGenre(genre);
        System.out.println("Genre " +  genre.getGenre_name() + "  deleted...");

    }

    @Override
    @Transactional
    public Genre getGenre(String genre_name) {
        Genre genre = genreDAO.getGenre(genre_name);
        return genre;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public void readOnly(String genre_name) {
        createGenre(new Genre(genre_name));
        genreDAO.getGenre(genre_name);
    }
}
