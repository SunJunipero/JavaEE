package com.hibernate.examples.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres", schema = "music_blog")
public class Genre{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "genre_name", nullable = false)
    private String genre_name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "genre")
    @OrderBy(value = "sub_genre_name")
    private List<SubGenre> subGenres;

    public Genre(){

    }

    public Genre(String genre_name) {
        this.genre_name = genre_name;
    }

    public Genre(Integer id, String genre_name, List<SubGenre> subGenres) {
        this.id = id;
        this.genre_name = genre_name;
        this.subGenres = subGenres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
