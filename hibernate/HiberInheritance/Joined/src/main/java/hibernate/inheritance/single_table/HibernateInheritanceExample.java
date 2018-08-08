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

//        Payment payment = new Payment();
//        payment.setAmount(123.12);
//        session.save(payment);
//
        CashPayment cashPayment = new CashPayment();
        cashPayment.setAmount(423223.1);
        cashPayment.setCashDesk("super cash desk");
        session.save(cashPayment);
//
//        ChequePayment chequePayment = new ChequePayment();
//        chequePayment.setAmount(463.32);
//        chequePayment.setBankId("ALPHA");
//        session.save(chequePayment);

//        CreditCard creditCard = new CreditCard();
//        creditCard.setAmount(54535d);
//        creditCard.setCardId("8137");
//        session.save(creditCard);

/**
 * Common select
 * select payment0_.payment_id as payment_1_3_, payment0_.amount as amount2_3_, payment0_1_.cash_desk as cash_des1_0_,
 * payment0_2_.bank_id as bank_id1_1_, payment0_3_.card_id as card_id1_2_, case when payment0_1_.paymentt_id
 * is not null then 1 when payment0_2_.payment_id is not null then 2 when payment0_3_.payment_id is not null
 * then 3 when payment0_.payment_id is not null then 0 end as clazz_ from payments payment0_ left outer join
 * cash_payment payment0_1_ on payment0_.payment_id=payment0_1_.paymentt_id left outer join cheque_payment
 * payment0_2_ on payment0_.payment_id=payment0_2_.payment_id left outer join credit_payment payment0_3_
 * on payment0_.payment_id=payment0_3_.payment_id
 */
        List<Payment> payments = session.createQuery("from Payment ").list();
        for (Payment pay: payments) {
            log.info("Payment: class: {}, toString: {}", pay.getClass().getCanonicalName(), pay);
        }

        log.info("=========================================");
/**
 * select cashpaymen0_.paymentt_id as payment_1_3_, cashpaymen0_1_.amount as amount2_3_,
 * cashpaymen0_.cash_desk as cash_des1_0_ from cash_payment cashpaymen0_ inner join payments
 * cashpaymen0_1_ on cashpaymen0_.paymentt_id=cashpaymen0_1_.payment_id
 */
        List<Payment> cashPayments = session.createQuery("from CashPayment ").list();
        for (Payment pay: cashPayments) {
            log.info("CashPayment: class: {}, toString: {}", pay.getClass().getCanonicalName(), pay);
        }

        session.getTransaction().commit();

        destroy();
    }

}