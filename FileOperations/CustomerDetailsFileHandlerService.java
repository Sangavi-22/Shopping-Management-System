package FileOperations;

import Model.Users.CustomerAccountModel;

import java.util.HashMap;

public interface CustomerDetailsFileHandlerService {
    void writeCustomerDetails(int userId,String userName,String password,String name,String email,long mobileNum, String address);
    void updateCustomerDetails(int userId, String userName, String password, String name, String email, long mobileNum, String address);
    HashMap<String, CustomerAccountModel> readCustomers();
    int readLastCustomerId();
    void removeCustomerDetailsFromFile(String userName);
}
