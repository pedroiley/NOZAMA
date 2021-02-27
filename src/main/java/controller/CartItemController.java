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
    public CartItem createCartItem( @RequestBody CartItem cartItem){
        CartItem oi = new CartItem(
                cartItem.getProductId(),
                cartItem.getCartId(),
                1);

        DM.getCartItemDao().createCartItem(oi);
        return oi;
    }

    @PutMapping(path = "/cartItem/{cartItemId}", consumes = "application/json", produces = "application/json")
    public CartItem updateCartItem(@PathVariable int cartItemId , @RequestBody CartItem cartItem)
    {
        CartItem oi3 = DM.getCartItemDao().getCartItem(cartItemId);

        oi3.setCartItems(
                cartItem.getProductId(),
                 cartItem.getCartId(),
                cartItem.getQuantity());

        DM.getCartItemDao().updateCartItem(oi3);
        return oi3;
    }

    @DeleteMapping(path = "/cartItem", consumes = "application/json", produces = "application/json")
    public CartItem deleteCartItem(@RequestBody CartItem cartItem){
        CartItem oi2 =  DM.getCartItemDao().getCartItem(cartItem.getCartItemId());

        DM.getCartItemDao().deleteCartItem(oi2);
        return oi2;
    }

    @GetMapping (path = "/cartItem", consumes = "application/json", produces = "application/json")
    public CartItem readCartItem(@RequestBody CartItem cartItem)
    {
        return DM.getCartItemDao().getCartItem(cartItem.getCartItemId());
    }

    @GetMapping (path = "/cartItem/list", consumes = "application/json", produces = "application/json")
    public List<CartItem> readCartItems()
    {
        return DM.getCartItemDao().getCartItems();
    }
}
