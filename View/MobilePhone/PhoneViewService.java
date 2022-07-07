package View.MobilePhone;

import Controller.ControlMobilePhone.PhoneControllerService;

public interface PhoneViewService {
    void inputPhoneDetails(PhoneControllerService phoneController);
    void passPhoneDetailsToController(PhoneControllerService phoneController);
    int inputQuantityOfPhoneToAdd();
}
