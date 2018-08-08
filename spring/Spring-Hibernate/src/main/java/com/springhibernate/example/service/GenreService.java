package com.springhibernate.example.service;

import com.springhibernate.example.model.Genre;

public interface GenreService {
    Integer createGenre(Genre genre);
    void deleteGenre(Genre genre);
    Genre getGenre(String genre_name);
    void readOnly(String genre_name);
}
