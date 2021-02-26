package controller;

import dao.DaoManager;
import entity.Orders;
import entity.OrderItem;
import entity.User;
import entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import Enum.Role;
import Enum.Type;

@SpringBootApplication
@RestController
@ComponentScan("controller")
public class ShoppingController {

    DaoManager DM = new DaoManager();

    public static void main(String[] args) {
        SpringApplication.run(
                ShoppingController.class,
                args
        );
    }

    @DeleteMapping(path = "/cleanDatabase", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public void cleanDatabase() {
        List<User> uList = DM.getUserDao().getUser();
        for (User user : uList) {
            DM.getUserDao().deleteUser(user);
        }

        List<Orders> oList = DM.getOrderDao().getOrders();
        for (Orders orders : oList) {
            DM.getOrderDao().deleteOrder(orders);
        }

        List<OrderItem> oiList = DM.getOrderItemDao().getOrderItems();
        for (OrderItem orderItem : oiList) {
            DM.getOrderItemDao().deleteOrderItem(orderItem);
        }

        List<Product> pList = DM.getProductDao().getProducts();
        for (Product product : pList) {
            DM.getProductDao().deleteProduct(product);
        }
    }

    @PostMapping(path = "/CreateMockData", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public void createMockedData() {
        User u = new User("TestUser","TestEmail@TestEmail.com", "Test123", Role.Admin, 1000 );
        Orders o = new Orders(u.getId());
        Product TV = new Product("TV", 200, Type.TV, 999);
        OrderItem oi = new OrderItem(TV.getProductId(), o.getOrderId(), 1);

        DM.getUserDao().createUser(u);
        DM.getOrderDao().createOrder(o);
        DM.getProductDao().createProduct(TV);
        DM.getOrderItemDao().createOrderItem(oi);
    }
}

