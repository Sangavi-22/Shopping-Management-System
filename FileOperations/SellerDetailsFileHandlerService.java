package FileOperations;

import Model.Users.SellerAccountModel;

import java.util.HashMap;

public interface SellerDetailsFileHandlerService {
    void writeSellerDetails(int userId,String userName,String password,String name,String email,long mobileNum);
    void updateSellerDetails(int userId, String userName, String password, String name, String email, long mobileNum);
    int readLastSellerId();
    HashMap<String, SellerAccountModel> readSellers();
    void removeSellerDetailsFromFile(String userName);

}
