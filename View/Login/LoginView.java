package View.Login;

import Admin.*;
import Model.Users.*;
import View.Customer.*;
import View.Seller.*;
import Controller.ControlLogin.*;
import Controller.ControlSeller.*;
import Controller.ControlCustomer.*;
import Inputs.InputsFromUser;
import Verification.VerifyEmployeeId;
import Verification.VerifyEmployeeIdService;

public class LoginView implements LoginViewService {
    private final VerifyEmployeeIdService verifyEmployee=new VerifyEmployeeId();
    private final LoginUtility loginUtil=new LoginUtility();
    private final AdminControlsService adminControls=new AdminControls();
    private final InputsFromUser inputsFromUser=new InputsFromUser();
    public void homePage(){
        try {
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("|            WELCOME TO MOBILE GALAXY STORE           |");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("|                 Enter 1 to SignUp                   |");
            System.out.println("|                 Enter 2 to Login                    |");
            System.out.println("|                 Enter 3 to Login as Admin           |");
            System.out.println("|                 Enter 4 to View as guest            |");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            int userChoice=inputsFromUser.inputChoice();
            switch(HomePageOptions.values()[userChoice-1]) {
                case SIGN_UP:
                    System.out.println("________________________SIGN UP________________________");
                    System.out.println();
                    String userName=inputsFromUser.inputUserNameFirstTime();
                    while(loginUtil.isSellerPresentAlready(userName) || loginUtil.isCustomerPresentAlready(userName)){
                        System.out.println("User already exist!!!!");
                        userName = inputsFromUser.inputUserName();
                    }
                    String password=inputsFromUser.inputPasswordFirstTime();
                    int userId= adminControls.generateId("User");
                    if(userId==0) {
                        System.out.println("Unauthorized user. Could not create the account");
                        homePage();
                        break;
                    }
                    else{
                        if(userId>=1 && userId<=1000){
                            String employmentNum=inputsFromUser.inputEmployeeNum();
                            if(!(verifyEmployee.verifyEmployeeId(employmentNum))){
                                System.out.println("Sorry no records found. Could not create the account");
                                homePage();
                                break ;
                            }
                            else {
                                System.out.println("Processing........ Please Wait");
                                System.out.println();
                                System.out.println(" Your id is: " + userId);
                                System.out.println();
                                System.out.println("+++++++Taking you into your account. Please Wait+++++++");
                                System.out.println();
                                System.out.println("Please provide us a little more details to complete your profile");
                                SellerAccountModel sellerAccountModel=new SellerAccountModel();
                                SellerAccountViewService sellerAccountView = new SellerAccountView();
                                SellerMenuViewService sellerMenuView=new SellerMenuView();
                                PrintSellerInfoViewService printSellerInfoView=new PrintSellerInfoView();
                                SellerAccountControllerService sellerAccountController = new SellerAccountController(sellerAccountModel, sellerAccountView,sellerMenuView,printSellerInfoView);
                                sellerAccountController.setUserName(userName);
                                sellerAccountController.setPassword(password);
                                sellerAccountController.setUserId(userId);
                                sellerAccountController.setOtherInputs();
                                sellerAccountController.sellerMenu();
                            }

                        }
                        else if(userId>=1001 && userId<=2000) {
                            System.out.println("Processing........ Please Wait");
                            System.out.println();
                            System.out.println(" Your id is: " + userId);
                            System.out.println();
                            System.out.println("+++++++Taking you into your account. Please Wait+++++++");
                            System.out.println();
                            System.out.println("Please provide us a little more details to complete your profile");
                            CustomerAccountModel customerAccountModel = new CustomerAccountModel();
                            CustomerAccountViewService customerAccountView = new CustomerAccountView();
                            CustomerMenuViewService customerMenuView=new CustomerMenuView();
                            PrintCustomerInfoViewService printCustomerInfoView=new PrintCustomerInfoView();
                            CustomerAccountControllerService customerAccountController = new CustomerAccountController(customerAccountModel, customerAccountView,customerMenuView, printCustomerInfoView);
                            customerAccountController.setUserName(userName);
                            customerAccountController.setPassword(password);
                            customerAccountController.setUserId(userId);
                            customerAccountController.setOtherInputs();
                            customerAccountController.customerMenu();
                        }
                        else {
                            System.out.println("Sorry could not create your account");
                        }
                    }
                    homePage();
                    break;
                case LOGIN:
                    System.out.println("_______________________LOGIN IN_______________________");
                    System.out.println();
                    userName=inputsFromUser.inputUserName();
                    password=inputsFromUser.inputPassword();
                    if(loginUtil.isSellerPresentAlready(userName) && loginUtil.passwordMatchesForSeller(userName,password)){
                        SellerAccountModel sellerAccountModel= loginUtil.getSellerModel(userName);
                        SellerAccountViewService sellerAccountView = new SellerAccountView();
                        SellerMenuViewService sellerMenuView=new SellerMenuView();
                        PrintSellerInfoViewService printSellerInfoView=new PrintSellerInfoView();
                        SellerAccountControllerService sellerAccountController=new SellerAccountController(sellerAccountModel, sellerAccountView,sellerMenuView,printSellerInfoView);
                        sellerAccountController.sellerMenu();
                    }
                    else if(loginUtil.isCustomerPresentAlready(userName) && loginUtil.passwordMatchesForCustomer(userName,password)){
                        CustomerAccountModel customerAccountModel = loginUtil.getCustomerModel(userName);
                        CustomerAccountViewService customerAccountView = new CustomerAccountView();
                        CustomerMenuViewService customerMenuView=new CustomerMenuView();
                        PrintCustomerInfoViewService printCustomerInfoView=new PrintCustomerInfoView();
                        CustomerAccountControllerService customerAccountController = new CustomerAccountController(customerAccountModel, customerAccountView,customerMenuView,printCustomerInfoView);
                        customerAccountController.customerMenu();
                    }
                    else if ((loginUtil.isCustomerPresentAlready(userName)) && !(loginUtil.passwordMatchesForCustomer(userName, password))) {
                        System.out.println("Incorrect password");
                        System.out.println("Do you want to change you password 1.Yes 2.No");
                        int inputValue=inputsFromUser.inputChoice();

                        if(inputValue==1) {
                            if(inputsFromUser.inputUserId()==loginUtil.getCustomerModel(userName).getUserId()) {
                                password=inputsFromUser.inputPassword();
                                CustomerAccountModel customerAccountModel = loginUtil.getCustomerModel(userName);
                                CustomerAccountViewService customerAccountView = new CustomerAccountView();
                                CustomerMenuViewService customerMenuView=new CustomerMenuView();
                                PrintCustomerInfoViewService printCustomerInfoView=new PrintCustomerInfoView();
                                CustomerAccountControllerService customerAccountController = new CustomerAccountController(customerAccountModel, customerAccountView,customerMenuView,printCustomerInfoView);
                                customerAccountController.setPassword(password);
                                customerAccountController.updatePasswordInDataSource();
                                customerAccountController.customerMenu();
                            }
                            else {
                                System.out.println("Password cannot be changed");
                            }

                        }
                        else {
                            System.out.println("Taking you back to the main page");
                        }

                    }
                    else if(loginUtil.isSellerPresentAlready(userName) && !(loginUtil.passwordMatchesForSeller(userName,password))) {
                        System.out.println("Incorrect password");
                        System.out.println("Do you want to change you password 1.Yes 2.No");
                        int inputValue=inputsFromUser.inputChoice();
                        if(inputValue==1) {
                            if(inputsFromUser.inputUserId()==loginUtil.getSellerModel(userName).getUserId()) {
                                password=inputsFromUser.inputPassword();
                                SellerAccountModel sellerAccountModel= loginUtil.getSellerModel(userName);
                                SellerAccountViewService sellerAccountView = new SellerAccountView();
                                SellerMenuViewService sellerMenuView=new SellerMenuView();
                                PrintSellerInfoViewService printSellerInfoView=new PrintSellerInfoView();
                                SellerAccountControllerService sellerAccountController=new SellerAccountController(sellerAccountModel, sellerAccountView,sellerMenuView,printSellerInfoView);
                                sellerAccountController.setPassword(password);
                                sellerAccountController.updatePasswordInDataSource();
                                sellerAccountController.sellerMenu();
                            }
                            else {
                                System.out.println("Password cannot be changed");
                            }

                        }
                        else {
                            System.out.println("Taking you back to the main page");
                        }
                    }
                    else {
                        System.out.println("Sorry account does not exist !!!");
                        homePage();
                    }
                    homePage();
                    break;
                case ADMIN:
                    System.out.println("_________________________ADMIN_________________________");
                    System.out.println();
                    userName=inputsFromUser.inputUserName();
                    password=inputsFromUser.inputPassword();
                    if(loginUtil.isAdminPresent(userName) && loginUtil.passwordMatchesForAdmin(userName,password)){
                        boolean flag=true;
                        while(flag){
                            System.out.println();
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println("|                        WELCOME                      |");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println("|                 Enter 1 to Remove Sellers           |");
                            System.out.println("|                 Enter 2 to Remove Customers         |");
                            System.out.println("|                 Enter 3 to exit                     |");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            int userInput=inputsFromUser.inputChoice();
                            switch(userInput) {
                                case 1:
                                    System.out.println("Enter the username of the seller to remove");
                                    System.out.println();
                                    userName=inputsFromUser.inputUserName();
                                    adminControls.removeSellers(userName);
                                    break;
                                case 2:
                                    System.out.println("Enter the username of the customer to remove");
                                    System.out.println();
                                    userName=inputsFromUser.inputUserName();
                                    adminControls.removeCustomers(userName);
                                    break;
                                case 3:
                                    System.out.println("Thank you. You have been Logged out successfully");
                                    flag = false;
                                    break;
                                default:
                                    System.out.println("Taking you back to the main page");
                                    flag = false;
                                    break;
                            }
                        }
                    }
                   else {
                       System.out.println("Unauthorized user. Taking you back to the main page");
                   }
                   homePage();
                   break;
                case GUEST:
                    System.out.println("Loading........");
                    CustomerAccountModel customerAccountModel = new CustomerAccountModel();
                    CustomerAccountViewService customerAccountView = new CustomerAccountView();
                    CustomerMenuViewService customerMenuView=new CustomerMenuView();
                    PrintCustomerInfoViewService printCustomerInfoView=new PrintCustomerInfoView();
                    CustomerAccountControllerService customerAccountController = new CustomerAccountController(customerAccountModel, customerAccountView,customerMenuView,printCustomerInfoView);
                    customerAccountController.setUserName("guest");
                    customerAccountController.setPassword("guest@123");
                    userId= adminControls.generateId("guest");
                    customerAccountController.setUserId(userId);
                    customerAccountController.customerMenu();
                    homePage();
                    break;
                case DEFAULT:
                    System.out.println(" Some problem occurred !!!");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("! Please wait while we take you back to the main page !");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    homePage();
                    break;
            }
        }
         catch(ArithmeticException | NumberFormatException | NullPointerException exception) {
            System.out.println(" Some problem occurred !!!");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("! Please wait while we take you back to the main page !");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            homePage();
        }

    }
    public void removedUser(String inputValue) {
        switch (inputValue) {
            case "Customer":
                System.out.println("Customer Account has been removed");
                break;
            case "Seller":
                System.out.println("Your Account has been removed");
                homePage();
                break;
            case "Another Seller":
                System.out.println("Sorry! Account cannot be removed");
                break;
            default:
                System.out.println("Sorry! User Account does not exist");
                break;
        }
    }
    public void loggedOut(String userName){
        if(userName.equals("guest")) {
            System.out.println("Thank you for using our service");
        }
        else {
            System.out.println("Thank you. You have been Logged out successfully");
        }
        homePage();
    }

}
