package com.dao;

public class DaoManager {

    private CartDao cartDao;
    private CartItemDao cartItemDao;
    private ProductDao productDao;
    private UserDao userDao;

    public DaoManager() {
        this.cartDao = new CartDao();
        this.cartItemDao = new CartItemDao();
        this.productDao = new ProductDao();
        this.userDao = new UserDao();
    }

    public CartDao getCartDao() {
        return cartDao;
    }

    public CartItemDao getCartItemDao() {
        return cartItemDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
