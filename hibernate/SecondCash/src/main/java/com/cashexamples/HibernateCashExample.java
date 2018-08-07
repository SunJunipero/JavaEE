package com.cashexamples;

import com.cashexamples.model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class HibernateCashExample {

    private static final Logger log = LoggerFactory.getLogger(HibernateCashExample.class);

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static void main(String[] args) {
        init();
        /**
         * DEBUG 2018-08-07 00:24:54,621 [SqlStatementLogger] - select genre0_.id as id1_0_0_, genre0_.genre_name as genre_na2_0_0_ from genres genre0_ where genre0_.id=?
         * TRACE 2018-08-07 00:24:54,637 [BasicBinder] - binding parameter [1] as [INTEGER] - [1]
         * TRACE 2018-08-07 00:24:54,666 [BasicExtractor] - extracted value ([genre_na2_0_0_] : [VARCHAR]) - [ambient/new age]
         * INFO  2018-08-07 00:24:54,676 [HibernateCashExample] - Genre: Genre{id=1, genre_name='ambient/new age'}
         * INFO  2018-08-07 00:24:54,676 [HibernateCashExample] - session cash: 683718244
         * INFO  2018-08-07 00:24:54,676 [HibernateCashExample] - Genre: Genre{id=1, genre_name='ambient/new age'
         *
         * Сессия в данном случае одна и та же, поэтому запрос к БД делается только в первый раз
         *
         * Если расскоменнтировать - то создаться новая сессия из-за чего запрос к БД сделается
         * повторно
         */
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        checkSessionOne(session);
        //comment below
        //session.getTransaction().commit();
        session = sessionFactory.getCurrentSession();
        //comment below
        //session.beginTransaction();
        checkSessionOne(session);
        session.getTransaction().commit();
        destroy();


    }

    private static void checkSessionOne(Session session) {
        log.info("session cash: {}", session.hashCode());
        //System.out.println(session.hashCode());
        Genre genre = ((Genre) session.get(Genre.class, 1));
        //System.out.println(genre);
        log.info("Genre: {}", genre);
    }

    private static void init(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
//        configuration.addPackage("com.cashexamples.model").addAnnotatedClass(Genre.class);
//        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory =  configuration.buildSessionFactory();
    }
    private static void destroy() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
}
