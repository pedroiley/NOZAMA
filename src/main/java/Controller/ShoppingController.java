package controller;

import dao.DaoManager;
import entity.Order;
import entity.Product;
import entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import util.Role;
import util.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
@RestController

//@RequestMapping("/purchase")
public class ShoppingController {

    DaoManager DM = new DaoManager();


    public static void main(String[] args) {
        SpringApplication.run(ShoppingController.class, args);
    }
    @PostMapping(path = "/Order", consumes = "application/json")
    @ResponseBody
    public void createOrder(@RequestBody Map<String, Integer> body){
        Order or = new Order(body.get("userId"));

        DM.getOrderDao().createOrder(or);


    }





//    int memory = 0;
//    List<Product> order1 = new ArrayList<>();

//        while(memory < 1){
//            System.out.println("You can now buy something");
//            Scanner scan = new Scanner(System.in);
//            System.out.println("Enter a product or PAY");
//            String product1 = scan.next();
//          if(  product1.equals("iPhone9")){
//            Product savedProduct = DM.getProductDao().getProduct(product1);
//            Product orderedProduct = savedProduct;
//            order1.add(orderedProduct);
//            savedProduct.setAmount(savedProduct.getAmount()-1);
//            DM.getProductDao().updateProduct(savedProduct);
//            memory = 0;
//        }else if(  product1.equals("Samsung300")){
//              Product savedProduct = DM.getProductDao().getProduct(product1);
//              Product orderedProduct = savedProduct;
//              order1.add(orderedProduct);
//              savedProduct.setAmount(savedProduct.getAmount()-1);
//              DM.getProductDao().updateProduct(savedProduct);
//              memory = 0;
//          }
//          else if(  product1.equals("PAY")){
//              System.out.println("Those are your products");
//              System.out.println(order1);
//              System.out.println("The amount to pay is");
//
//                memory = 1;
//            }
//        }
//    }



    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "MiquelPuto") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/productList")
    @ResponseBody
    public List<Product> stockAvailable(){
        List<Product> productList = DM.getProductDao().getProduct();

        return productList;
    }

    @PostMapping(path = "/productList/Add", consumes = "application/json")
    @ResponseBody
    public void addProduct(@RequestBody Map<String,Object> body)
    {
        addInventoryItem(body.get("name").toString());
    }

    @PostMapping(path = "/user/create", consumes = "application/json")
    @ResponseBody
    public void CreateNewUser(@RequestBody Map<String, Object> body)
    {
        AddNewUser(body.get("username").toString(), body.get("password").toString());
    }

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

