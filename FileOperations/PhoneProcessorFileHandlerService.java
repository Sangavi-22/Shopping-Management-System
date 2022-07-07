package FileOperations;

import Model.MobilePhone.PhoneProcessorModel;

import java.util.HashMap;

public interface PhoneProcessorFileHandlerService {
    void writePhoneProcessorDetails(int productId, String processorType, String operatingSystem);
    HashMap<Integer, PhoneProcessorModel> readPhoneProcessorDetails();
    void removePhoneProcessor(int id);
}
