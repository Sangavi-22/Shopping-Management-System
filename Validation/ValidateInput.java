package Validation;

public class ValidateInput implements ValidateInputService {
    public boolean validateUserChoice(String userInput) {
        return userInput.matches("\\d{1,2}+");
    }
    public boolean validateUserAccountName(String inputUserName){
        return inputUserName.matches("[a-zA-Z!@#$%^&*():,./~'_]{3,20}+");
    }
    public boolean validatePassword(String passkey){
        return passkey.matches("[a-z A-Z\\d+!@#$%^&*():,./~'_]{8,20}+");
    }
    public boolean validateUserId(String userId){
        return userId.matches("\\d*");
    }
    public boolean validateProfileName(String inputProfileName){
        return inputProfileName.matches("[a-z A-Z.']+|[a-z A-Z.']+\\s[a-z A-Z.']+");
    }
    public boolean validateEmail(String inputEmail){
        return inputEmail.matches("^([a-zA-Z\\d+_.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z\\d.-]+)|-$");
    }
    public boolean validateMobileNum(String inputMobileNum){
        return inputMobileNum.matches("([\\d+]{10})|-");
    }
    public boolean validateAddress(String inputAddress){
        return inputAddress.matches("[a-z A-Z\\d -/,.()#*]{10,}+");
    }
    public boolean validateModelName(String inputModelName){
        return inputModelName.matches("[A-Za-z\\d\\s-_,.;:()@!$%^&*'\"]+");
    }
    public boolean validateManufacturerName(String inputManufacturerName){
        return inputManufacturerName.matches("[A-Za-z\\d\\s-_,.;:()@!$%^&*'\"]+");
    }
    public boolean validateWidthOfPhone(String inputWidth){
        return inputWidth.matches("\\d+");
    }
    public boolean validateHeightOfPhone(String inputHeight){
        return inputHeight.matches("\\d+");
    }
    public boolean validateWeightOfPhone(String inputWeight){
        return inputWeight.matches("\\d+");
    }
    public boolean validateDisplaySize(String inputDisplaySize){
        return inputDisplaySize.matches("\\d+|\\d+.\\d+");
    }
    public boolean validateBatteryCapacity(String inputBatteryCapacity){
        return inputBatteryCapacity.matches("\\d+");
    }
    public boolean validatePrimaryCamera(String inputPrimaryCamera){
        return inputPrimaryCamera.matches("[a-z A-Z+\\s\\d]+");
    }
    public boolean validateSecondaryCamera(String inputSecondaryCamera){
        return inputSecondaryCamera.matches("[a-z A-Z+\\s\\d]+");

    }
    public boolean validateStorageCapacity(String storageCapacity) {
        return storageCapacity.matches("[\\d+]{2,3}");
    }
    public boolean validateProcessorType(String inputProcessorType){
        return inputProcessorType.matches("[a-z A-Z\\d\\s,.;]+");
    }
    public boolean validateProductId(String inputProductId){
        return inputProductId.matches("\\d+");
    }
    public boolean validateProductCount(String inputProductCount){
        return inputProductCount.matches("\\d+|-\\d+");
    }
    public boolean validateInput(String inputValue) {
        return inputValue.matches("[a-z A-Z\\d.#%@!^&*(),?/;:'{}\\s+]+");
    }
    public boolean validatePrice(String inputValue) {
        return inputValue.matches("\\d+");
    }
    public boolean validateAccountId(String inputAccountId) {
        return inputAccountId.matches("[a-z A-Z\\d+]+");
    }
    public boolean validateEmployeeNum(String employeeNum) {
        return  employeeNum.matches("MG[\\d+]{4}");
    }

    public boolean validateOrderId(String userInput) {
        return userInput.matches("\\d+");
    }
}

