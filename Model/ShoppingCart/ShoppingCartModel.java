package Model.ShoppingCart;

import java.util.HashMap;

public class ShoppingCartModel {
    private final HashMap<Integer,Integer>cart=new HashMap<>();
    public void addProductsToCart(int productId,int orderedQuantity) {
        cart.put(productId,orderedQuantity);
    }
    public HashMap<Integer,Integer>getProductsFromCart() {
        return cart;
    }
}
