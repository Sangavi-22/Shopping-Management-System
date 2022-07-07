package FileOperations;

import java.util.HashMap;

public interface ShopFileHandlerService {
    void writeProductToShop(int productId, int quantity);
    HashMap<Integer, Integer> readProducts();
    void updateProductInShop(int id, int quantity);
    void removePhoneFromShop(int id);
}
