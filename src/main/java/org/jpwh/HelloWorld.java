package org.jpwh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jpwh.model.inheritance.tableperclass.BankAccount;
import org.jpwh.model.inheritance.tableperclass.CreditCard;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HelloWorld {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\GitRepozitory\\Hibernate\\Hibernate_HelloWorld\\src\\main\\resources\\hibernate.properties"));
        } catch (IOException e) {
            System.out.println("Property load is fail");
        }
        Configuration configuration = new Configuration();
//        configuration.setPhysicalNamingStrategy(new CENamingStrategy());
        System.out.println("+");

        configuration.mergeProperties(properties).configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            System.out.println("Ok");
            Transaction tx = session.beginTransaction();
//            BankAccount bankAccount = new BankAccount("Owner","account","Sber","Swift");
//            CreditCard creditCard = new CreditCard("Owner","1111 1111 1111 1111","09","1991");
            BankAccount bankAccount = new BankAccount();
            CreditCard creditCard = new CreditCard();
            session.persist(bankAccount);
            session.persist(creditCard);

            tx.commit();
            System.out.println("+");


        }
    }
}

