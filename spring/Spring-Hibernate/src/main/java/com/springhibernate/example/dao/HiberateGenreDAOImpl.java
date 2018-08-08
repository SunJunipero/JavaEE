package com.springhibernate.example.dao;

import com.springhibernate.example.model.Genre;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class HiberateGenreDAOImpl implements GenreDAO {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Integer createGenre(Genre genre) {
        Integer id = (Integer) sessionFactory.getCurrentSession().save(genre);
        return id;
    }

    @Override
    public void deleteGenre(Genre genre) {
        sessionFactory.getCurrentSession().delete(genre);
    }

    @Override
    public Genre getGenre(String genre_name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Genre  where genre_name = ?");
        query.setParameter(0, genre_name);
        return ((Genre) query.uniqueResult());
    }
}
