package util;

import java.util.Properties;

import entity.Orders;
import entity.Product;
import entity.User;
import entity.OrderItem;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class Hibernate {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            PropertiesConfiguration applicationProperties = new PropertiesConfiguration();
            applicationProperties.load("application.properties");
            Configuration configuration = new Configuration();
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/Nozama?createDatabaseIfNotExist=true&serverTimezone=UTC");
            properties.put(Environment.USER, applicationProperties.getString("dbUsername"));
            properties.put(Environment.PASS, applicationProperties.getString("dbPassword"));
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
//            properties.put(Environment.HBM2DDL_AUTO, "create-drop");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            configuration.setProperties(properties);
            // all entities need to be registered
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Orders.class);
            configuration.addAnnotatedClass(OrderItem.class);
            configuration.addAnnotatedClass(Product.class);
//            configuration.addAnnotatedClass(CLASSNAME.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sessionFactory;
    }
}