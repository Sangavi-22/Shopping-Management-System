package Controller.ControlShop;

import Model.MobilePhone.*;
import Model.ShoppingCart.ShoppingCartModel;
import View.MobilePhone.PhoneViewService;
import View.MobilePhone.PrintPhoneInfoViewService;

import java.util.HashMap;

public interface ShopControllerService {
    void addToShop(int productId, int quantity);
    HashMap<Integer, Integer> getProductsFromShop();
    boolean displayPhones();
    void displayPhone(int id);
    int getProductIdForPhone();
    int addPhone(PhoneDetailsModel phoneDetailsModel, PhoneCameraModel phoneCameraModel, PhoneDimensionsModel phoneDimensionsModel, PhoneManufacturerModel phoneManufacturerModel, PhoneProcessorModel phoneProcessorModel,PhoneStorageCapacityModel phoneStorageCapacityModel, PhoneViewService phoneView, PrintPhoneInfoViewService printPhoneInfoView);
    boolean searchPhone(String inputValue);
    boolean containsPhone(int id);
    boolean removePhoneWithId(int id);
    boolean removePhoneWithName(String modelName);
    boolean checkStock();
    boolean updateStock(int productId,int count);
    boolean phoneAvailable(int id, int quantity);
    int addToOrders(ShoppingCartModel shoppingCart, String userName);
    boolean viewOrdersPlaced(String userName);
    boolean viewPastOrdersPlaced(String userName);
    boolean viewAllOrdersPlaced();
    void removeOrder(int orderId, String userName);
    void dispatchOrder(int orderId);
    void updateView();
}
