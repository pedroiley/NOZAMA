package dao;

import entity.Cart;
import util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CartDao {
    public CartDao() {
    }

    public void createCart(Cart cart) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cart);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void updateCart(Cart savedCart) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(savedCart);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public Cart getCart(int cartId) {
        Session session = Hibernate.getSessionFactory().openSession();
        try {
            Cart cart = session.find(Cart.class, cartId);
            session.close();
            return cart;
        } catch (Exception ex) {
            session.close();
            System.out.println("Unable to find the cart with id: " + cartId);
            ex.printStackTrace();
            return null;
        }
    }

    public List<Cart> getCarts() {
        Session session = Hibernate.getSessionFactory().openSession();
        List<Cart> cartList = session.createQuery("from Cart", Cart.class).list();
        session.close();
        return cartList;
    }

    public void deleteCart(Cart savedCart) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(savedCart);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
