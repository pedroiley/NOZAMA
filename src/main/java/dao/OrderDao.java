package dao;

import entity.OrderItem;
import entity.Orders;
import util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class OrderDao {
    public OrderDao() {
    }

    public void createOrder(Orders orders) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(orders);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void updateOrder(Orders savedOrders) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(savedOrders);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public Orders getOrder(int orderId) {
        Session session = Hibernate.getSessionFactory().openSession();
        try {
            Orders orders = session.find(Orders.class, orderId);
            session.close();
            return orders;
        } catch (Exception ex) {
            session.close();
            System.out.println("Unable to find the order with id: " + orderId);
            ex.printStackTrace();
            return null;
        }
    }

    public List<Orders> getOrders() {
        Session session = Hibernate.getSessionFactory().openSession();
        List<Orders> ordersList = session.createQuery("from CustomerOrder", Orders.class).list();
        session.close();
        return ordersList;
    }

    public void deleteOrder(Orders savedOrders) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(savedOrders);
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
