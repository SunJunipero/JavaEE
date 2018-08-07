package com.cashexamples;


import com.cashexamples.model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SecondCacheExample {

    private static final Logger log = LoggerFactory.getLogger(HibernateCashExample.class);


    public static void main(String[] args) {

        SecondCacheExample cacheExample = new SecondCacheExample();
        SessionFactory factory = cacheExample.getSessionFactory();


        /**
         * INFO  2018-08-07 14:19:37,995 [SecondCacheExample] - factory hash: 1998767043
         * INFO  2018-08-07 14:19:37,995 [SecondCacheExample] - session hash: 1265900909
         * DEBUG 2018-08-07 14:19:38,004 [SQLStatementLogger] - select genre0_.id as id0_0_, genre0_.genre_name as genre2_0_0_ from genres genre0_ where genre0_.id=?
         * Hibernate: select genre0_.id as id0_0_, genre0_.genre_name as genre2_0_0_ from genres genre0_ where genre0_.id=?
         * TRACE 2018-08-07 14:19:38,034 [BasicBinder] - binding parameter [1] as [INTEGER] - 1
         * TRACE 2018-08-07 14:19:38,047 [BasicExtractor] - found [ambient/new age] as column [genre2_0_0_]
         * INFO  2018-08-07 14:19:38,060 [SecondCacheExample] - Genre: Genre{id=1, genre_name='ambient/new age'}
         * INFO  2018-08-07 14:19:38,088 [SecondCacheExample] - factory hash: 1998767043
         * INFO  2018-08-07 14:19:38,089 [SecondCacheExample] - session hash: 750029115
         * INFO  2018-08-07 14:19:38,090 [SecondCacheExample] - Genre: Genre{id=1, genre_name='ambient/new age'}
         *
         * Так как кеш второго уровня работает в рамках SessionFactory, то запрос
         * к БД делается только в первый раз (динаковые хешкоды)
         */
        checkSessionFactoryOne(factory);
        /**
         * В этом случае будет два запроса
         */
        //SessionFactory factory1 = cacheExample.getSessionFactory();
        checkSessionFactoryOne(factory);



    }

    private static void checkSessionFactoryOne(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        log.info("factory hash: {}", sessionFactory.hashCode());
        log.info("session hash: {}", session.hashCode());
       // session.be
        Genre genre = ((Genre) session.get(Genre.class, 1));
        log.info("Genre: {}", genre);
        session.getTransaction().commit();
        //System.out.println("Region:" + r);
    }

    private SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
       return   configuration.buildSessionFactory();
    }


}
