package controller;

import dao.DaoManager;
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

//@RequestMapping("/purchase")
public class ShoppingController {

    DaoManager DM = new DaoManager();

    public static void main(String[] args) {
        SpringApplication.run(ShoppingController.class, args);
    }

    @PostMapping(path = "/user", consumes = "application/json")
    @ResponseBody
    public void CreateUser(@RequestBody Map<String, Object> body) {
        User u = new User(
                body.get("username").toString(),
                " ",
                body.get("password").toString(),
                Role.Regular,
                0
        );

        DM.getUserDao().createUser(u);
    }

    @GetMapping(path = "/user", consumes = "application/json")
    @ResponseBody
    public List<User> GetUsers() {
        return DM.getUserDao().getUsers();
    }

    @DeleteMapping(path = "/user", consumes = "application/json")
    @ResponseBody
    public void DeleteUser(@RequestBody Map<String, Object> body) {
        Long userId = Long.parseLong(body.get("id").toString());
        User u = DM.getUserDao().getUser(userId);
        DM.getUserDao().deleteUser(u);
    }

    @GetMapping("/productList")
    @ResponseBody
    public List<Product> stockAvailable() {
        List<Product> productList = DM.getProductDao().getProduct();

        return productList;
    }

    @PostMapping(path = "/productList/Add", consumes = "application/json")
    @ResponseBody
    public void addProduct(@RequestBody Map<String, Object> body) {
        addInventoryItem(body.get("name").toString());
    }


    @GetMapping("/bankAccount")
    public User updateBankAccount(User users) {
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

    private void addInventoryItem(String name) {
        name = name.toUpperCase();
        if (name.equals("TV")) {
            Product TV = new Product("TV", 200, Type.TV, 1);
            DM.getProductDao().createProduct(TV);
        } else if (name.equals("PHONE")) {
            Product Phone = new Product("Phone", 99, Type.PHONE, 1);
            DM.getProductDao().createProduct(Phone);
        } else {
            System.out.println("Product was not found.");
        }
    }
}

