package FileOperations;

import Model.MobilePhone.PhoneDetailsModel;

import java.util.HashMap;

public interface PhoneDetailsFileHandlerService {
    void writePhoneDetails(int productId, String modelName, String batteryCapacity, double displaySize,int price);
    int readLastPhoneId();
    HashMap<Integer, PhoneDetailsModel> readPhoneDetails();
    void removePhoneDetails(int id);
}
