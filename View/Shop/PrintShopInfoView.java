package View.Shop;

public class PrintShopInfoView implements PrintShopInfoViewService {
    public void printShopDetails(String shopName, String shopAddress, String contactNo){
        System.out.println();
        System.out.println("*******************************************************");
        System.out.println("!                   SHOP DETAILS                      !");
        System.out.println("*******************************************************");
        System.out.println("Shop Name: "+shopName);
        System.out.println("Address: "+shopAddress);
        System.out.println("Contact Num: "+contactNo);
        System.out.println("*******************************************************");
        System.out.println();
    }

}
