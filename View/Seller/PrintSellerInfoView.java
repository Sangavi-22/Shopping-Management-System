package View.Seller;

public class PrintSellerInfoView implements PrintSellerInfoViewService{
    public void printSellerDetails(int userId, String name, String email, long mobileNum) {
        System.out.println();
        System.out.println("*******************************************************");
        System.out.println("!                    PROFILE DETAILS                  !");
        System.out.println("*******************************************************");
        System.out.println("Name: "+name);
        System.out.println("Email: "+email);
        System.out.println("Mobile: "+mobileNum);
        System.out.println("Seller Id: "+userId);
        System.out.println("*******************************************************");
        System.out.println();
    }
}
