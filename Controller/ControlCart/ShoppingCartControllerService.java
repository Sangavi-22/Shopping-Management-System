package Controller.ControlCart;

import Model.ShoppingCart.ShoppingCartModel;

import java.util.HashMap;

public interface ShoppingCartControllerService {
    ShoppingCartModel getShoppingCart(String userName);
    void addProductsToCart(int productId, int orderedQuantity);
    HashMap<Integer,Integer> getProductsFromCart();
    boolean phoneInCartAlready(String userName, int id);
    void addPhoneToShoppingCart(String userName, int id, int quantity);
    void removePhoneFromCart(String userName, int id);
    void updatePhoneQuantityInCart(String userName, int id, int count);
    boolean displayCart(String userName);
    void writeProductsFromCartToDataSource(String userName);
}
