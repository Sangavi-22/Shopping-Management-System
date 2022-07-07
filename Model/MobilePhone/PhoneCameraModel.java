package Model.MobilePhone;

public class PhoneCameraModel {
    private String primaryCamera;
    private String secondaryCamera;
    public void setPrimaryCamera(String primaryCamera){
        this.primaryCamera=primaryCamera;
    }
    public String getPrimaryCamera(){
        return this.primaryCamera;
    }
    public void setSecondaryCamera(String secondaryCamera){
        this.secondaryCamera=secondaryCamera;
    }
    public String getSecondaryCamera(){
        return this.secondaryCamera;
    }

}
