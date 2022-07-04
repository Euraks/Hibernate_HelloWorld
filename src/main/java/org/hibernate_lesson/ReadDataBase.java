package org.hibernate_lesson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate_lesson.entity.Message;

import java.util.List;

public class ReadDataBase {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Message> messageList = session.createQuery("select m from Message m").getResultList();
            messageList.get(0).setText("Take me to your leader!");
            session.getTransaction().commit();
            session.close();
        }
    }
}
