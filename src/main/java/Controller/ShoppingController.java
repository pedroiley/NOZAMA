package controller;

import dao.DaoManager;
import entity.Order;
import entity.OrderItem;
import entity.Product;
import entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import util.Role;
import util.Type;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class ShoppingController {

    DaoManager DM = new DaoManager();

    public static void main(String[] args) {
        SpringApplication.run(ShoppingController.class, args);
    }
//    -----------------------------------Order--------------------------------------------------------------

    @PostMapping(path = "/Order", consumes = "application/json")
    @ResponseBody
    public void createOrder(@RequestBody Map<String, Integer> body){
        Order or = new Order(body.get("userId"));

        DM.getOrderDao().createOrder(or);
    }

    @PostMapping(path = "/Order", consumes = "application/json")
    @ResponseBody
    public void updateOrder(@RequestBody Map<String, Object> body)
    {
        Order o = DM.getOrderDao().getOrder((Long)body.get("orderId"));

        o.setUserId((Integer)body.get("userId"));
        DM.getOrderDao().updateOrder(o);
    }

    @DeleteMapping(path = "/Order", consumes = "application/json")
    @ResponseBody
    public void deleteOrder(@RequestBody Map<String, Long> body){
      Order or2 =  DM.getOrderDao().getOrder(body.get("orderId"));

        DM.getOrderDao().deleteOrder(or2);
    }

    @GetMapping (path = "/Order", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Order readOrder(@RequestBody Map<String, Object> body)
    {
        return DM.getOrderDao().getOrder((Long)body.get("orderId"));
    }

    @GetMapping (path = "/Orders")
    @ResponseBody
    public List<Order> readOrders()
    {
        return DM.getOrderDao().getOrders();
    }

//-------------------------------------------Product------------------------------------

    @PostMapping(path = "/product", consumes = "application/json")
    @ResponseBody
    public void addProduct(@RequestBody Map<String,Object> body)
    {
        addInventoryItem(body.get("name").toString());
    }

    @PutMapping(path = "/product/{productId}", consumes = "application/json")
    @ResponseBody
    public void updateProduct(@PathVariable long productId, @RequestBody Map<String, Object> body)
    {
        Product p = new Product(body.get("name").toString(), (Integer)body.get("price"), (Type)body.get("Type"), (Integer)body.get("amount"));
        DM.getProductDao().updateProduct(productId, p);
    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> stockAvailable(){
        return DM.getProductDao().getProduct();
    }

    @PostMapping(path = "/user", consumes = "application/json")
    @ResponseBody
    public void CreateNewUser(@RequestBody Map<String, Object> body)
    {
        AddNewUser(body.get("username").toString(), body.get("password").toString());
    }

    @DeleteMapping(path = "/user", consumes = "application/json")
    @ResponseBody
    public void deleteUser(@RequestBody Map<String, Long> body){

     User   u1 = DM.getUserDao().getUser(body.get("userId"));

        DM.getUserDao().deleteUser(u1);
    }

//    -----------------------------------Order Item---------------------------------

    @PostMapping(path = "/OrderItem", consumes = "application/json")
    @ResponseBody
    public void createOrderItem(@RequestBody Map<String, Object> body){
        OrderItem oi = new OrderItem((Integer)body.get("productId"), (Integer)body.get("orderId"),1);

        DM.getOrderItemDao().createOrderItem(oi);
    }

    @DeleteMapping(path = "/OrderItem", consumes = "application/json")
    @ResponseBody
    public void deleteOrderItem(@RequestBody Map<String, Long> body){
        OrderItem oi2 =  DM.getOrderItemDao().getOrderItem(body.get("orderItemId"));

        DM.getOrderItemDao().deleteOrderItem(oi2);
    }

    @PostMapping(path = "/OrderItem", consumes = "application/json")
    @ResponseBody
    public void updateOrderItem(@RequestBody Map<String, Object> body)
    {
        OrderItem oi3 = DM.getOrderItemDao().getOrderItem((Long)body.get("orderItemId"));

        oi3.setOrderItemId((Long)body.get("orderItemId"));
        DM.getOrderItemDao().updateOrderItem(oi3);
    }

    @GetMapping (path = "/OrderItem", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public OrderItem readOrderItem(@RequestBody Map<String, Object> body)
    {
        return DM.getOrderItemDao().getOrderItem((Long)body.get("orderItemId"));
    }

    @GetMapping (path = "/OrderItems")
    @ResponseBody
    public List<OrderItem> readOrderItems()
    {
        return DM.getOrderItemDao().getOrderItems();
    }

//----------------------------------------Other--------------------------------------



    @GetMapping("/bankAccount")
    public User updateBankAccount(User users){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an ID");
        long id1 = scan.nextLong();
        User user = DM.getUserDao().getUser(id1);
        System.out.println(user);
        Scanner scanAmount = new Scanner(System.in);
        System.out.println("Enter a quantity");
        int amount1 = scanAmount.nextInt();
        user.setBankAccount(user.getBankAccount() + amount1);
        DM.getUserDao().updateUser(user);
        return user;

    }

    private void addInventoryItem(String name)
    {
        name = name.toUpperCase();
        if(name.equals("TV"))
        {
            Product TV = new Product("TV", 200, Type.TV, 1);
            DM.getProductDao().createProduct(TV);
        }
        else if (name.equals("PHONE"))
        {
            Product Phone = new Product("Phone", 99, Type.PHONE,1);
            DM.getProductDao().createProduct(Phone);
        }
        else
        {
            System.out.println("Product was not found.");
        }
    }

    private void AddNewUser(String username, String password)
    {
        User u = new User(username," ", password, Role.Regular, 0);
        DM.getUserDao().createUser(u);
    }

}

