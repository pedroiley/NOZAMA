package dao;

import entity.Cart;
import util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CartDao {
    private static Session session = Hibernate.getSessionFactory().openSession();

    public CartDao() {
    }

    public void createCart(Cart cart) {
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

    public Cart getCart(Long cartId) {
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

    public List<Cart> getCart() {
        return session.createQuery("from Cart", Cart.class).list();
    }

    public void updateCart(Cart savedCart) {
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

    public void deleteCart(Cart savedCart) {
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
        session.close();
    }
}
