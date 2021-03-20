//package com.controller;
//
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import com.dao.DaoManager;
//import com.entity.Cart;
//import com.entity.CartItem;
//import com.entity.User;
//import com.entity.Product;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.web.bind.annotation.*;
//
//import java.com.util.List;
//import com.Enum.Role;
//import com.Enum.Type;
//
//@SpringBootApplication
//@RestController
//@ComponentScan("com.controller")
//public class ShoppingController {
//
//    DaoManager DM = new DaoManager();
//
//    public static void main(String[] args) {
//        SpringApplication.run(
//                ShoppingController.class,
//                args
//        );
//    }
//
//    @DeleteMapping(path = "/cleanDatabase", consumes = "application/json", produces = "application/json")
//    public void cleanDatabase() {
//        List<User> uList = DM.getUserDao().getUser();
//        for (User user : uList) {
//            DM.getUserDao().deleteUser(user);
//        }
//
//        List<Cart> oList = DM.getCartDao().getCarts();
//        for (Cart cart : oList) {
//            DM.getCartDao().deleteCart(cart);
//        }
//
//        List<CartItem> oiList = DM.getCartItemDao().getCartItems();
//        for (CartItem cartItem : oiList) {
//            DM.getCartItemDao().deleteCartItem(cartItem);
//        }
//
//        List<Product> pList = DM.getProductDao().getProducts();
//        for (Product product : pList) {
//            DM.getProductDao().deleteProduct(product);
//        }
//    }
//
//    @PostMapping(path = "/createMockData", consumes = "application/json", produces = "application/json")
//    public void createMockedData() {
//        User u = new User("TestUser","TestEmail@TestEmail.com", "Test123", Role.Admin, 1000 );
//        DM.getUserDao().createUser(u);
//        Cart c = new Cart(u.getId());
//        DM.getCartDao().createCart(c);
//        Product TV = new Product("TV", 200, Type.TV, 999);
//        DM.getProductDao().createProduct(TV);
//        CartItem ci = new CartItem(TV.getProductId(), c.getCartId(), 1, TV.getPrice());
//        DM.getCartItemDao().createCartItem(ci);
//    }
//
//
//}
//
