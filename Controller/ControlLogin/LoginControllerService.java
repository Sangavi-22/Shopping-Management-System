package Controller.ControlLogin;

public interface LoginControllerService {
    void goToHomePage();
    void setAccountName(String accountName);
    String getAccountName();
    void removeUser(String userName);
    void logOut(String userName);
}
