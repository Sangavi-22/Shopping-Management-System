package FileOperations;

import Model.MobilePhone.PhoneDimensionsModel;

import java.util.HashMap;

public interface PhoneDimensionsFileHandlerService {
    void writePhoneDimensions(int productId, int width, int height, int weight);
    HashMap<Integer, PhoneDimensionsModel> readPhoneDimensionsDetails();
    void removePhoneDimensions(int id);
}
