package com.hibernate.examples;

import com.hibernate.examples.model.Genre;
import com.hibernate.examples.model.SubGenre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;


public class HibernateCRUD {
    private static final Logger log = LoggerFactory.getLogger(HibernateCRUD.class);

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static Serializable id = null;

    private static void init() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        String default_schema = configuration.getProperties().getProperty("default_schema");
        System.out.println("\t\t SCHEMA - " + default_schema);
        configuration.addPackage("com.hibernate.examples.model").addAnnotatedClass(Genre.class);
        configuration.addPackage("com.hibernate.examples.model").addAnnotatedClass(SubGenre.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private static void destroy() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

    public static void main(String[] args) {
        init();
       // create();
//
//       get();
//       load();
//
//        getVsLoad();
//
 //       update();
        delete();

        destroy();
    }

    private static void create() {
        log.info("==============CREATE=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Genre genre = new Genre("New Club");
        //Region region = new Region("Saint-Petersburg!");
        session.save(genre);
        session.getTransaction().commit();
        id = genre.getId();
        System.out.println(id);
    }

    private static void get(){
        log.info("==============GET=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Genre genre = session.get(Genre.class, 2);
        log.info("genre = {}", genre);
        session.getTransaction().commit();

    }

    private static void load(){
        log.info("==============LOAD=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Genre genre = session.load(Genre.class, 2);
        log.info("genre = {}", genre);
        session.getTransaction().commit();
    }

    private static void getVsLoad(){
        log.info("==============GetVsLoad=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Genre genre = session.get(Genre.class, 2);
        SubGenre subGenre = new SubGenre();
        subGenre.setSub_genre_name("new sub genre");
        subGenre.setGenre(genre);
        session.save(subGenre);

        genre = session.load(Genre.class, 2);
        SubGenre subGenre2 = new SubGenre();
        subGenre2.setSub_genre_name("new sub genre 2");
        subGenre2.setGenre(genre);
        session.save(subGenre2);
        session.getTransaction().commit();

    }

    private static void update(){
        log.info("==============UPDATE=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        SubGenre subGenre = session.load(SubGenre.class, 11);
        subGenre.setSub_genre_name("Update name");
        session.saveOrUpdate(subGenre);
        log.info("Sub genre = {}", subGenre);
        session.getTransaction().commit();
    }

    private static void delete(){
        log.info("==============DELETE=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        SubGenre subGenre = session.load(SubGenre.class, 12);
        session.delete(subGenre);
        session.getTransaction().commit();
    }
}
