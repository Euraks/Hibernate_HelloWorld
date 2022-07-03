package org.hibernate;

import org.hibernate.cfg.Configuration;

public class HelloWorld {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            System.out.println("Ok");
        }
        }

    }

