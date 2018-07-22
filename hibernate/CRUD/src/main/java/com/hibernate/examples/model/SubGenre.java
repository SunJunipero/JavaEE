package com.hibernate.examples.model;


import javax.persistence.*;

@Entity
@Table(name = "sub_genres")
public class SubGenre  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sub_gen_name", nullable = false)
    private String sub_genre_name;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    //@Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "genreid")
    private Genre genre;
    public SubGenre() {

    }

    public SubGenre(String sub_genre_name, Genre genre) {
        this.sub_genre_name = sub_genre_name;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSub_genre_name() {
        return sub_genre_name;
    }

    public void setSub_genre_name(String sub_genre_name) {
        this.sub_genre_name = sub_genre_name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
