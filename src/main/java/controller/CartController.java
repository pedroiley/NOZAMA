package controller;

import dao.DaoManager;
import entity.Cart;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private DaoManager dm = new DaoManager();

    @PostMapping(path = "/cart", consumes = "application/json")
    public Cart createCart(@RequestBody Cart cart){
        Cart or = new Cart(cart.getUserId());

        dm.getCartDao().createCart(or);
        return or;
    }

    @PutMapping(path = "/cart/{cartId}", consumes = "application/json", produces = "application/json")
    public Cart updateCart(@PathVariable int cartId, @RequestBody Cart cart)
    {
        Cart c = dm.getCartDao().getCart(cartId);

        c.setUserId(cart.getUserId());
        dm.getCartDao().updateCart(c);
        return c;
    }

    @DeleteMapping(path = "/cart/{cartId}", consumes = "application/json", produces = "application/json")
    public void deleteCart(@PathVariable int cartId) {
        Cart c =  dm.getCartDao().getCart(cartId);
        dm.getCartDao().deleteCart(c);
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
