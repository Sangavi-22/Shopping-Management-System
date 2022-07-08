package Inputs;

import Validation.ValidateInput;
import Validation.ValidateInputService;

import java.util.Scanner;

public class InputsFromUser {
    private final ValidateInputService validate=new ValidateInput();
    private final Scanner input=new Scanner(System.in);
    public int inputChoice(){
        String userInput;
        while(true) {
            System.out.println("Enter your choice:");
            userInput = input.nextLine();
            if(!(validate.validateUserChoice(userInput))) {
                System.out.println("Invalid input");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(userInput);
    }
    public String inputEmployeeNum(){
        String employeeNum;
        while(true) {
            System.out.println("Enter your employment Id:");
            employeeNum = input.nextLine();
            if(!(validate.validateEmployeeNum(employeeNum))) {
                System.out.println("Invalid employment id");
            }
            else {
                break;
            }
        }
        return employeeNum;
    }
    public String inputUserNameFirstTime() {
        String userName;
        while(true) {
            System.out.println("Enter the username:");
            userName = input.nextLine();
            if(!(validate.validateUserAccountName(userName))) {
                System.out.println("Invalid username");
                System.out.println("Note: Username should contain only alphabets, special characters, should be of min length 3");
            }
            else {
                break;
            }
        }
        return userName;
    }
    public String inputPasswordFirstTime(){
        String passkey;
        while(true) {
            System.out.println("Enter the password:");
            passkey = input.nextLine();
            if(!(validate.validatePassword(passkey))) {
                System.out.println("Invalid password");
                System.out.println("Note: Password should be of minimum length 8");
            }
            else {
                break;
            }
        }
        return passkey;
    }
    public String inputUserName(){
        String userName;
        while(true) {
            System.out.println("Enter the username:");
            userName = input.nextLine();
            if(!(validate.validateUserAccountName(userName))) {
                System.out.println("Invalid username");
            }
            else {
                break;
            }
        }
        return userName;
    }

    public String inputPassword(){
        String passkey;
        while(true) {
            System.out.println("Enter the password:");
            passkey = input.nextLine();
            if(!(validate.validatePassword(passkey))) {
                System.out.println("Invalid password");
            }
            else {
                break;
            }
        }
        return passkey;
    }
    public int inputUserId() {
        String userInput;
        while(true) {
            System.out.println("Enter your userId:");
            userInput = input.nextLine();
            if(!(validate.validateUserId(userInput))) {
                System.out.println("Invalid user id");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(userInput);
    }
    public int inputMemberType(){
        String userInput;
        while(true) {
            System.out.println("Are you a Seller: 1.Yes 2.No");
            userInput=input.nextLine();
            if(!(validate.validateUserChoice(userInput))) {
                System.out.println("Invalid user input");
            }
            else{
                break;
            }
        }
        return Integer.parseInt(userInput);
    }
    public String inputName(){
        String name;
        while(true) {
            System.out.println("Enter your name:");
            name = input.nextLine();
            if(!(validate.validateProfileName(name))) {
                System.out.println("Invalid name");
            }
            else {
                break;
            }
        }
        return name;
    }
    public String inputEmail(){
        String email;
        while(true) {
            System.out.println("Enter your email:");
            System.out.println("If you do not have an email id enter \"-\" ");
            email = input.nextLine();
            if(!(validate.validateEmail(email))) {
                System.out.println("Invalid email");
            }
            else {
                break;
            }
        }
        return email;
    }
    public long inputMobileNum(){
        String mobileNum;
        while(true) {
            System.out.println("Enter your mobile number:");
            System.out.println("If you do not have a mobile number enter \"-\" ");
            mobileNum = input.nextLine();
            if(mobileNum.equals("-")) {
                mobileNum="0";
                break;
            }
            else if(!(validate.validateMobileNum(mobileNum))) {
                System.out.println("Invalid mobile Number");
            }
            else {
                break;
            }
        }
        return Long.parseLong(mobileNum);
    }
    public String inputShippingAddress(){
        String address;
        while(true){
            System.out.println("Enter your address");
            address=input.nextLine();
            if(!(validate.validateAddress(address))) {
                System.out.println("Invalid address");
            }
            else {
                break;
            }
        }
        return address;
    }
    public String inputModelName(){
        String modelName;
        while(true){
            System.out.println("Enter the product modelName");
            modelName=input.nextLine();
            if(!(validate.validateModelName(modelName))) {
                System.out.println("Invalid modelName");
            }
            else {
                break;
            }
        }
        return modelName;
    }
    public String inputManufacturer(){
        String manufacturerName;
        while(true){
            System.out.println("Enter the manufacturer Name");
            manufacturerName=input.nextLine();
            if(!(validate.validateManufacturerName(manufacturerName))) {
                System.out.println("Invalid manufacturer Name");
            }
            else {
                break;
            }
        }
        return manufacturerName;
    }
    public int inputWidth(){
        String width;
        while(true){
            System.out.println("Enter the width of the phone");
            width=input.nextLine();
            if(!(validate.validateWidthOfPhone(width))) {
                System.out.println("Invalid width value");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(width);
    }
    public int inputHeight(){
        String height;
        while(true){
            System.out.println("Enter the height of the phone");
            height=input.nextLine();
            if(!(validate.validateHeightOfPhone(height))) {
                System.out.println("Invalid height value");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(height);
    }
    public int inputWeight(){
        String weight;
        while(true){
            System.out.println("Enter the weight of the phone");
            weight=input.nextLine();
            if(!(validate.validateWeightOfPhone(weight))) {
                System.out.println("Invalid weight value");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(weight);
    }
    public double inputDisplaySize(){
        String displaySize;
        while(true){
            System.out.println("Enter the display size of the phone");
            displaySize=input.nextLine();
            if(!(validate.validateDisplaySize(displaySize))) {
                System.out.println("Invalid display size value");
            }
            else {
                break;
            }
        }
        return Double.parseDouble(displaySize);
    }
    public String inputBatteryCapacity(){
        String batteryCapacity;
        while(true){
            System.out.println("Enter the battery Capacity");
            batteryCapacity=input.nextLine();
            if(!(validate.validateBatteryCapacity(batteryCapacity))) {
                System.out.println("Invalid battery Capacity");
            }
            else {
                break;
            }
        }
        return batteryCapacity;
    }
    public String inputPrimaryCamera(){
        String primaryCamera;
        while(true){
            System.out.println("Enter the primary camera");
            primaryCamera=input.nextLine();
            if(!(validate.validatePrimaryCamera(primaryCamera))) {
                System.out.println("Invalid primary camera");
            }
            else {
                break;
            }
        }
        return primaryCamera;
    }
    public String inputSecondaryCamera(){
        String secondaryCamera;
        while(true){
            System.out.println("Enter the secondary camera");
            secondaryCamera=input.nextLine();
            if(!(validate.validateSecondaryCamera(secondaryCamera))) {
                System.out.println("Invalid secondary camera");
            }
            else {
                break;
            }
        }
        return secondaryCamera;
    }
    public int inputStorageCapacity() {
        String storageCapacity;
        while(true){
            System.out.println("Enter the Storage Capacity");
            storageCapacity=input.nextLine();
            if(!(validate.validateStorageCapacity(storageCapacity))) {
                System.out.println("Invalid Storage Capacity");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(storageCapacity);
    }
    public String inputProcessorType(){
        String processorType;
        while(true){
            System.out.println("Enter the processor type");
            processorType=input.nextLine();
            if(!(validate.validateProcessorType(processorType))) {
                System.out.println("Invalid processor type");
            }
            else {
                break;
            }
        }
        return processorType;
    }
    public int inputProductId(){
        String productId;
        while (true) {
            System.out.println("Enter the id of the product");
            productId = input.nextLine();
            if (!(validate.validateProductId(productId))) {
                System.out.println("Invalid input");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(productId);
    }
    public int inputCount(){
        String count;
        while (true) {
            System.out.println("Enter the quantity:");
            count= input.nextLine();
            if (!(validate.validateProductCount(count))) {
                System.out.println("Invalid input");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(count);
    }
    public String inputValue() {
        String inputValue;
        while (true) {
            System.out.println("Enter the input");
            inputValue= input.nextLine();
            if (!(validate.validateInput(inputValue))) {
                System.out.println("Invalid input");
            }
            else {
                break;
            }
        }
        return inputValue;
    }
    public int inputPrice() {
        String inputValue;
        while (true) {
            System.out.println("Enter the price (Note: Enter only numbers)");
            inputValue= input.nextLine();
            if (!(validate.validatePrice(inputValue))) {
                System.out.println("Invalid input");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(inputValue);
    }
    public String inputAccountId() {
        String inputAccountId;
        while(true) {
            System.out.println("Enter your bank account id");
            inputAccountId = input.nextLine();
            if(!(validate.validateAccountId(inputAccountId))) {
                System.out.println("Invalid input");
            }
            else {
                break;
            }
        }
        return inputAccountId;
    }
    public String inputGooglePayId(){
        String inputGooglePayId;
        while(true) {
            System.out.println("Enter your google pay id");
            inputGooglePayId = input.nextLine();
            if(!(validate.validateAccountId(inputGooglePayId))) {
                System.out.println("Invalid input");
            }
            else {
                break;
            }
        }
        return inputGooglePayId;
    }
    public int inputOrderId() {
        String userInput;
        while(true) {
            System.out.println("Enter the orderId:");
            userInput = input.nextLine();
            if(!(validate.validateOrderId(userInput))) {
                System.out.println("Invalid input");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(userInput);
    }
}
