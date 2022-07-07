package Controller.ControlMobilePhone;

import Model.MobilePhone.*;
import View.MobilePhone.PhoneViewService;
import View.MobilePhone.PrintPhoneInfoViewService;

import java.time.LocalDate;

public class PhoneController implements PhoneControllerService{
    private final PhoneDetailsModel phoneDetailsModel;
    private final PhoneCameraModel phoneCameraModel;
    private final PhoneDimensionsModel phoneDimensionsModel;
    private final PhoneManufacturerModel phoneManufacturerModel;
    private final PhoneProcessorModel phoneProcessorModel;
    private final PhoneStorageCapacityModel phoneStorageCapacityModel;
    private final PhoneViewService phoneView;
    private final PrintPhoneInfoViewService printPhoneInfoView;

    public PhoneController(PhoneDetailsModel phoneDetailsModel,PhoneCameraModel phoneCameraModel,PhoneDimensionsModel phoneDimensionsModel,PhoneManufacturerModel phoneManufacturerModel,
                           PhoneProcessorModel phoneProcessorModel,PhoneStorageCapacityModel phoneStorageCapacityModel,PhoneViewService phoneView,PrintPhoneInfoViewService printPhoneInfoView){
        this.phoneDetailsModel=phoneDetailsModel;
        this.phoneCameraModel=phoneCameraModel;
        this.phoneDimensionsModel=phoneDimensionsModel;
        this.phoneManufacturerModel=phoneManufacturerModel;
        this.phoneProcessorModel=phoneProcessorModel;
        this.phoneStorageCapacityModel=phoneStorageCapacityModel;
        this.phoneView=phoneView;
        this.printPhoneInfoView=printPhoneInfoView;
    }
    public void setInputs(){
        this.phoneView.inputPhoneDetails(this);
    }
    public int inputQuantityOfPhoneToAdd(){
        return this.phoneView.inputQuantityOfPhoneToAdd();
    }
    public void setProductId(int productId){
        this.phoneDetailsModel.setProductId(productId);
    }
    public int getProductId(){
        return this.phoneDetailsModel.getProductId();
    }
    public void setModelName(String modelName){
        this.phoneDetailsModel.setModelName(modelName);
    }
    public String getModelName(){
        return this.phoneDetailsModel.getModelName();
    }
    public void setBatteryCapacity(String batteryCapacity){
        this.phoneDetailsModel.setBatteryCapacity(batteryCapacity);
    }
    public String getBatteryCapacity(){
        return this.phoneDetailsModel.getBatteryCapacity();
    }
    public void setDisplaySize(double displaySize){
        this.phoneDetailsModel.setDisplaySize(displaySize);
    }
    public double getDisplaySize(){
        return this.phoneDetailsModel.getDisplaySize();
    }
    public void setPrimaryCamera(String primaryCamera){
        this.phoneCameraModel.setPrimaryCamera(primaryCamera);
    }
    public String getPrimaryCamera(){
        return this.phoneCameraModel.getPrimaryCamera();
    }
    public void setSecondaryCamera(String secondaryCamera){
        this.phoneCameraModel.setSecondaryCamera(secondaryCamera);
    }
    public String getSecondaryCamera(){
        return this.phoneCameraModel.getSecondaryCamera();
    }
    public void setWidth(int width){
        this.phoneDimensionsModel.setWidth(width);
    }
    public int getWidth(){
        return this.phoneDimensionsModel.getWidth();
    }
    public void setHeight(int height){
        this.phoneDimensionsModel.setHeight(height);
    }
    public int getHeight(){
        return this.phoneDimensionsModel.getHeight();
    }
    public void setWeight(int weight){
        this.phoneDimensionsModel.setWeight(weight);
    }
    public int getWeight(){
        return this.phoneDimensionsModel.getWeight();
    }
    public void setManufacturerName(String manufacturerName){
        this.phoneManufacturerModel.setManufacturerName(manufacturerName);
    }
    public String getManufacturerName(){
        return this.phoneManufacturerModel.getManufacturerName();
    }
    public void setOperatingSystem(String operatingSystem) {
        this.phoneProcessorModel.setOperatingSystem(operatingSystem);
    }
    public String getOperatingSystem(){
        return this.phoneProcessorModel.getOperatingSystem();
    }
    public void setProcessorType(String processorType) {
        this.phoneProcessorModel.setProcessorType(processorType);
    }
    public String getProcessorType(){
        return this.phoneProcessorModel.getProcessorType();
    }
    public void setStorageCapacity(int storageCapacity){
        this.phoneStorageCapacityModel.setStorageCapacity(storageCapacity);
    }
    public int getStorageCapacity(){
        return this.phoneStorageCapacityModel.getStorageCapacity();
    }
    public void setPrice(int price){
        this.phoneDetailsModel.setPrice(price);
    }
    public int getPrice(){
        return this.phoneDetailsModel.getPrice();
    }
    public void printQuantity(int quantity){
        printPhoneInfoView.printQuantityDetails(quantity);
    }
    public void printOrderedQuantity(int orderedQuantity){
        printPhoneInfoView.printOrderedQuantityDetails(orderedQuantity);
    }
    public void printDeliveryDateOfPhone(LocalDate deliveryDate, String deliveryStatus){
        printPhoneInfoView.printDeliveryDate(deliveryDate,deliveryStatus);
    }
    public void printBasicInfo(){
        this.printPhoneInfoView.printPhoneBasicInfo(this.getProductId(),this.getModelName(),this.getStorageCapacity(),this.getPrice());
    }
    public void updateView(){
        printPhoneInfoView.printPhoneDetails(this.getProductId(),this.getModelName(),this.getManufacturerName(),this.getWidth(),this.getHeight(),this.getWeight(),this.getDisplaySize(),
                this.getBatteryCapacity(),this.getPrimaryCamera(),this.getSecondaryCamera(),this.getOperatingSystem(),this.getProcessorType(),this.getStorageCapacity(),this.getPrice());
    }

}
