package Controller;

import dao.ProductDao;
import entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@RestController

//@RequestMapping("/purchase")
public class ShoppingController {
    ProductDao pd = new ProductDao();


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
    public List<Product> stockAvailable(Product products){
        List<Product> productList = pd.getProduct();

        return productList;
    }

}

