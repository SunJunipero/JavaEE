package hibernate.inheritance.joined;



        import hibernate.inheritance.joined.model.CashPayment;
        import hibernate.inheritance.joined.model.ChequePayment;
        import hibernate.inheritance.joined.model.CreditCard;
        import hibernate.inheritance.joined.model.Payment;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
        import org.hibernate.cfg.Configuration;
        import org.hibernate.service.ServiceRegistry;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;

        import java.util.List;

public class HibernateInheritanceExample {

    private static final Logger log = LoggerFactory.getLogger(HibernateInheritanceExample.class);

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static void init() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addPackage("hibernate.inheritance.joined.model").addAnnotatedClass(Payment.class);
        configuration.addPackage("hibernate.inheritance.joined.model").addAnnotatedClass(CashPayment.class);
        configuration.addPackage("hibernate.inheritance.joined.model").addAnnotatedClass(ChequePayment.class);
        configuration.addPackage("hibernate.inheritance.joined.model").addAnnotatedClass(CreditCard.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private static void destroy() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

    public static void main(String[] args) {
        init();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Payment payment = new Payment();
        payment.setAmount(123.12);
        session.save(payment);

        CashPayment cashPayment = new CashPayment();
        cashPayment.setAmount(423.1);
        cashPayment.setCashDesk("super cash desk");
        session.save(cashPayment);

        ChequePayment chequePayment = new ChequePayment();
        chequePayment.setAmount(463.32);
        chequePayment.setBankId("ALPHA");
        session.save(chequePayment);

        CreditCard creditCard = new CreditCard();
        creditCard.setAmount(555d);
        creditCard.setCardId("8137");
        session.save(creditCard);


        List<Payment> payments = session.createQuery("from Payment ").list();
        for (Payment pay: payments) {
            log.info("Payment: class: {}, toString: {}", pay.getClass().getCanonicalName(), pay);
        }

        log.info("=========================================");

        List<Payment> cashPayments = session.createQuery("from CashPayment ").list();
        for (Payment pay: cashPayments) {
            log.info("CashPayment: class: {}, toString: {}", pay.getClass().getCanonicalName(), pay);
        }

        session.getTransaction().commit();

        destroy();
    }

}