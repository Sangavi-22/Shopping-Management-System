package View.MobilePhone;

import java.time.LocalDate;

public class PrintPhoneInfoView implements PrintPhoneInfoViewService{
    public void printPhoneBasicInfo(int productId, String name, int storageCapacity, int price){
        System.out.println("Phone Id: "+productId);
        System.out.println("Model Name: "+name);
        System.out.println("Storage Capacity: "+storageCapacity);
        System.out.println("Price: "+price);
    }
    public void printPhoneDetails(int productId, String modelName, String manufacturerName, int width, int height, int weight, double displaySize, String batteryCapacity, String primaryCamera, String secondaryCamera, String operatingSystem, String processorType, int storageCapacity, int price){
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("!                    PHONE DETAILS                    !");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Phone Id: "+productId);
        System.out.println("ModelName: "+modelName);
        System.out.println("ManufacturerName: "+manufacturerName);
        System.out.println("Width: "+width+" mm");
        System.out.println("Height: "+height+" mm");
        System.out.println("Weight: "+weight+" g");
        System.out.println("DisplaySize: "+displaySize+" cm");
        System.out.println("Battery Capacity: "+batteryCapacity+" mAh");
        System.out.println("Primary Camera: "+primaryCamera);
        System.out.println("Secondary Camera: "+secondaryCamera);
        System.out.println("Operating System: "+operatingSystem);
        System.out.println("Processor Type: "+processorType);
        System.out.println("Storage Capacity: "+storageCapacity+" GB");
        System.out.println("Price: Rs."+price);
    }
    public void printQuantityDetails(int quantity){
        System.out.println("Stock Available: "+quantity);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
    }
    public void printOrderedQuantityDetails(int orderedQuantity){
        System.out.println("Ordered Quantity: "+orderedQuantity);
        System.out.println();
    }
    public void printDeliveryDate(LocalDate deliveryDate, String deliveryStatus){
        System.out.println("Delivery Date: "+deliveryDate);
        System.out.println("Delivery Status: "+deliveryStatus);
        System.out.println();
    }
}
