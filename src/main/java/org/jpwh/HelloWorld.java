package org.jpwh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jpwh.model.inheritance.associations.manytoone.BankAccount;
import org.jpwh.model.inheritance.associations.manytoone.BillingDetails;
import org.jpwh.model.inheritance.associations.manytoone.CreditCard;
import org.jpwh.model.inheritance.associations.manytoone.User;


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
            User user = new User("Yurii");
            BankAccount bankAccount = new BankAccount("Owner","account","BankName","SWIFT");
            CreditCard creditCard = new CreditCard("Card Owner","0000 0000 0000 0000","09","22");

            user.setDefaultBilling(bankAccount);
           // user.setDefaultBilling(creditCard);
            session.persist(bankAccount);
            session.persist(creditCard);
            session.persist(user);


            tx.commit();
            System.out.println("+");


        }
    }
}

