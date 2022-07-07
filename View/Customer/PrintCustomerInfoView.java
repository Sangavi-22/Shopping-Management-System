package View.Customer;

public class PrintCustomerInfoView implements PrintCustomerInfoViewService{

    public void printCustomerDetails(int id, String name, String email, long mobileNum, String address) {
        System.out.println();
        System.out.println("*******************************************************");
        System.out.println("!                    PROFILE DETAILS                  !");
        System.out.println("*******************************************************");
        System.out.println("Name: "+name);
        System.out.println("Email: "+email);
        System.out.println("Mobile: "+mobileNum);
        System.out.println("Address: "+address);
        System.out.println("Customer Id: "+id);
        System.out.println("*******************************************************");
        System.out.println();
    }
}
