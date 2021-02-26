package controller;

import dao.DaoManager;
import entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import util.Type;

import java.util.List;
import java.util.Map;

@Component
@RestController
public class ProductController {

    private DaoManager DM = new DaoManager();

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


//    ------------------------------HELPERS-----------------------------------
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
