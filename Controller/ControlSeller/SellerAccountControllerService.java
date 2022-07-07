package Controller.ControlSeller;

public interface SellerAccountControllerService {
    void setOtherInputs();
    void addSellerToDataSource();
    void sellerMenu();
    void setName(String name);
    String getName();
    void setEmail(String email);
    String getEmail();
    void setMobileNum(long mobileNum);
    long getMobileNum();
    void setUserName(String userName);
    String getUserName();
    void setPassword(String password);
    String getPassword();
    void setUserId(int id);
    int getUserId();
    void updateProfile();
    void updatePasswordInDataSource();
    void updateView();

}
