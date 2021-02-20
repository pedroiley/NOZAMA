package dao;

import entity.Order;
import util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class OrderDao {
    private static Session session = Hibernate.getSessionFactory().openSession();

    public OrderDao() {
    }

    public void createOrder(Order order) {
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

    public Order getOrder(Long orderId) {
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
        return session.createQuery("from orders", Order.class).list();
    }

    public void updateOrder(javax.persistence.criteria.Order savedOrder) {
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
