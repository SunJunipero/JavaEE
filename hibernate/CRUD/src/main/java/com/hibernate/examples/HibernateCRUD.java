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


public class HibernateCRUD {
    private static final Logger log = LoggerFactory.getLogger(HibernateCRUD.class);

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

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

        create();
//
//        get();
//        load();
//
//        getVsLoad();
//
//        update();
//        delete();

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
        //id = region.getRegionId();
    }
}
