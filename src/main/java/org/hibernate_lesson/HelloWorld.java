package org.hibernate_lesson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate_lesson.entity.Message;

public class HelloWorld {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            System.out.println("Ok");
            session.beginTransaction();
            Message message = new Message();
            message.setText("Hello World");
            session.save(message);
            session.getTransaction().commit();
            session.close();
        }
        }

    }

