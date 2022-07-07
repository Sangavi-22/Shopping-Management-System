package View.Customer;

import Controller.ControlCart.ShoppingCartController;
import Controller.ControlCart.ShoppingCartControllerService;
import Model.Login.LoginModel;
import Model.Shop.ShopModel;
import Model.ShoppingCart.ShoppingCartModel;
import View.Login.LoginView;
import View.Login.LoginViewService;
import View.Shop.PrintShopInfoView;
import View.Shop.PrintShopInfoViewService;
import View.Shop.ShopView;
import Controller.ControlCustomer.CustomerAccountControllerService;
import Controller.ControlLogin.LoginController;
import Controller.ControlLogin.LoginControllerService;
import Controller.ControlLogin.LoginUtility;
import Controller.ControlShop.ShopController;
import Controller.ControlShop.ShopControllerService;
import Inputs.InputsFromUser;
import Payment.Card;
import Payment.GooglePay;
import Payment.PaymentOperation;

public class CustomerMenuView implements CustomerMenuViewService{
    private final LoginUtility loginUtil=new LoginUtility();
    private final ShopModel shopModel=new ShopModel();
    private final ShopView shopView=new ShopView();
    private final PrintShopInfoViewService printShopInfoView=new PrintShopInfoView();
    private final ShopControllerService shopController=new ShopController(shopModel,shopView,printShopInfoView);
    private final ShoppingCartModel shoppingCartModel=new ShoppingCartModel();
    private final ShoppingCartControllerService shoppingCartController=new ShoppingCartController(shoppingCartModel);
    private CustomerAccountControllerService customerAccountController;
    private final InputsFromUser inputsFromUser=new InputsFromUser();
    public void setController(CustomerAccountControllerService customerAccountController){
        this.customerAccountController=customerAccountController;
    }
    public void customerMenu() {
        try {
            System.out.println();
            System.out.println("*********************************************************");
            System.out.println("!                         MENU                          !");
            System.out.println("*********************************************************");
            System.out.println("!                Enter  1 to view Products              !");
            System.out.println("!                Enter  2 to view cart                  !");
            System.out.println("!                Enter  3 to remove from cart           !");
            System.out.println("!                Enter  4 to update quantity in cart    !");
            System.out.println("!                Enter  5 to search products            !");
            System.out.println("!                Enter  6 to Track Orders               !");
            System.out.println("!                Enter  7 to remove an order            !");
            System.out.println("!                Enter  8 to view history of orders     !");
            System.out.println("!                Enter  9 to view Profile               !");
            System.out.println("!                Enter  10 to update profile            !");
            System.out.println("!                Enter  11 to view Shop Details         !");
            System.out.println("!                Enter  12 to Exit                      !");
            System.out.println("*********************************************************");
            System.out.println();
            int userChoice=inputsFromUser.inputChoice();
            switch(CustomerActions.values()[userChoice - 1]) {
                case VIEW_PRODUCTS:
                    boolean flag=true;
                    while(flag) {
                        System.out.println("+++++++++++++++++++ LIST OF PRODUCTS ++++++++++++++++++");
                        System.out.println();
                        if(!shopController.displayPhones()){
                            System.out.println("No products available");
                            System.out.println();
                            System.out.println("+++++++++++++++ END OF LIST OF PRODUCTS ++++++++++++++++");
                            flag=false;
                        }
                        else {
                            System.out.println("+++++++++++++++ END OF LIST OF PRODUCTS ++++++++++++++++");
                            System.out.println();
                            System.out.println("Enter a product id from the list to know about them in detail");
                            System.out.println();
                            int id = inputsFromUser.inputProductId();
                            shopController.displayPhone(id);
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println(" Do you want to add this product to cart?  1.Yes  2.No ");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println();
                            userChoice=inputsFromUser.inputChoice();
                            switch(userChoice) {
                                case 1:
                                    int quantity=inputsFromUser.inputCount();
                                    System.out.println("+++++++++++++++++++++ ADD TO CART +++++++++++++++++++++");
                                    System.out.println();
                                    if(shoppingCartController.phoneInCartAlready(customerAccountController.getUserName(),id)) {
                                        System.out.println("Phone present in cart already!!!");
                                        System.out.println("Choose update quantity from menu to change the quantity");
                                    }
                                    else if(quantity==0) {
                                        System.out.println("Sorry!!! Cannot add product to cart");
                                    }
                                    else if(shopController.phoneAvailable(id,quantity) && !shoppingCartController.phoneInCartAlready(customerAccountController.getUserName(),id)) {
                                        shoppingCartController.addPhoneToShoppingCart(this.customerAccountController.getUserName(),id,quantity);
                                        System.out.println("Product added to cart successfully.......");
                                    }
                                    else{
                                        System.out.println("Sorry!!! Stock unavailable at this moment");
                                    }
                                    System.out.println();
                                    System.out.println("+++++++++++++++++ END OF ADD TO CART ++++++++++++++++++");
                                    System.out.println();
                                case 2:
                                    System.out.println("Continue Shopping? 1.Yes 2.No");
                                    userChoice=inputsFromUser.inputChoice();
                                    if(userChoice==1) {
                                        continue;
                                    }
                                    else{
                                        flag=false;
                                    }
                                    break;
                            }
                        }
                    }
                    customerMenu();
                    break;
                case VIEW_CART:
                    System.out.println("+++++++++++++++++++++ VIEWING CART ++++++++++++++++++++");
                    System.out.println();
                    if(!(shoppingCartController.displayCart(customerAccountController.getUserName()))){
                        System.out.println("No products have been added till now");
                        System.out.println();
                        System.out.println("++++++++++++++++++ END OF VIEW CART +++++++++++++++++++");
                    }
                    else {
                        if(customerAccountController.getUserName().equals("guest")) {
                            System.out.println();
                            System.out.println("++++++++++++++++++ END OF VIEW CART +++++++++++++++++++");
                        }
                        else {
                            if(customerAccountController.getUserName().equals("guest")) {
                                System.out.println("Please create an account to proceed further");
                                System.out.println("1. Create Account or 2.Continue as Guest");
                                int userInput=inputsFromUser.inputChoice();
                                if(userInput==1) {
                                    customerAccountController.inputGuestDetails();
                                }
                                System.out.println("Taking you back to the menu");

                            }
                            else {

                                System.out.println();
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("    Do you want to place order?         1.Yes    2.No  ");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                userChoice = inputsFromUser.inputChoice();
                                if (userChoice == 1) {
                                    int amount = shopController.addToOrders(shoppingCartController.getShoppingCart(customerAccountController.getUserName()), customerAccountController.getUserName());
                                    if (amount > 0) {
                                        System.out.println("Please check the shipping address");
                                        System.out.println();
                                        System.out.println(customerAccountController.getShippingAddress());
                                        System.out.println();
                                        System.out.println("Do you want to change the Shipping Address? 1.Yes 2.No");
                                        userChoice = inputsFromUser.inputChoice();
                                        System.out.println();
                                        if(userChoice == 1) {
                                            String shippingAddress = inputsFromUser.inputShippingAddress();
                                            customerAccountController.setShippingAddress(shippingAddress);
                                            System.out.println("Printing Confirmed Shipping Address. Please Check");
                                            System.out.println();
                                            System.out.println(customerAccountController.getShippingAddress());
                                            System.out.println();
                                        } else {
                                            System.out.println("Printing Confirmed Shipping Address. Please Check");
                                            System.out.println();
                                            System.out.println(customerAccountController.getShippingAddress());
                                            System.out.println();
                                        }
                                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                        System.out.println("    Processing... Taking you to the payment section    ");
                                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                        System.out.println();
                                        System.out.println("1.Payment using card\n2.Payment using googlePay\n3.Cash on Delivery");
                                        System.out.println();
                                        PaymentOperation payment;
                                        int choice = inputsFromUser.inputChoice();
                                        switch (PaymentType.values()[choice - 1]) {
                                            case CARD:
                                                String cardNumber = inputsFromUser.inputAccountId();
                                                payment = new Card();
                                                customerAccountController.payFineThroughCard(payment, cardNumber);
                                                break;
                                            case GOOGLE_PAY:
                                                String googlePayId = inputsFromUser.inputGooglePayId();
                                                payment = new GooglePay();
                                                customerAccountController.payFineThroughGooglePay(payment, googlePayId);
                                                break;
                                            case CASH_ON_DELIVERY:
                                                System.out.println("You have chosen cash on delivery option");
                                        }
                                        System.out.println();
                                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                        System.out.println("  Order placed successfully.Thank you for shopping!!!  ");
                                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    } else {
                                        System.out.println("No products in cart");
                                        System.out.println();
                                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    }
                                } else {
                                    System.out.println("Taking you back to the menu");
                                }
                            }
                        }
                    }
                    customerMenu();
                    break;
                case REMOVE_FROM_CART:
                    System.out.println("+++++++++++++++++++++ VIEWING CART ++++++++++++++++++++");
                    System.out.println();
                    if(!(shoppingCartController.displayCart(customerAccountController.getUserName()))){
                        System.out.println("No products have been added till now");
                        System.out.println();
                        System.out.println("++++++++++++++++++ END OF VIEW CART +++++++++++++++++++");
                    }
                    else {
                        System.out.println("++++++++++++++++++ END OF VIEW CART +++++++++++++++++++");
                        System.out.println();
                        System.out.println("Do you want to remove any product from cart? 1.Yes 2.No");
                        userChoice=inputsFromUser.inputChoice();
                        if(userChoice==1) {
                            int id=inputsFromUser.inputProductId();
                            shoppingCartController.removePhoneFromCart(customerAccountController.getUserName(),id);
                            System.out.println("Phone has been removed");
                            System.out.println();
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        }
                        else {
                            System.out.println("Taking you back to the menu");
                        }
                    }
                    customerMenu();
                    break;
                case UPDATE_QUANTITY:
                    System.out.println("+++++++++++++++++++++ VIEWING CART ++++++++++++++++++++");
                    System.out.println();
                    if(!(shoppingCartController.displayCart(customerAccountController.getUserName()))){
                        System.out.println("No products have been added till now");
                        System.out.println();
                        System.out.println("++++++++++++++++++ END OF VIEW CART +++++++++++++++++++");
                    }
                    else {
                        System.out.println();
                        System.out.println("++++++++++++++++++ END OF VIEW CART +++++++++++++++++++");
                        System.out.println();
                        System.out.println("Do you want to update Quantity of any item? 1.Yes 2.No ");
                        userChoice=inputsFromUser.inputChoice();
                        if(userChoice==1) {
                            int id=inputsFromUser.inputProductId();
                            System.out.println("Enter the new quantity value\n");
                            int count=inputsFromUser.inputCount();
                            if(shopController.phoneAvailable(id,count) && shoppingCartController.phoneInCartAlready(customerAccountController.getUserName(),id)) {
                                shoppingCartController.updatePhoneQuantityInCart(customerAccountController.getUserName(),id,count);
                                System.out.println("Product quantity updated");
                                System.out.println();
                            }
                            else{
                                System.out.println("Sorry!!! Quantity cannot be updated");
                                System.out.println();
                            }
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        }
                        else {
                            System.out.println("Taking you back to the menu");
                        }
                    }
                    customerMenu();
                    break;
                case SEARCH_PRODUCTS:
                    System.out.println("++++++++++++++++++++ SEARCH PRODUCTS ++++++++++++++++++");
                    System.out.println();
                    System.out.println("Enter something to search");
                    String inputValue=inputsFromUser.inputValue();
                    System.out.println();
                    flag=true;
                    while(flag) {
                        if(shopController.searchPhone(inputValue)) {
                            System.out.println("Enter a product id from the list to know about them in detail");
                            int id = inputsFromUser.inputProductId();
                            shopController.displayPhone(id);
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println(" Do you want to add this product to cart?  1.Yes  2.No ");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println();
                            userChoice=inputsFromUser.inputChoice();
                            switch(userChoice) {
                                case 1:
                                    int quantity=inputsFromUser.inputCount();
                                    System.out.println("+++++++++++++++++++++ ADD TO CART +++++++++++++++++++++");
                                    System.out.println();
                                    if(shoppingCartController.phoneInCartAlready(customerAccountController.getUserName(),id)) {
                                        System.out.println("Phone present in cart already!!!");
                                        System.out.println("Choose update quantity from menu to change the quantity");
                                    }
                                    else if(shopController.phoneAvailable(id,quantity) && !shoppingCartController.phoneInCartAlready(customerAccountController.getUserName(),id)) {
                                        shoppingCartController.addPhoneToShoppingCart(this.customerAccountController.getUserName(),id,quantity);
                                        System.out.println("Product added to cart successfully.......");
                                    }
                                    else{
                                        System.out.println("Sorry!!! Stock unavailable at this moment");
                                    }
                                case 2:
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    System.out.println("Do you want to go back to the search result? 1.Yes 2.No");
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    userChoice = inputsFromUser.inputChoice();
                                    if(userChoice==1) {
                                        continue;
                                    }
                                    else{
                                        flag=false;
                                    }
                                    break;
                            }
                        }
                        else {
                            System.out.println("No records found");
                            flag=false;
                        }
                    }
                    System.out.println();
                    System.out.println("+++++++++++++++ END OF SEARCH PRODUCTS ++++++++++++++++");
                    System.out.println();
                    customerMenu();
                    break;
                case TRACK_ORDERS:
                    if(customerAccountController.getUserName().equals("guest")) {
                        System.out.println("Please create an account to continue further");
                        System.out.println();
                        System.out.println("1.Create account or 2.Continue as guest user");
                        int userInput=inputsFromUser.inputChoice();
                        if(userInput==1) {
                            customerAccountController.inputGuestDetails();
                        }
                        System.out.println("Taking you back to the menu");
                    }
                    else {
                        System.out.println("+++++++++++++++ LIST OF ORDERS PLACED +++++++++++++++++++");
                        System.out.println();
                        if(!(shopController.viewOrdersPlaced(customerAccountController.getUserName()))){
                            System.out.println("No orders placed till now");
                            System.out.println();
                            System.out.println("+++++++++++++++++ END OF ORDERS LIST ++++++++++++++++++");
                        }
                        else {
                            System.out.println();
                            System.out.println("+++++++++++++++++ END OF ORDERS LIST ++++++++++++++++++");
                        }
                    }
                    customerMenu();
                    break;
                case REMOVE_AN_ORDER:
                    if(customerAccountController.getUserName().equals("guest")) {
                        System.out.println("Please create an account to continue further");
                        System.out.println();
                        System.out.println("1.Create account or 2.Continue as guest user");
                        int userInput=inputsFromUser.inputChoice();
                        if(userInput==1) {
                            customerAccountController.inputGuestDetails();
                        }
                        System.out.println("Taking you back to the menu");
                    }
                    else {
                        System.out.println("+++++++++++++++ LIST OF ORDERS PLACED +++++++++++++++++++");
                        System.out.println();
                        if(!(shopController.viewOrdersPlaced(customerAccountController.getUserName()))){
                            System.out.println("No orders placed till now");
                            System.out.println();
                            System.out.println("+++++++++++++++++ END OF ORDERS LIST ++++++++++++++++++");
                        }
                        else {
                            System.out.println("Enter the order id from the above to remove ");
                            int orderId=inputsFromUser.inputChoice();
                            shopController.removeOrder(orderId,customerAccountController.getUserName());
                            System.out.println();
                            System.out.println("+++++++++++++++++ END OF ORDERS LIST ++++++++++++++++++");
                        }
                    }
                    customerMenu();
                    break;
                case VIEW_PAST_ORDERS:
                    if(customerAccountController.getUserName().equals("guest")) {
                        System.out.println("Please create an account to continue further");
                        System.out.println();
                        System.out.println("1.Create account or 2.Continue as guest user");
                        int userInput=inputsFromUser.inputChoice();
                        if(userInput==1) {
                            customerAccountController.inputGuestDetails();
                        }
                        System.out.println("Taking you back to the menu");
                    }
                    else {
                        System.out.println("+++++++++++++++ LIST OF ORDERS PLACED +++++++++++++++++++");
                        System.out.println();
                        if(!(shopController.viewPastOrdersPlaced(customerAccountController.getUserName()))){
                            System.out.println("No orders placed till now");
                            System.out.println();
                            System.out.println("+++++++++++++++++ END OF ORDERS LIST ++++++++++++++++++");
                        }
                        else {
                            System.out.println();
                            System.out.println("+++++++++++++++++ END OF ORDERS LIST ++++++++++++++++++");
                        }
                    }
                   customerMenu();
                    break;
                case VIEW_PROFILE:
                    if(customerAccountController.getUserName().equals("guest")) {
                        System.out.println("Please create an account to continue further");
                        System.out.println();
                        System.out.println("1.Create account or 2.Continue as guest user");
                        int userInput=inputsFromUser.inputChoice();
                        if(userInput==1) {
                            customerAccountController.inputGuestDetails();
                        }
                        System.out.println("Taking you back to the menu");
                    }
                    else {
                        this.customerAccountController.updateView();
                    }
                    customerMenu();
                    break;
                case UPDATE_PROFILE:
                    if(customerAccountController.getUserName().equals("guest")) {
                        System.out.println("Please create an account to continue further");
                        System.out.println();
                        System.out.println("1.Create account or 2.Continue as guest user");
                        int userInput=inputsFromUser.inputChoice();
                        if(userInput==1) {
                            customerAccountController.inputGuestDetails();
                        }
                        System.out.println("Taking you back to the menu");
                    }
                    else {
                        this.customerAccountController.updateProfile();
                        this.customerAccountController.updateView();
                    }
                    customerMenu();
                    break;
                case VIEW_SHOP_DETAILS:
                    shopController.updateView();
                    customerMenu();
                    break;
                case EXIT:
                    shoppingCartController.writeProductsFromCartToDataSource(customerAccountController.getUserName());
                    LoginViewService loginView = new LoginView();
                    LoginModel loginModel = new LoginModel();
                    LoginControllerService loginController = new LoginController(loginModel, loginView);
                    loginController.logOut(customerAccountController.getUserName());
                    break;
                case DEFAULT:
                    System.out.println(" Invalid input.");
                    System.out.println(" Please wait!!! Taking you back to the menu");
                    customerMenu();
                    break;
            }
        }
        catch(ArrayIndexOutOfBoundsException | NumberFormatException | NullPointerException exception) {
            System.out.println(" Some problem occurred !!!");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("!   Please wait while we take you back to the menu    !");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            customerMenu();
        }
    }
    public void createAccountForGuest(){
        System.out.println("__________CREATING AN ACCOUNT FOR GUEST USER_____________");
        System.out.println();
        String userName=inputsFromUser.inputUserNameFirstTime();
        while(loginUtil.isSellerPresentAlready(userName) || loginUtil.isCustomerPresentAlready(userName)){
            System.out.println("User already exist!!!!");
            userName = inputsFromUser.inputUserName();
        }
        String password=inputsFromUser.inputPasswordFirstTime();
        System.out.println("Processing........ Please Wait");
        System.out.println();
        System.out.println(" Your id is: " + customerAccountController.getUserId());
        System.out.println();
        System.out.println("+++++++Taking you into your account. Please Wait+++++++");
        System.out.println();
        System.out.println("Please provide us a little more details to complete your profile");
        customerAccountController.setUserName(userName);
        customerAccountController.setPassword(password);
        customerAccountController.setOtherInputs();
    }
}
