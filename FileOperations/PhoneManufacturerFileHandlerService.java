package FileOperations;

import Model.MobilePhone.PhoneManufacturerModel;

import java.util.HashMap;

public interface PhoneManufacturerFileHandlerService {
    void writePhoneManufacturerDetails(int productId, String manufacturerName);
    HashMap<Integer,PhoneManufacturerModel> readPhoneManufacturerDetails();
    void removePhoneManufacturer(int id);
}
