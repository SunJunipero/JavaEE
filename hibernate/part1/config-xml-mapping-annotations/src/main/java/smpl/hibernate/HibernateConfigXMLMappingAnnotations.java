package smpl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HibernateConfigXMLMappingAnnotations {

    private static final Logger log = LoggerFactory.getLogger(HibernateConfigXMLMappingAnnotations.class);

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static void init() {
        Configuration configuration = new Configuration();
        //configuration.addClass(smpl.hibernate.Region.class);
        /**
         * without this line (configuration.addPackage("smpl.hibernate").addAnnotatedClass(Region.class))
         * we get Unknown entity exception
         */
        configuration.addPackage("smpl.hibernate").addAnnotatedClass(Region.class);
        configuration.configure("hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private static void destroy() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

    public static void main(String[] args) {
        init();

        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();

        //s.save(new hibernate.Region("Krasnoe Selo"));
//        Region o = new Region("looool");
//        s.save(o);

        List<Region> regionList = s.createQuery("from Region").list();
        for (Region r : regionList) {
            System.out.println(r);
        }

        s.getTransaction().commit();

        log.debug("Transaction committed");

        destroy();
    }
}