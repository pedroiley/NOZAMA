package com.main;

import dao.*;
import entity.Order;
import entity.OrderItem;
import entity.Product;
import entity.User;
import util.Role;
import util.Type;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static DaoManager DM = new DaoManager();


    public static void main(String[] args) {


//
//        System.out.println("This terminal is to interact and test the changes in the platform");
//
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Right now you are in the main page");
//        System.out.println("You need to create a user");
//
//        System.out.println("Enter username");
//        String username = scan.next();
//
//        System.out.println("Enter password");
//        String password = scan.next();
//
//        System.out.println("Enter an email");
//        String email = scan.next();
//
//        System.out.println("Thanks, creating a new user, please wait");
//        CreateUser();
//
//        System.out.println("New user is created");
//
//        User u = DM.getUserDao().getUser(2L);
//
//        System.out.println(u);
//        fillStock();


        System.out.println("StockFilled");
        User u2 = new User("Pedro","Iglesias@gmail","root", Role.Regular, 0);
        UserDao UDao = new UserDao();
        UDao.createUser(u2);
        System.out.println(u2);

//        User u = CreateUser();
//        CreateOrder(u);
//        CreateProduct();
//        CreateOrderItem();


//        DeleteUser();
//        DeleteCart();
//        DeleteCart();
    }
    private static void CreateOrderItem() {
        OrderItem Oi = new OrderItem();
        OrderItemDao OIDao = new OrderItemDao();
        OIDao.createOrderItem(Oi);
    }

//    private static User CreateUser(String username, String password, String email, int bankAccount){
//        User u = new User(username,email, password,bankAccount);
//        UserDao UDao = new UserDao();
//        UDao.createUser(u);
//        return u;
//    }


    private static User CreateUser(){
        User u = new User();
        UserDao UDao = new UserDao();
        UDao.createUser(u);
        return u;
    }

    private static void CreateOrder(int userId){
        Order o = new Order(userId);
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

//    private static void fillStock(){
//        Product p1 = new Product(Type.TV,300,"samsung300",100);
//        Product p2 = new Product(Type.PHONE,500,"iPhone10",100);
//        ProductDao PDao = new ProductDao();
//        PDao.createProduct(p1);
//        PDao.createProduct(p2);
//    }

}
