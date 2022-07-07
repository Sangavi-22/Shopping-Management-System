package FileOperations;

import Model.MobilePhone.PhoneCameraModel;

import java.util.HashMap;

public interface PhoneCameraFileHandlerService {
    void writePhoneCameraDetails(int productId, String primaryCamera, String secondaryCamera);
    HashMap<Integer, PhoneCameraModel> readPhoneCameraDetails();
    void removePhoneCamera(int id);
}
