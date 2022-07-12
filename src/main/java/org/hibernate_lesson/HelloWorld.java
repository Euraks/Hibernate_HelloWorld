package org.hibernate_lesson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate_lesson.entity.Message;
import org.hibernate_lesson.entity.User;

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
        configuration.setPhysicalNamingStrategy(new CENamingStrategy());
        System.out.println("+");

        configuration.mergeProperties(properties).configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            System.out.println("Ok");
            session.beginTransaction();
            User user = new User();
            session.save(user);
            session.getTransaction().commit();
            session.close();
            }
        }
}

