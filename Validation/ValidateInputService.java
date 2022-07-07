package Validation;

public interface ValidateInputService {
    boolean validateUserChoice(String userInput);
    boolean validateUserAccountName(String inputUserName);
    boolean validatePassword(String passkey);
    boolean validateUserId(String userId);
    boolean validateProfileName(String inputProfileName);
    boolean validateEmail(String inputEmail);
    boolean validateMobileNum(String inputMobileNum);
    boolean validateAddress(String inputAddress);
    boolean validateModelName(String inputModelName);
    boolean validateManufacturerName(String inputManufacturerName);
    boolean validateWidthOfPhone(String inputWidth);
    boolean validateHeightOfPhone(String inputHeight);
    boolean validateWeightOfPhone(String inputWeight);
    boolean validateDisplaySize(String inputDisplaySize);
    boolean validateBatteryCapacity(String inputBatteryCapacity);
    boolean validatePrimaryCamera(String inputPrimaryCamera);
    boolean validateSecondaryCamera(String inputSecondaryCamera);
    boolean validateStorageCapacity(String storageCapacity);
    boolean validateProcessorType(String inputProcessorType);
    boolean validateProductId(String inputProductId);
    boolean validateProductCount(String inputProductCount);
    boolean validateInput(String inputValue);
    boolean validatePrice(String inputValue);
    boolean validateAccountId(String inputAccountId);
    boolean validateEmployeeNum(String employeeNum);

    boolean validateOrderId(String userInput);
}
