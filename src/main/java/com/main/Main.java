package com.main;

import dao.*;
import entity.Order;
import entity.OrderItem;
import entity.Product;
import entity.User;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DaoManager DM = new DaoManager();

        System.out.println("This terminal is to interact and test the changes in the platform");

        Scanner scan = new Scanner(System.in);
        System.out.println("Right now you are in the main page");
        System.out.println("You need to create a user");

        System.out.println("Enter username");
        String username = scan.next();

        System.out.println("Enter password");
        String password = scan.next();

        System.out.println("Enter an email");
        String email = scan.next();

        System.out.println("Thanks, creating a new user, please wait");
        CreateUser(username, password, email);

        System.out.println("New user is created");

        User u = DM.getUserDao().getUser(2L);

        System.out.println(u);
//
//
//        System.out.println();
//        User u = new User("Pedro","Iglesias","Fake@Email","Test@123", Role.Admin);
//        UserDao UDao = new UserDao();
//        UDao.createUser(u);
//
//        User u = CreateUser();
//        CreateOrder(u);
//        CreateProduct();
//        CreateOrderItem();
//
//
//        DeleteUser();
////        DeleteCart();
////        DeleteCart();
    }
    private static void CreateOrderItem() {
        OrderItem Oi = new OrderItem();
        OrderItemDao OIDao = new OrderItemDao();
        OIDao.createOrderItem(Oi);
    }

    private static User CreateUser(String username, String password, String email){
        User u = new User(username, password, email);
        UserDao UDao = new UserDao();
        UDao.createUser(u);
        return u;
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
