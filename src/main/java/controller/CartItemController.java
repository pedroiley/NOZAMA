package controller;

import dao.DaoManager;
import entity.CartItem;
import entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartItemController {

    private DaoManager dm = new DaoManager();

    @PostMapping(path = "/cartItem", consumes = "application/json", produces = "application/json")
    public CartItem createCartItem( @RequestBody CartItem cartItem){

        Product p = dm.getProductDao().getProduct(cartItem.getProductId());
        CartItem oi = new CartItem(
                cartItem.getProductId(),
                cartItem.getCartId(),
                1,
                p.getPrice());

        dm.getCartItemDao().createCartItem(oi);
        return oi;
    }

    @PutMapping(path = "/cartItem/{cartItemId}", consumes = "application/json", produces = "application/json")
    public CartItem updateCartItem(@PathVariable int cartItemId , @RequestBody CartItem cartItem)
    {
        CartItem oi3 = dm.getCartItemDao().getCartItem(cartItemId);

        oi3.setCartItems(
                cartItem.getProductId(),
                 cartItem.getCartId(),
                cartItem.getQuantity(),
                cartItem.getPrice());

        dm.getCartItemDao().updateCartItem(oi3);
        return oi3;
    }

    @DeleteMapping(path = "/cartItem", consumes = "application/json", produces = "application/json")
    public void deleteCartItem(@RequestBody CartItem cartItem){
        CartItem oi2 =  dm.getCartItemDao().getCartItem(cartItem.getCartItemId());

        dm.getCartItemDao().deleteCartItem(oi2);
    }

    @GetMapping (path = "/cartItem", consumes = "application/json", produces = "application/json")
    public CartItem readCartItem(@RequestBody CartItem cartItem)
    {
        return dm.getCartItemDao().getCartItem(cartItem.getCartItemId());
    }

    @GetMapping (path = "/cartItem/list", consumes = "application/json", produces = "application/json")
    public List<CartItem> readCartItems()
    {
        return dm.getCartItemDao().getCartItems();
    }
}
