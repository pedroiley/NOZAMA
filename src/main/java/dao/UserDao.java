package dao;

import entity.User;
import util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UserDao {
    private static Session session = Hibernate.getSessionFactory().openSession();

    public UserDao() {
    }

    public void createUser(User user) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public User getUser(Long userId) {
        try {
            User user = session.find(User.class, userId);
            session.close();
            return user;
        } catch (Exception ex) {
            session.close();
            System.out.println("Unable to find the user with id: " + userId);
            ex.printStackTrace();
            return null;
        }
    }

    public List<User> getUser() {
        return session.createQuery("from User", User.class).list();
    }

    public void updateUser(User savedUser) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(savedUser);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void deleteUser(User savedUser) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(savedUser);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }
}
