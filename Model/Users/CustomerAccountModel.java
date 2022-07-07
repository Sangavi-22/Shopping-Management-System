package Model.Users;

public class CustomerAccountModel extends UserAccountModel {
    private int id;
    private String address;
    public void setUserId(int id){
        this.id=id;
    }
    public int getUserId(){
        return this.id;
    }
    public void setShippingAddress(String address){
        this.address=address;
    }
    public String getShippingAddress(){
        return this.address;
    }
}
