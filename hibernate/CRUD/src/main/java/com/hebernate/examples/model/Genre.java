package com.hebernate.examples.model;

import java.util.List;

public class Genre extends BaseEntity{
    private String genre_name;
    private List<SubGenre> subGenres;

    public Genre(String genre_name){
        this.genre_name = genre_name;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public List<SubGenre> getSubGenres() {
        return subGenres;
    }

    public void setSubGenres(List<SubGenre> subGenres) {
        this.subGenres = subGenres;
    }
}
