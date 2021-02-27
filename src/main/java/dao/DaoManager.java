package dao;

public class DaoManager {

    private CartDao cartDao;
    private OrderItemDao orderItemDao;
    private ProductDao productDao;
    private UserDao userDao;
    public DaoManager() {
        this.cartDao = new CartDao();
        this.orderItemDao = new OrderItemDao();
        this.productDao = new ProductDao();
        this.userDao = new UserDao();
    }

    public CartDao getCartDao() {
        return cartDao;
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
