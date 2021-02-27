package controller;

import dao.DaoManager;
import entity.Cart;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CartController {

    private DaoManager dm = new DaoManager();

    @PostMapping(path = "/cart", consumes = "application/json")
    public void createCart(@RequestBody Cart cart){
        Cart or = new Cart(cart.getUserId());

        dm.getCartDao().createCart(or);
    }

    @PutMapping(path = "/cart/{cartId}", consumes = "application/json")
    public void updateCart(@PathVariable int cartId, @RequestBody Map<String, Object> body)
    {
        Cart c = dm.getCartDao().getCart(cartId);

        c.setUserId((Integer)body.get("userId"));
        dm.getCartDao().updateCart(c);
    }

    @DeleteMapping(path = "/cart/{cartId}", consumes = "application/json")
    public void deleteCart(@PathVariable int cartId){
        Cart or2 =  dm.getCartDao().getCart(cartId);

        dm.getCartDao().deleteCart(or2);
    }

    @GetMapping (path = "/cart/{cartId}", consumes = "application/json", produces = "application/json")
    public Cart readCart(@PathVariable int cartId)
    {
        return dm.getCartDao().getCart(cartId);
    }

    @GetMapping (path = "/cart/list", consumes = "application/json", produces= "application/json")
    public List<Cart> readCarts()
    {
        return dm.getCartDao().getCarts();
    }
}
