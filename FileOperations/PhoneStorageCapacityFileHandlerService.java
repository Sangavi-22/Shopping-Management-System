package FileOperations;

import Model.MobilePhone.PhoneStorageCapacityModel;

import java.util.HashMap;

public interface PhoneStorageCapacityFileHandlerService {
    void writePhoneProcessorDetails(int productId, int storageCapacity);

    HashMap<Integer, PhoneStorageCapacityModel> readPhoneStorageCapacityDetails();
    void removePhoneStorageCapacity(int id);
}
