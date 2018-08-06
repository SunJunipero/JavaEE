package hibernate.inheritance.single_table;



        import hibernate.inheritance.single_table.model.CashPayment;
        import hibernate.inheritance.single_table.model.ChequePayment;
        import hibernate.inheritance.single_table.model.CreditCard;
        import hibernate.inheritance.single_table.model.Payment;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
        import org.hibernate.cfg.Configuration;
        import org.hibernate.service.ServiceRegistry;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;

        import java.util.List;

public class HibernateInheritanceSingleTableExample {

    private static final Logger log = LoggerFactory.getLogger(HibernateInheritanceSingleTableExample.class);

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static void init() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addPackage("hibernate.inheritance.single_table.model").addAnnotatedClass(Payment.class);
        configuration.addPackage("hibernate.inheritance.single_table.model").addAnnotatedClass(CashPayment.class);
        configuration.addPackage("hibernate.inheritance.single_table.model").addAnnotatedClass(ChequePayment.class);
        configuration.addPackage("hibernate.inheritance.single_table.model").addAnnotatedClass(CreditCard.class);
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

//        Payment payment = new Payment();
//        payment.setAmount(153.12);
//        session.save(payment);
//
//        CashPayment cashPayment = new CashPayment();
//        cashPayment.setAmount(553.1);
//        cashPayment.setCashDesk("super cash desk");
//        session.save(cashPayment);
//
//        ChequePayment chequePayment = new ChequePayment();
//        chequePayment.setAmount(5463.32);
//        chequePayment.setBankId("ALPHA");
//        session.save(chequePayment);
//
//        CreditCard creditCard = new CreditCard();
//        creditCard.setAmount(5315d);
//        creditCard.setCardId("8137");
//        session.save(creditCard);


        /**
         * select payment0_.payment_id as payment_2_0_, payment0_.amount as amount3_0_,
         * payment0_.cash_desk as cash_des4_0_, payment0_.bank_id as bank_id5_0_,
         * payment0_.credit_number as credit_n6_0_, payment0_.payment_type as payment_1_0_
         * from single_table.payments payment0_
         */
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