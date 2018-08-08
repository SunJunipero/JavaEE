package com.springhibernate.example.dao;

import com.springhibernate.example.model.Genre;

public interface GenreDAO {
    Integer createGenre (Genre genre);
    void  deleteGenre (Genre genre);
    Genre getGenre (String genre_name);
}
