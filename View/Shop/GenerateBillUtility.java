package View.Shop;

public class GenerateBillUtility {
    public void displayBill(int amount,int orderId){
        if(amount==0) {
            System.out.print("");
        }
        else {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Bill Amount of orderId "+orderId+" is: Rs."+amount);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }
    public void printOrderId(int orderId){
        System.out.println("Order Id: "+orderId);
    }
    public void printOrderedUser(String userName) {
        System.out.println("Order placed by: "+userName);
    }
}
