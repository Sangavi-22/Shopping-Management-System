package Controller.ControlLogin;

import DataStorage.*;
import Model.Login.LoginModel;
import View.Login.LoginViewService;

public class LoginController implements LoginControllerService {
    private final LoginModel loginModel;
    private final LoginViewService loginView;
    private final LoginUtility loginUtil=new LoginUtility();
    private final DataSourceService dataSource= DataSource.getInstance();
    public LoginController(LoginModel loginModel, LoginViewService loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
    }
    public void goToHomePage(){
        this.loginView.homePage();
    }
    public void setAccountName(String accountName){
        this.loginModel.setAccountName(accountName);
    }
    public String getAccountName(){
        return this.loginModel.getAccountName();
    }
    public void removeUser(String userName) {
        if(loginUtil.isSellerPresentAlready(userName) && this.getAccountName().equals(userName)) {
            dataSource.removeSeller(userName);
            this.loginView.removedUser("Seller");
        }
        else if (loginUtil.isSellerPresentAlready(userName) && ! (this.loginModel.getAccountName().equals(userName))) {
            this.loginView.removedUser("Another Seller");
        }
        else if(loginUtil.isCustomerPresentAlready(userName)){
            dataSource.removeCustomer(userName);
            this.loginView.removedUser("Customer");
        }
        else{
            this.loginView.removedUser("No User");
        }
    }
    public void logOut(String userName) {
        loginView.loggedOut(userName);
    }
}
