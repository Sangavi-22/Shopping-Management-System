package Controller.ControlMobilePhone;

import java.time.LocalDate;

public interface PhoneControllerService {
    void setInputs();
    int inputQuantityOfPhoneToAdd();
    void setProductId(int productId);
    int getProductId();
    void setModelName(String modelName);
    String getModelName();
    void setBatteryCapacity(String batteryCapacity);
    String getBatteryCapacity();
    void setDisplaySize(double displaySize);
    double getDisplaySize();
    void setPrimaryCamera(String primaryCamera);
    String getPrimaryCamera();
    void setSecondaryCamera(String secondaryCamera);
    String getSecondaryCamera();
    void setWidth(int width);
    int getWidth();
    void setHeight(int height);
    int getHeight();
    void setWeight(int weight);
    int getWeight();
    void setManufacturerName(String manufacturerName);
    String getManufacturerName();
    void setOperatingSystem(String operatingSystem);
    String getOperatingSystem();
    void setProcessorType(String processorType);
    String getProcessorType();
    void setStorageCapacity(int storageCapacity);
    int getStorageCapacity();
    void setPrice(int price);
    int getPrice();
    void printQuantity(int quantity);
    void printDeliveryDateOfPhone(LocalDate deliveryDate, String deliveryStatus);
    void printOrderedQuantity(int orderedQuantity);
    void printBasicInfo();
    void updateView();
}
