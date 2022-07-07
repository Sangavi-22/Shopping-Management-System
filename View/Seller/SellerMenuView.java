package View.Seller;

import Model.Login.LoginModel;
import Model.MobilePhone.*;
import Model.Shop.ShopModel;
import View.Login.LoginView;
import View.Login.LoginViewService;
import View.MobilePhone.PhoneView;
import View.MobilePhone.PhoneViewService;
import View.MobilePhone.PrintPhoneInfoView;
import View.MobilePhone.PrintPhoneInfoViewService;
import View.Shop.PrintShopInfoView;
import View.Shop.PrintShopInfoViewService;
import View.Shop.ShopView;
import Controller.ControlLogin.LoginController;
import Controller.ControlLogin.LoginControllerService;
import Controller.ControlSeller.SellerAccountControllerService;
import Controller.ControlShop.ShopController;
import Controller.ControlShop.ShopControllerService;
import Inputs.InputsFromUser;

public class SellerMenuView implements SellerMenuViewService{
    private final ShopModel shopModel=new ShopModel();
    private final ShopView shopView=new ShopView();
    private final PrintShopInfoViewService printShopInfoView=new PrintShopInfoView();
    private final ShopControllerService shopController=new ShopController(shopModel,shopView,printShopInfoView);
    private SellerAccountControllerService sellerAccountController;
    private final InputsFromUser inputsFromUser=new InputsFromUser();

