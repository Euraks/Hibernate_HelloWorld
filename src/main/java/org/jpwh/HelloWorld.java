package org.jpwh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
            Item item1 = new Item();
            Item item2 = new Item();
            List<String > list = new ArrayList<String>();
            List<String> list1 = new ArrayList<>();
            list.add("A");
            list.add("B");
            list1.add("C");
            item1.setImages(list);
            item2.setImages(list1);

            session.persist(item1);
            session.persist(item2);

            tx.commit();
            System.out.println("+");


        }
    }
}

