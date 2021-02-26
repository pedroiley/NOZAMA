package dao;

import entity.Product;
import util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDao{
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

    public Product getProduct(int productId) {
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

    public Product getProduct(String name) {
        Session session = Hibernate.getSessionFactory().openSession();
        try {
            Product product = session.find(Product.class, name);
            session.close();
            return product;
        } catch (Exception ex) {
            session.close();
            System.out.println("Unable to find the product with name: " + name);
            ex.printStackTrace();
            return null;
        }
    }

    public List<Product> getProducts() {
        Session session = Hibernate.getSessionFactory().openSession();
        List<Product> productList = session.createQuery("from Product", Product.class).list();
        session.close();
        return productList;
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

    public void updateProduct(int productId, Product savedProduct) {
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
