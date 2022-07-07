package View.MobilePhone;

import java.time.LocalDate;

public interface PrintPhoneInfoViewService {
    void printPhoneBasicInfo(int productId, String name, int storageCapacity, int price);
    void printPhoneDetails(int productId, String modelName, String manufacturerName, int width, int height, int weight, double displaySize, String batteryCapacity, String primaryCamera, String secondaryCamera, String operatingSystem, String processorType, int storageCapacity, int price);
    void printQuantityDetails(int quantity);
    void printOrderedQuantityDetails(int orderedQuantity);
    void printDeliveryDate(LocalDate deliveryDate, String deliveryStatus);

}
