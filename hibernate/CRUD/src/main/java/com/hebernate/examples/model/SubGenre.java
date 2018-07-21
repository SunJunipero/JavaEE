package com.hebernate.examples.model;

public class SubGenre extends BaseEntity {
    private String sub_genre_name;
    private Integer generid;

    public SubGenre(String sub_genre_name, Integer generid) {
        this.sub_genre_name = sub_genre_name;
        this.generid = generid;
    }

    public String getSub_genre_name() {
        return sub_genre_name;
    }

    public void setSub_genre_name(String sub_genre_name) {
        this.sub_genre_name = sub_genre_name;
    }

    public Integer getGenerid() {
        return generid;
    }

    public void setGenerid(Integer generid) {
        this.generid = generid;
    }
}
