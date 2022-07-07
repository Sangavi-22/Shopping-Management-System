package Controller.ControlSeller;

import DataStorage.DataSource;
import DataStorage.DataSourceService;
import Model.Users.SellerAccountModel;
import View.Seller.PrintSellerInfoViewService;
import View.Seller.SellerAccountViewService;
import View.Seller.SellerMenuViewService;

public class SellerAccountController implements SellerAccountControllerService{
    private final SellerAccountModel model;
    private final SellerAccountViewService view;
    private final SellerMenuViewService sellerMenuView;
    private final PrintSellerInfoViewService printSellerInfoView;
    private final DataSourceService dataSource= DataSource.getInstance();
    public SellerAccountController(SellerAccountModel model, SellerAccountViewService view, SellerMenuViewService sellerMenuView, PrintSellerInfoViewService printSellerInfoView){
        this.model=model;
        this.view=view;
        this.sellerMenuView=sellerMenuView;
        this.printSellerInfoView=printSellerInfoView;
    }
    public void setOtherInputs(){
        this.view.inputSellerDetails(this);
        this.addSellerToDataSource();
    }
    public void addSellerToDataSource(){
        dataSource.addSeller(this.model);
    }
    public void sellerMenu(){
        this.sellerMenuView.setController(this);
        this.sellerMenuView.sellerMenu();
    }
    public void setName(String name){
        this.model.setName(name);
    }
    public String getName(){
        return this.model.getName();
    }
    public void setEmail(String email){
        this.model.setEmail(email);
    }
    public String getEmail(){
        return this.model.getEmail();
    }
    public void setMobileNum(long mobileNum){
        this.model.setMobileNum(mobileNum);
    }
    public long getMobileNum(){
        return this.model.getMobileNum();
    }
    public void setUserName(String userName){
        this.model.setUserName(userName);
    }
    public String getUserName(){
        return this.model.getUserName();
    }
    public void setPassword(String password){
        this.model.setPassword(password);
    }
    public String getPassword(){
        return this.model.getPassword();
    }
    public void setUserId(int id){
        this.model.setUserId(id);
    }
    public int getUserId(){
        return this.model.getUserId();
    }
    public void updateProfile(){
        this.view.inputSellerDetailsToUpdate(this);
    }
    public void updatePasswordInDataSource(){
        dataSource.updateSellerDetailsInDataSource(this.model);
    }
    public void updateView(){
        printSellerInfoView.printSellerDetails(this.getUserId(),this.getName(),this.getEmail(),this.getMobileNum());
    }
}
