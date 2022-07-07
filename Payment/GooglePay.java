package Payment;
public class GooglePay implements UPIPayments,PaymentOperation{
    public void transferAmount(String accountId){
        System.out.println("Thank you for using GooglePay. Amount sent successfully");
        claimScratchCard();
    }
    public void claimScratchCard() {
        System.out.println("You have received a reward");
    }
}
