package Controller;
import dao.ProductDao;
import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/purchase")
public class ShoppingController {
    ProductDao pd = new ProductDao();

public void insertOrder(Product products){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a product");
    String product1 = scan.next();
    if(product1.equals("iPhone9")){
     Product savedProduct = pd.getProduct(product1);
        savedProduct.setAmount(savedProduct.getAmount()-1);
        pd.updateProduct(savedProduct);
    }

}
}
