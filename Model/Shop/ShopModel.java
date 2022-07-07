package Model.Shop;

import java.util.HashMap;

public class ShopModel {
    private final HashMap<Integer,Integer> shop=new HashMap<>();
    private static final String shopName="Mobile Galaxy";
    private static final String shopAddress="No.10 Ramaswamy Street, Chennai-12";
    private static final String contactNo="044-278920231";

    public String getShopName(){
        return shopName;
    }
    public String getShopAddress(){
        return shopAddress;
    }
    public String getContactNo(){
        return contactNo;
    }
    public void addToShop(int productId,int quantity){
        this.shop.put(productId,quantity);
    }
    public HashMap<Integer,Integer> getProductsFromShop(){
        return this.shop;
    }
}
