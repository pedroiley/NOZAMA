package dao;

import entity.Product;
import util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ProductDao {

    public ProductDao() {
    }

    public void createProduct(Product product) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public Product getProduct(Long productId) {
        Session session = Hibernate.getSessionFactory().openSession();
        try {
            Product product = session.find(Product.class, productId);
            session.close();
            return product;
        } catch (Exception ex) {
            session.close();
            System.out.println("Unable to find the product with id: " + productId);
            ex.printStackTrace();
            return null;
        }
    }

    public List<Product> getProduct() {
        Session session = Hibernate.getSessionFactory().openSession();
        return session.createQuery("from Product", Product.class).list();
    }

    public void updateProduct(Product savedProduct) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(savedProduct);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void deleteProduct(Product savedProduct) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(savedProduct);
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
