package dao;

import entity.Order;
import entity.OrderItem;
import util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class OrderDao {
    public OrderDao() {
    }

    public void createOrder(Order order) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void updateOrder(Order savedOrder) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(savedOrder);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public Order getOrder(Long orderId) {
        Session session = Hibernate.getSessionFactory().openSession();
        try {
            Order order = session.find(Order.class, orderId);
            session.close();
            return order;
        } catch (Exception ex) {
            session.close();
            System.out.println("Unable to find the order with id: " + orderId);
            ex.printStackTrace();
            return null;
        }
    }



    public List<Order> getOrders() {
        Session session = Hibernate.getSessionFactory().openSession();
        return session.createQuery("from orders", Order.class).list();
    }

    public void updateOrder(javax.persistence.criteria.Order savedOrder) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(savedOrder);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void deleteOrder(Order savedOrder) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(savedOrder);
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
