package controller;

import dao.DaoManager;
import entity.Cart;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Component
public class CartController {

    private DaoManager DM = new DaoManager();

    @PostMapping(path = "/cart", consumes = "application/json")
    @ResponseBody
    public void createCart(@RequestBody Map<String, Integer> body){
        Cart or = new Cart(body.get("userId"));

        DM.getCartDao().createCart(or);
    }

    @PutMapping(path = "/cart/{cartId}", consumes = "application/json")
    @ResponseBody
    public void updateCart(@PathVariable int cartId, @RequestBody Map<String, Object> body)
    {
        Cart c = DM.getCartDao().getCart(cartId);

        c.setUserId((Integer)body.get("userId"));
        DM.getCartDao().updateCart(c);
    }

    @DeleteMapping(path = "/cart/{cartId}", consumes = "application/json")
    @ResponseBody
    public void deleteCart(@PathVariable int cartId){
        Cart or2 =  DM.getCartDao().getCart(cartId);

        DM.getCartDao().deleteCart(or2);
    }

    @GetMapping (path = "/cart/{cartId}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Cart readOrder(@PathVariable int cartId)
    {
        return DM.getCartDao().getCart(cartId);
    }

    @GetMapping (path = "/cart/list", consumes = "application/json", produces= "application/json")
    @ResponseBody
    public List<Cart> readCarts()
    {
        return DM.getCartDao().getCarts();
    }
}
