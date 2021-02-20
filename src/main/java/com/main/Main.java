package com.main;

import dao.OrderDao;
import dao.OrderItemDao;
import dao.ProductDao;
import dao.UserDao;
import entity.Order;
import entity.OrderItem;
import entity.Product;
import entity.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        User u = new User("Pedro","Iglesias","Fake@Email","Test@123", Role.Admin);
//        UserDao UDao = new UserDao();
//        UDao.createUser(u);
//
        User u = CreateUser();
        CreateOrder(u);
        CreateProduct();
        CreateOrderItem();


//        DeleteUser();
//        DeleteCart();
//        DeleteCart();
    }

    private static void CreateOrderItem() {
        OrderItem Oi = new OrderItem();
        OrderItemDao OIDao = new OrderItemDao();
        OIDao.createOrderItem(Oi);
    }

    private static User CreateUser(){
        User u = new User();
        UserDao UDao = new UserDao();
        UDao.createUser(u);
        return u;
    }

    private static void CreateOrder(User user){
        Order o = new Order(user);
        OrderDao ODao = new OrderDao();
        ODao.createOrder(o);
    }

    private static void CreateProduct(){
        Product p = new Product();
        ProductDao PDao = new ProductDao();
        PDao.createProduct(p);

    }

    private static void DeleteUser() {
        UserDao UDao = new UserDao();
        List<User> UserList = UDao.getUser();
        UDao.deleteUser(UserList.get(0));
    }

    private static void DeleteOrder() {
        OrderDao ODao = new OrderDao();
        List<Order> OrderList = ODao.getOrders();
        ODao.deleteOrder(OrderList.get(0));
    }

    private static void DeleteProduct() {
        ProductDao PDao = new ProductDao();
        List<Product> ProductList = PDao.getProduct();
        PDao.deleteProduct(ProductList.get(0));
    }
}
