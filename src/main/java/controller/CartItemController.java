package controller;

import dao.DaoManager;
import entity.CartItem;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CartItemController {

    private DaoManager DM = new DaoManager();

    @PostMapping(path = "/cartItem", consumes = "application/json", produces = "application/json")
    public void createCartItem( @RequestBody CartItem cartItem){
        CartItem oi = new CartItem(
                cartItem.getProductId(),
                cartItem.getCartId(),
                1);

        DM.getCartItemDao().createCartItem(oi);
    }

    @PutMapping(path = "/cartItem/{cartItemId}", consumes = "application/json", produces = "application/json")
    public void updateCartItem(@PathVariable int cartItemId , @RequestBody Map<String, Object> body)
    {
        CartItem oi3 = DM.getCartItemDao().getCartItem(cartItemId);

        oi3.setCartItems(
                (int)body.get("productId"),
                (int)body.get("cartId"),
                (int)body.get("quantity") );

        DM.getCartItemDao().updateCartItem(oi3);
    }

    @DeleteMapping(path = "/cartItem", consumes = "application/json", produces = "application/json")
    public void deleteCartItem(@RequestBody Map<String, Integer> body){
        CartItem oi2 =  DM.getCartItemDao().getCartItem(body.get("cartItemId"));

        DM.getCartItemDao().deleteCartItem(oi2);
    }

    @GetMapping (path = "/cartItem", consumes = "application/json", produces = "application/json")
    public CartItem readCartItem(@RequestBody Map<String, Object> body)
    {
        return DM.getCartItemDao().getCartItem((int)body.get("cartItemId"));
    }

    @GetMapping (path = "/cartItem/list", consumes = "application/json", produces = "application/json")
    public List<CartItem> readCartItems()
    {
        return DM.getCartItemDao().getCartItems();
    }
}
