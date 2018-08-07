package com.cashexamples;

import com.cashexamples.model.Genre;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CacheQueryExample {
    private static final Logger log = LoggerFactory.getLogger(HibernateCashExample.class);


    public static void main(String[] args) {

        /**
         * INFO  2018-08-07 17:03:50,367 [CacheQueryExample] - factory hash: 384587033
         * INFO  2018-08-07 17:03:50,367 [CacheQueryExample] - session hash: 2034182655
         * DEBUG 2018-08-07 17:03:50,537 [SQLStatementLogger] - select genre0_.id as id0_, genre0_.genre_name as genre2_0_ from genres genre0_
         * Hibernate: select genre0_.id as id0_, genre0_.genre_name as genre2_0_ from genres genre0_
         * TRACE 2018-08-07 17:03:50,557 [BasicExtractor] - found [1] as column [id0_]
         * TRACE 2018-08-07 17:03:50,563 [BasicExtractor] - found [ambient/new age] as column [genre2_0_]
         * TRACE 2018-08-07 17:03:50,564 [BasicExtractor] - found [2] as column [id0_]
         * TRACE 2018-08-07 17:03:50,565 [BasicExtractor] - found [electronica/downtempo] as column [genre2_0_]
         * TRACE 2018-08-07 17:03:50,566 [BasicExtractor] - found [3] as column [id0_]
         * TRACE 2018-08-07 17:03:50,566 [BasicExtractor] - found [hip-hop/r'n'b] as column [genre2_0_]
         * TRACE 2018-08-07 17:03:50,566 [BasicExtractor] - found [6] as column [id0_]
         * TRACE 2018-08-07 17:03:50,566 [BasicExtractor] - found [New Club] as column [genre2_0_]
         * INFO  2018-08-07 17:03:50,581 [CacheQueryExample] - Genre: Genre{id=1, genre_name='ambient/new age'}
         * INFO  2018-08-07 17:03:50,581 [CacheQueryExample] - Genre: Genre{id=2, genre_name='electronica/downtempo'}
         * INFO  2018-08-07 17:03:50,581 [CacheQueryExample] - Genre: Genre{id=3, genre_name='hip-hop/r'n'b'}
         * INFO  2018-08-07 17:03:50,581 [CacheQueryExample] - Genre: Genre{id=6, genre_name='New Club'}
         * INFO  2018-08-07 17:03:50,591 [CacheQueryExample] - factory hash: 384587033
         * INFO  2018-08-07 17:03:50,591 [CacheQueryExample] - session hash: 1176164144
         * INFO  2018-08-07 17:03:50,595 [CacheQueryExample] - Genre: Genre{id=1, genre_name='ambient/new age'}
         * INFO  2018-08-07 17:03:50,595 [CacheQueryExample] - Genre: Genre{id=2, genre_name='electronica/downtempo'}
         * INFO  2018-08-07 17:03:50,595 [CacheQueryExample] - Genre: Genre{id=3, genre_name='hip-hop/r'n'b'}
         * INFO  2018-08-07 17:03:50,595 [CacheQueryExample] - Genre: Genre{id=6, genre_name='New Club'}
         *
         * QueryCache использует кеш второго уровня, храня в нем результат запроса, благодоря
         * чему запрос делается только в первый раз
         * НО
         * если отключить кеш 2-го уровня
         * <<property name="cache.use_second_level_cache">false</property>
         * ТО
         * select genre0_.id as id0_, genre0_.genre_name as genre2_0_ from genres genre0_
         * Hibernate: select genre0_.id as id0_, genre0_.genre_name as genre2_0_ from genres genre0_
         * TRACE 2018-08-07 17:12:49,171 [BasicExtractor] - found [1] as column [id0_]
         * TRACE 2018-08-07 17:12:49,178 [BasicExtractor] - found [ambient/new age] as column [genre2_0_]
         * TRACE 2018-08-07 17:12:49,180 [BasicExtractor] - found [2] as column [id0_]
         * TRACE 2018-08-07 17:12:49,180 [BasicExtractor] - found [electronica/downtempo] as column [genre2_0_]
         * TRACE 2018-08-07 17:12:49,180 [BasicExtractor] - found [3] as column [id0_]
         * TRACE 2018-08-07 17:12:49,181 [BasicExtractor] - found [hip-hop/r'n'b] as column [genre2_0_]
         * TRACE 2018-08-07 17:12:49,181 [BasicExtractor] - found [6] as column [id0_]
         * TRACE 2018-08-07 17:12:49,181 [BasicExtractor] - found [New Club] as column [genre2_0_]
         * INFO  2018-08-07 17:12:49,191 [CacheQueryExample] - Genre: Genre{id=1, genre_name='ambient/new age'}
         * INFO  2018-08-07 17:12:49,192 [CacheQueryExample] - Genre: Genre{id=2, genre_name='electronica/downtempo'}
         * INFO  2018-08-07 17:12:49,192 [CacheQueryExample] - Genre: Genre{id=3, genre_name='hip-hop/r'n'b'}
         * INFO  2018-08-07 17:12:49,192 [CacheQueryExample] - Genre: Genre{id=6, genre_name='New Club'}
         * INFO  2018-08-07 17:12:49,205 [CacheQueryExample] - factory hash: 384587033
         * INFO  2018-08-07 17:12:49,205 [CacheQueryExample] - session hash: 1541525668
         * DEBUG 2018-08-07 17:12:49,210 [SQLStatementLogger] - select genre0_.id as id0_0_, genre0_.genre_name as genre2_0_0_ from genres genre0_ where genre0_.id=?
         * Hibernate: select genre0_.id as id0_0_, genre0_.genre_name as genre2_0_0_ from genres genre0_ where genre0_.id=?
         * TRACE 2018-08-07 17:12:49,214 [BasicBinder] - binding parameter [1] as [INTEGER] - 1
         * TRACE 2018-08-07 17:12:49,220 [BasicExtractor] - found [ambient/new age] as column [genre2_0_0_]
         * DEBUG 2018-08-07 17:12:49,222 [SQLStatementLogger] - select genre0_.id as id0_0_, genre0_.genre_name as genre2_0_0_ from genres genre0_ where genre0_.id=?
         * Hibernate: select genre0_.id as id0_0_, genre0_.genre_name as genre2_0_0_ from genres genre0_ where genre0_.id=?
         * TRACE 2018-08-07 17:12:49,225 [BasicBinder] - binding parameter [1] as [INTEGER] - 2
         * TRACE 2018-08-07 17:12:49,230 [BasicExtractor] - found [electronica/downtempo] as column [genre2_0_0_]
         * DEBUG 2018-08-07 17:12:49,231 [SQLStatementLogger] - select genre0_.id as id0_0_, genre0_.genre_name as genre2_0_0_ from genres genre0_ where genre0_.id=?
         * Hibernate: select genre0_.id as id0_0_, genre0_.genre_name as genre2_0_0_ from genres genre0_ where genre0_.id=?
         * TRACE 2018-08-07 17:12:49,232 [BasicBinder] - binding parameter [1] as [INTEGER] - 3
         * TRACE 2018-08-07 17:12:49,236 [BasicExtractor] - found [hip-hop/r'n'b] as column [genre2_0_0_]
         * DEBUG 2018-08-07 17:12:49,237 [SQLStatementLogger] - select genre0_.id as id0_0_, genre0_.genre_name as genre2_0_0_ from genres genre0_ where genre0_.id=?
         * Hibernate: select genre0_.id as id0_0_, genre0_.genre_name as genre2_0_0_ from genres genre0_ where genre0_.id=?
         * TRACE 2018-08-07 17:12:49,237 [BasicBinder] - binding parameter [1] as [INTEGER] - 6
         * TRACE 2018-08-07 17:12:49,242 [BasicExtractor] - found [New Club] as column [genre2_0_0_]
         * INFO  2018-08-07 17:12:49,243 [CacheQueryExample] - Genre: Genre{id=1, genre_name='ambient/new age'}
         * INFO  2018-08-07 17:12:49,243 [CacheQueryExample] - Genre: Genre{id=2, genre_name='electronica/downtempo'}
         * INFO  2018-08-07 17:12:49,243 [CacheQueryExample] - Genre: Genre{id=3, genre_name='hip-hop/r'n'b'}
         * INFO  2018-08-07 17:12:49,243 [CacheQueryExample] - Genre: Genre{id=6, genre_name='New Club'}
         *
         * Для первого запроса выполнится общий селект, и результат запроса останетс
         * в кеше (query). А при выполнении 2-го запроса, селекта, который выбирает все
         * объекты, его не будет. Вместо этого будет несколько точеных запросов с поиском по id
         * В данном случае id запомнились в перовом запросе, так как мы импользовали query cache.
         *
         *
         */

        CacheQueryExample cacheQueryExample = new CacheQueryExample();
        SessionFactory factory = cacheQueryExample.getSessionFactory();

        checkSessionFactoryOne(factory);

        //SessionFactory factory1 = cacheExample.getSessionFactory();
        checkSessionFactoryOne(factory);



    }

    private static void checkSessionFactoryOne(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        log.info("factory hash: {}", sessionFactory.hashCode());
        log.info("session hash: {}", session.hashCode());
        // session.be
        Query fromGenre = session.createQuery("from Genre ");
        fromGenre.setCacheable(true);
        List<Genre> genre = fromGenre.list();
        for (Genre genre1 : genre) {
            log.info("Genre: {}", genre1);
        }
        session.getTransaction().commit();
        //System.out.println("Region:" + r);
    }

    private SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        return   configuration.buildSessionFactory();
    }

}
