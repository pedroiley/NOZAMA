package dao;

import entity.User;

public class DaoManager {

    private OrderDao orderDao;
    private OrderItemDao orderItemDao;
    private ProductDao productDao;
    private UserDao userDao;
    public DaoManager() {
        this.orderDao = new OrderDao();
        this.orderItemDao = new OrderItemDao();
        this.productDao = new ProductDao();
        this.userDao = new UserDao();
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderItemDao getOrderItemDao() {
        return orderItemDao;
    }

    public void setOrderItemDao(OrderItemDao orderItemDao) {
        this.orderItemDao = orderItemDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
