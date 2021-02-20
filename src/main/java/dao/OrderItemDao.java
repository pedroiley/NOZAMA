package dao;

import entity.OrderItem;
import util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class OrderItemDao {
    private static Session session = Hibernate.getSessionFactory().openSession();

    public OrderItemDao() {
    }

    public void createOrderItem(OrderItem orderItem) {
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

    public OrderItem getOrderItem(Long orderItemId) {
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
        return session.createQuery("from OrderItem", OrderItem.class).list();
    }

    public void updateOrderItem(OrderItem savedOrderItem) {
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
