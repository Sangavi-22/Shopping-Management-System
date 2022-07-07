package FileOperations;

import Model.ShoppingCart.ShoppingCartModel;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrdersFileHandlerService {
    void writeOrders(int orderId,int productId,int quantity);
    int readLastOrderNum();
    void writeOrderedUsers(int orderNum, String userName, String deliveryStatus);
    String readOrderedUser(int orderId);
    ArrayList<Integer> readUserOrderId(String userName);
    ShoppingCartModel readProducts(int orderId);
    ArrayList<Integer> readAllOrderFromFile();
    HashMap<Integer, String> readStatusOfOrder(String userName);
    void updateStatusOfOrder(String userName,int orderId);
    void removeOrderFromFile(int orderId,String userName);

}
