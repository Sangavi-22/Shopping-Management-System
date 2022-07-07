package View.Seller;

import Controller.ControlSeller.SellerAccountController;
import Controller.ControlSeller.SellerAccountControllerService;
import Inputs.InputsFromUser;

public class SellerAccountView implements SellerAccountViewService{
    private String name,email;
    private long mobileNum;
    private final InputsFromUser inputsFromUser=new InputsFromUser();
    public void inputSellerDetails(SellerAccountControllerService sellerAccountController){
        int count=0;
        name = inputsFromUser.inputName();
        email = inputsFromUser.inputEmail();
        mobileNum = inputsFromUser.inputMobileNum();
        if(email.equals("-")) {
            count=count+1;
        }
        if (count == 1) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("!               Profile Completion  66%               !");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        } else {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("!      Hurray!!! Profile creation completed 100%      !");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        System.out.println();
        passDetailsToController(sellerAccountController);
    }
    public  void inputSellerDetailsToUpdate(SellerAccountController sellerAccountController) {
        int userChoice;
        boolean flag=true;
        while(flag){
            System.out.println("1.name  2.email  3.mobileNum  4.save changes");
            userChoice=inputsFromUser.inputChoice();
            if(userChoice==1) {
                name = inputsFromUser.inputName();
                sellerAccountController.setName(name);
            }
            else if(userChoice==2) {
                email=inputsFromUser.inputEmail();
                sellerAccountController.setEmail(email);
            }
            else if(userChoice==3) {
                mobileNum=inputsFromUser.inputMobileNum();
                sellerAccountController.setMobileNum(mobileNum);
            }
            else {
                flag=false;
            }
        }
    }

    public void passDetailsToController(SellerAccountControllerService sellerAccountController){
        sellerAccountController.setName(name);
        sellerAccountController.setEmail(email);
        sellerAccountController.setMobileNum(mobileNum);
    }
}
