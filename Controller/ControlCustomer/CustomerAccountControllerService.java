package Controller.ControlCustomer;

import Payment.PaymentOperation;

public interface CustomerAccountControllerService {
    void setOtherInputs();
    void inputGuestDetails();
    void addCustomerToDataSource();
    void customerMenu();
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
    void setShippingAddress(String address);
    String getShippingAddress();
    void payFineThroughCard(PaymentOperation payment, String cardNumber);
    void payFineThroughGooglePay(PaymentOperation payment, String googlePayId);
    void updatePasswordInDataSource();
    void updateProfile();
    void updateView();



}
