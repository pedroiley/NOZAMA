package dao;

import entity.OrderItem;
import util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class OrderItemDao {

    public OrderItemDao() {
    }

    public void createOrderItem(OrderItem orderItem) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(orderItem);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public OrderItem getOrderItem(int orderItemId) {
        Session session = Hibernate.getSessionFactory().openSession();
        try {
            OrderItem orderItem = session.find(OrderItem.class, orderItemId);
            session.close();
            return orderItem;
        } catch (Exception ex) {
            session.close();
            System.out.println("Unable to find the orderItem with id: " + orderItemId);
            ex.printStackTrace();
            return null;
        }
    }

    public List<OrderItem> getOrderItems() {
        Session session = Hibernate.getSessionFactory().openSession();
        List<OrderItem> orderItemList = session.createQuery("from OrderItem", OrderItem.class).list();
        session.close();
        return orderItemList;
    }

    public void updateOrderItem(OrderItem savedOrderItem) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(savedOrderItem);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void deleteOrderItem(OrderItem savedOrderItem) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(savedOrderItem);
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
