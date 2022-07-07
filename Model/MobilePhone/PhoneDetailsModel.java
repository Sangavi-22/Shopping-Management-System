package Model.MobilePhone;

public class PhoneDetailsModel {
    private int productId,price;
    private double displaySize;
    private String modelName,batteryCapacity;
    public void setProductId(int productId){
        this.productId=productId;
    }
    public int getProductId(){
        return this.productId;
    }
    public void setModelName(String modelName){
        this.modelName=modelName;
    }
    public String getModelName(){
        return this.modelName;
    }
    public void setBatteryCapacity(String batteryCapacity){
        this.batteryCapacity=batteryCapacity;
    }
    public String getBatteryCapacity(){
        return this.batteryCapacity;
    }
    public void setDisplaySize(double displaySize){
        this.displaySize=displaySize;
    }
    public double getDisplaySize(){
        return this.displaySize;
    }
    public void setPrice(int price) {
        this.price=price;
    }
    public int getPrice(){
        return this.price;
    }
}
