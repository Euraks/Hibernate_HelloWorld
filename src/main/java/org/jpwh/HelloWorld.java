package org.jpwh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

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
            Item item1 = new Item();
            Item item2 = new Item();
            Map<String, String> images = new HashMap<String, String>();
            Map<String, String> images1 = new HashMap<String, String>();

            images.put("1","A");
            images.put("2","B");
            images1.put("1","C");
            item1.setImages(images);
            item2.setImages(images1);
            session.persist(item1);
            session.persist(item2);

            tx.commit();
            System.out.println("+");


        }
    }
}

