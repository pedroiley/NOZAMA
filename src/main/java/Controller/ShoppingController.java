package controller;

import dao.DaoManager;
import entity.Product;
import entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import util.Type;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@RestController

//@RequestMapping("/purchase")
public class ShoppingController {

    DaoManager DM = new DaoManager();


    public static void main(String[] args) {
        SpringApplication.run(ShoppingController.class, args);
    }
//
//    public void insertOrder(Product products){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter a product");
//        String product1 = scan.next();
//        if(product1.equals("iPhone9")){
//            Product savedProduct = pd.getProduct(product1);
//            savedProduct.setAmount(savedProduct.getAmount()-1);
//            pd.updateProduct(savedProduct);
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

    @PostMapping("/productList/Add")
    public void addProduct(@RequestBody String name)
    {
        addInventoryItem(name);
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
}

