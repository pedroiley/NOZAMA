package com.dao;

import com.entity.CartItem;
import com.util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class CartItemDao {

    public CartItemDao() {
    }

    public void createCartItem(CartItem cartItem) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cartItem);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public CartItem getCartItem(int cartItemId) {
        Session session = Hibernate.getSessionFactory().openSession();
        try {
            CartItem cartItem = session.find(CartItem.class, cartItemId);
            session.close();
            return cartItem;
        } catch (Exception ex) {
            session.close();
            System.out.println("Unable to find the cartItem with id: " + cartItemId);
            ex.printStackTrace();
            return null;
        }
    }

    public List<CartItem> getCartItems() {
        Session session = Hibernate.getSessionFactory().openSession();
        List<CartItem> cartItemList = session.createQuery("from CartItem", CartItem.class).list();
        session.close();
        return cartItemList;
    }

    public List<CartItem> getCartItemsByCartId(int cartId) {
        Session session = Hibernate.getSessionFactory().openSession();
        List<CartItem> cartItemListByCartId = session.createQuery("from CartItem", CartItem.class).
                stream().
                filter(cartItem -> cartItem.getCartId() == cartId).
                collect(Collectors.toList());
        session.close();
        return cartItemListByCartId;
    }

    public void updateCartItem(CartItem savedCartItem) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(savedCartItem);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void deleteCartItem(CartItem savedCartItem) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(savedCartItem);
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
