package com.main;

import dao.CartDao;
import dao.ProductDao;
import dao.UserDao;
import entity.Cart;
import entity.Product;
import entity.User;
import util.Role;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        User u = new User("Pedro","Iglesias","Fake@Email","Test@123", Role.Admin);
//        UserDao UDao = new UserDao();
//        UDao.createUser(u);

        CreateUser();
        CreateCart();
        CreateProduct();


//        DeleteUser();
//        DeleteCart();
//        DeleteCart();
    }

    private static void CreateUser(){
        User u = new User();
        UserDao UDao = new UserDao();
        UDao.createUser(u);
    }

    private static void CreateCart(){
        Cart c = new Cart();
        CartDao CDao = new CartDao();
        CDao.createCart(c);
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

    private static void DeleteCart() {
        CartDao CDao = new CartDao();
        List<Cart> CartList = CDao.getCart();
        CDao.deleteCart(CartList.get(0));
    }

    private static void DeleteProduct() {
        ProductDao PDao = new ProductDao();
        List<Product> ProductList = PDao.getProduct();
        PDao.deleteProduct(ProductList.get(0));
    }
}
