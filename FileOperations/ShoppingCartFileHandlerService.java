package FileOperations;

import Model.ShoppingCart.ShoppingCartModel;

import java.util.HashMap;

public interface ShoppingCartFileHandlerService {
    void writeToCart(String userName, HashMap<Integer,Integer> shoppingCart);
    boolean containsShoppingCart(String userName);
   ShoppingCartModel getShoppingCart(String userName);
    void removeFromCart(String userName);
}
