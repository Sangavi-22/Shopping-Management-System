package Model.MobilePhone;

public class PhoneProcessorModel {
    private String operatingSystem;
    private String processorType;
    public void setOperatingSystem(String operatingSystem){
        this.operatingSystem=operatingSystem;
    }
    public String getOperatingSystem(){
        return this.operatingSystem;
    }
    public void setProcessorType(String processorType){
        this.processorType=processorType;
    }
    public String getProcessorType(){
        return this.processorType;
    }

}
