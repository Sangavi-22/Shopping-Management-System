package Model.Users;

public class UserAccountModel {
    private String name,email,userName,password;
    private long mobileNum;
    private int id;
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setMobileNum(long mobileNum){
        this.mobileNum=mobileNum;
    }
    public long getMobileNum(){
        return this.mobileNum;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setUserId(int id){
        this.id=id;
    }
    public int getUserId(){
        return this.id;
    }
}
