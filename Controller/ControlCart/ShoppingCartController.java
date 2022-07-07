package Controller.ControlCart;

import DataStorage.DataSource;
import DataStorage.DataSourceService;
import Model.MobilePhone.*;
import Model.ShoppingCart.ShoppingCartModel;
import View.MobilePhone.PhoneView;
import View.MobilePhone.PhoneViewService;
import View.MobilePhone.PrintPhoneInfoView;
import View.MobilePhone.PrintPhoneInfoViewService;
import Controller.ControlMobilePhone.PhoneController;
import Controller.ControlMobilePhone.PhoneControllerService;

import java.util.HashMap;

public class ShoppingCartController implements ShoppingCartControllerService{
    private  ShoppingCartModel model;
    private final DataSourceService dataSource= DataSource.getInstance();
    public ShoppingCartController(ShoppingCartModel model){
        this.model=model;
    }
    public ShoppingCartModel getShoppingCart(String userName){
        if(this.getProductsFromCart().size()==0 && dataSource.containsCart(userName)) {
            this.model = dataSource.getCart(userName);
        }
        return this.model;
    }
    public void addProductsToCart(int productId,int quantity){
        this.model.addProductsToCart(productId,quantity);
    }
    public HashMap<Integer,Integer> getProductsFromCart(){
        return this.model.getProductsFromCart();
    }
    public boolean phoneInCartAlready(String userName,int id){
        if(this.getProductsFromCart().size()==0 && dataSource.containsCart(userName)) {
            this.model = dataSource.getCart(userName);
        }
        return this.getProductsFromCart().containsKey(id) && this.getProductsFromCart().get(id)!=0;
    }
    public void addPhoneToShoppingCart(String userName, int productId, int orderedQuantity) {
        if(this.getProductsFromCart().size()==0 && dataSource.containsCart(userName)) {
            this.model = dataSource.getCart(userName);
        }
        this.addProductsToCart(productId,orderedQuantity);

    }
    public void removePhoneFromCart(String userName,int productId){
        if(this.getProductsFromCart().size()==0 && dataSource.containsCart(userName)) {
            this.model = dataSource.getCart(userName);
        }
        this.addProductsToCart(productId,0);
    }
    public void updatePhoneQuantityInCart(String userName,int productId,int count){
        if(this.getProductsFromCart().size()==0 && dataSource.containsCart(userName)) {
            this.model = dataSource.getCart(userName);
        }
        this.addProductsToCart(productId,count);
    }
    public boolean displayCart(String userName){
        boolean flag=false;
        if(this.getProductsFromCart().size()==0 && dataSource.containsCart(userName)) {
            this.model = dataSource.getCart(userName);
        }
        HashMap<Integer,Integer>productsInCart=this.getProductsFromCart();
        for(int productIds: productsInCart.keySet()) {
            if(productsInCart.get(productIds)!=0) {
                PhoneDetailsModel phoneDetailsModel = dataSource.getParticularPhone(productIds);
                PhoneManufacturerModel phoneManufacturerModel = dataSource.getParticularPhoneWithManufacturer(productIds);
                PhoneDimensionsModel phoneDimensionsModel = dataSource.getParticularPhoneWithDimensions(productIds);
                PhoneCameraModel phoneCameraModel = dataSource.getParticularPhoneWithCamera(productIds);
                PhoneProcessorModel phoneProcessorModel = dataSource.getParticularPhoneWithProcessor(productIds);
                PhoneStorageCapacityModel phoneStorageCapacityModel=dataSource.getParticularPhoneWithStorageCapacity(productIds);
                PhoneViewService phoneView = new PhoneView();
                PrintPhoneInfoViewService printPhoneInfoView = new PrintPhoneInfoView();
                PhoneControllerService phoneController = new PhoneController(phoneDetailsModel, phoneCameraModel, phoneDimensionsModel, phoneManufacturerModel, phoneProcessorModel,phoneStorageCapacityModel, phoneView, printPhoneInfoView);
                phoneController.printBasicInfo();
                phoneController.printOrderedQuantity(productsInCart.get(productIds));
                flag=true;
            }
        }
        return flag;
    }
    public void writeProductsFromCartToDataSource(String userName){
        dataSource.writeToCartFile(userName,this.getProductsFromCart());
    }

}