    public void setController(SellerAccountControllerService sellerAccountController){
        this.sellerAccountController=sellerAccountController;
    }
    public void sellerMenu(){
        try {
            System.out.println();
            System.out.println("*******************************************************");
            System.out.println("!                        MENU                         !");
            System.out.println("*******************************************************");
            System.out.println("!             Enter 1 to view Products                !");
            System.out.println("!             Enter 2 to add Products                 !");
            System.out.println("!             Enter 3 to remove Products              !");
            System.out.println("!             Enter 4 to search Products              !");
            System.out.println("!             Enter 5 to view Orders                  !");
            System.out.println("!             Enter 6 to Check Stock                  !");
            System.out.println("!             Enter 7 to view profile                 !");
            System.out.println("!             Enter 8 to update profile               !");
            System.out.println("!             Enter 9 to Remove Customer Account      !");
            System.out.println("!             Enter 10 to Logout                      !");
            System.out.println("*******************************************************");
            System.out.println();
            int userChoice=inputsFromUser.inputChoice();
            switch (SellerMenuOptions.values()[userChoice - 1]) {
                case VIEW_PRODUCTS:
                    boolean flag=true;
                    while(flag) {
                        System.out.println("+++++++++++++++++++ LIST Of PRODUCTS ++++++++++++++++++");
                        System.out.println();
                        if(!(shopController.displayPhones())){
                            System.out.println("No products available");
                            System.out.println();
                            System.out.println("+++++++++++++++ END OF LIST OF PRODUCTS ++++++++++++++++");
                            flag=false;
                            break;
                        }
                        else {
                            System.out.println("++++++++++++++++END OF LIST OF PRODUCTS+++++++++++++++++");
                            System.out.println();
                            System.out.println("Enter a product id from the list to know about them in detail");
                            System.out.println();
                            int id = inputsFromUser.inputProductId();
                            if(shopController.containsPhone(id)) {
                                shopController.displayPhone(id);
                            }
                            else {
                                System.out.println("Sorry phone not available");
                                System.out.println();
                            }
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println("   Do you want to go back to the list?  1.Yes  2.No    ");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println();
                            userChoice = inputsFromUser.inputChoice();
                            if (userChoice == 1) {
                                continue;
                            }
                            else {
                                flag = false;
                                break;
                            }
                        }
                    }
                    sellerMenu();
                    break;
                case ADD_PRODUCTS:
                    System.out.println("++++++++++++++++++++ ADD PRODUCTS +++++++++++++++++++++");
                    System.out.println();
                    System.out.println("Enter only values without any units");
                    System.out.println();
                    PhoneDetailsModel phoneDetailsModel = new PhoneDetailsModel();
                    PhoneManufacturerModel phoneManufacturerModel = new PhoneManufacturerModel();
                    PhoneDimensionsModel phoneDimensionsModel = new PhoneDimensionsModel();
                    PhoneCameraModel phoneCameraModel = new PhoneCameraModel();
                    PhoneProcessorModel phoneProcessorModel = new PhoneProcessorModel();
                    PhoneStorageCapacityModel phoneStorageCapacityModel=new PhoneStorageCapacityModel();
                    PhoneViewService phoneView = new PhoneView();
                    PrintPhoneInfoViewService printPhoneInfoView = new PrintPhoneInfoView();
                    switch(shopController.addPhone(phoneDetailsModel, phoneCameraModel, phoneDimensionsModel, phoneManufacturerModel, phoneProcessorModel,phoneStorageCapacityModel, phoneView, printPhoneInfoView)) {
                        case 1:
                            System.out.println("Phone added successfully");
                            System.out.println();
                            System.out.println("++++++++++++++++++ END OF ADD PRODUCTS ++++++++++++++++");
                            break;
                        case 2:
                            System.out.println("  Phone present in shop already. Quantity incremented  ");
                            System.out.println();
                            System.out.println("++++++++++++++++++ END OF ADD PRODUCTS ++++++++++++++++");
                            break;
                        case 3:
                            System.out.println(" Please wait!!! Taking you back to the menu");
                            break;
                        default:
                            System.out.println("Phone cannot be added");
                            System.out.println();
                            System.out.println("++++++++++++++++++ END OF ADD PRODUCTS ++++++++++++++++");
                            break;
                    }
                    sellerMenu();
                    break;
                case REMOVE_PRODUCTS:
                    System.out.println("+++++++++++++++++++ REMOVE PRODUCTS +++++++++++++++++++");
                    System.out.println();
                    System.out.println("1.Remove products by id\n2.Remove products by name");
                    int userInput = inputsFromUser.inputChoice();
                    if (userInput == 1) {
                        int id=inputsFromUser.inputProductId();
                        if(shopController.removePhoneWithId(id)) {
                            System.out.println("Phone has been removed");

                        }
                        else {
                            System.out.println("No records available");
                        }
                    }
                    else if (userInput == 2) {
                        String modelName=inputsFromUser.inputModelName();
                        if(shopController.removePhoneWithName(modelName)) {
                            System.out.println("Phone has been removed");
                        }
                        else {
                            System.out.println("No other records available");
                        }
                    }
                    else {
                        System.out.println("Invalid input. Taking you back to menu");
                    }
                    System.out.println();
                    System.out.println("++++++++++++++++++ END OF ADD PRODUCTS ++++++++++++++++");
                    sellerMenu();
                    break;
                case SEARCH_PRODUCTS:
                    System.out.println("++++++++++++++++++++ SEARCH PRODUCTS ++++++++++++++++++");
                    System.out.println();
                    System.out.println("Enter something to search");
                    String inputValue=inputsFromUser.inputValue();
                    if(shopController.searchPhone(inputValue)) {
                        System.out.println("Searching completed");
                    }
                    else {
                        System.out.println("No records found");
                    }
                    System.out.println();
                    System.out.println("+++++++++++++++ END OF SEARCH PRODUCTS ++++++++++++++++");
                    sellerMenu();
                    break;
                case VIEW_ORDERS:
                    System.out.println("++++++++++++++++++++ LIST OF ORDERS +++++++++++++++++++");
                    if(shopController.viewAllOrdersPlaced()) {
                        System.out.println();
                        System.out.println("Do you want to dispatch any order? 1.Yes 2.No");
                        userInput=inputsFromUser.inputChoice();
                        if(userInput==1) {
                            int orderId=inputsFromUser.inputOrderId();
                            shopController.dispatchOrder(orderId);
                            System.out.println("Order dispatched successfully...");
                        }
                        else {
                            System.out.println("Taking you back to the menu");
                            System.out.println();
                        }
                    }
                    else {
                        System.out.println();
                        System.out.println("No orders placed till now");
                    }
                    System.out.println();
                    System.out.println("+++++++++++++++++ END OF ORDERS LIST ++++++++++++++++++");
                    sellerMenu();
                    break;
                case CHECK_STOCK:
                    System.out.println("++++++++++ LIST OF PRODUCTS WITH NILL STOCK +++++++++++");
                    System.out.println();
                    if(shopController.checkStock()) {
                        System.out.println();
                        System.out.println("Enter a product id from above list to update quantity: ");
                        int productId = inputsFromUser.inputProductId();
                        int quantity=inputsFromUser.inputCount();
                        if(shopController.updateStock(productId,quantity)){
                            System.out.println("Quantity updated");
                            System.out.println();
                        }
                        else{
                            System.out.println("Cannot update quantity");
                            System.out.println();
                        }
                    }
                    else {
                        System.out.println("No records found");
                        System.out.println();
                    }
                    System.out.println("+++++++++++++++++++++ END OF LIST +++++++++++++++++++++");
                    System.out.println();
                    sellerMenu();
                    break;
                case VIEW_PROFILE:
                    this.sellerAccountController.updateView();
                    sellerMenu();
                    break;
                case UPDATE_PROFILE:
                    this.sellerAccountController.updateProfile();
                    this.sellerAccountController.updateView();
                    sellerMenu();
                    break;
                case REMOVE_CUSTOMER_ACCOUNT:
                    System.out.println("++++++++++++++++++++++ REMOVE USER +++++++++++++++++++");
                    System.out.println();
                    String userName = inputsFromUser.inputUserName();
                    LoginViewService loginView = new LoginView();
                    LoginModel loginModel = new LoginModel();
                    LoginControllerService loginController = new LoginController(loginModel,loginView);
                    loginController.setAccountName(sellerAccountController.getUserName());
                    loginController.removeUser(userName);
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println();
                    sellerMenu();
                    break;
                case LOGOUT:
                    loginView = new LoginView();
                    loginModel = new LoginModel();
                    loginController = new LoginController(loginModel, loginView);
                    loginController.logOut(sellerAccountController.getUserName());
                    break;
                case DEFAULT:
                    System.out.println(" Invalid input.");
                    System.out.println(" Please wait!!! Taking you back to the menu");
                    sellerMenu();
                    break;

            }
        }
        catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(" Some problem occurred !!!");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("!   Please wait while we take you back to the menu    !");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            sellerMenu();
        }
    }
}
