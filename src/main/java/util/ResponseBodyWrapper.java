package util;

import entity.CartItem;

import java.util.List;

public class ResponseBodyWrapper {

    private String message;

    public ResponseBodyWrapper(String messageValue) {
        this.message = messageValue;
    }

    public void setMessageValue(String message) {
        this.message = this.message + "\r\n" + message;
    }

    public void EnlistCartsAndPrice(List<CartItem> cartItemToPurchaseList) {
        int totalPrice = 0;
        for (CartItem cartItemToPurchase:cartItemToPurchaseList) {
            setMessageValue(cartItemToPurchase.toString());
        }

        for (CartItem cartItemToPurchase:cartItemToPurchaseList) {
            totalPrice = totalPrice + cartItemToPurchase.getPrice();
        }
        String totalPriceS = "Total Price of the cart is " + totalPrice;
        setMessageValue(totalPriceS);
    }


    @Override
    public String toString() {
        return "{" + '\'' +
                "message='" + message + '\'' +
                '}';
    }
}
