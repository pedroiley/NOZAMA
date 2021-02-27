package controller;

import dao.DaoManager;
import entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import Enum.Type;

import java.util.List;
import java.util.Map;

@Component
@RestController
public class ProductController {

    private DaoManager DM = new DaoManager();

    @PostMapping(path = "/product", consumes = "application/json", produces = "application/json")
    public Product addProduct(@RequestBody Product product)
    {
        addInventoryItem(product.getName());
        return product;
    }

    @PutMapping(path = "/product/{productId}", consumes = "application/json", produces = "application/json")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product product)
    {
        Product p3 = DM.getProductDao().getProduct(productId);

        p3.setProductValues(
                product.getName(),
                product.getPrice(),
                product.getType(),
                product.getAmount());

        DM.getProductDao().updateProduct(p3);

        return p3;
    }

    @DeleteMapping(path = "/product", consumes = "application/json", produces = "application/json")
    public void deleteProduct(@RequestBody Product product){
        Product p =  DM.getProductDao().getProduct(product.getProductId());

        DM.getProductDao().deleteProduct(p);
    }

    @GetMapping(path = "/product/list", consumes = "application/json", produces = "application/json")
    public List<Product> stockAvailable(){
        return DM.getProductDao().getProducts();
    }

    @GetMapping(path = "product/{productId}", consumes = "application/json", produces = "application/json")
    public Product findProduct(@PathVariable int productId) {
        return DM.getProductDao().getProduct(productId);
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

    private void IsProductCreated(String name) {
        name.toUpperCase();
        Product p = DM.getProductDao().getProduct(name);
    }
}
