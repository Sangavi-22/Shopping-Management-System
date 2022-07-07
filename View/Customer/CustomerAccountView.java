package View.Customer;

import Controller.ControlCustomer.CustomerAccountControllerService;
import Inputs.InputsFromUser;

public class CustomerAccountView implements CustomerAccountViewService{
    private String name,email,address;
    private long mobileNum;
    private final InputsFromUser inputsFromUser=new InputsFromUser();
    public void inputCustomerDetails(CustomerAccountControllerService customerAccountController){
        int count=0;
        name = inputsFromUser.inputName();
        email = inputsFromUser.inputEmail();
        mobileNum = inputsFromUser.inputMobileNum();
        address=inputsFromUser.inputShippingAddress();
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
        passDetailsToController(customerAccountController);
    }
    public  void inputCustomerDetailsToUpdate(CustomerAccountControllerService customerAccountController) {
        int userChoice;
        boolean flag=true;
        while(flag){
            System.out.println("1.name  2.email  3.mobileNum  4.Address  5.save changes");
            userChoice=inputsFromUser.inputChoice();
            if(userChoice==1) {
                name = inputsFromUser.inputName();
                customerAccountController.setName(name);
            }
            else if(userChoice==2) {
                email=inputsFromUser.inputEmail();
                customerAccountController.setEmail(email);
            }
            else if(userChoice==3) {
                mobileNum=inputsFromUser.inputMobileNum();
                customerAccountController.setMobileNum(mobileNum);
            }
            else if(userChoice==4) {
                address=inputsFromUser.inputShippingAddress();
                customerAccountController.setShippingAddress(address);
            }
            else {
                flag=false;
            }
        }
    }
    public void passDetailsToController(CustomerAccountControllerService customerAccountController){
        customerAccountController.setName(name);
        customerAccountController.setEmail(email);
        customerAccountController.setMobileNum(mobileNum);
        customerAccountController.setShippingAddress(address);
    }
}
