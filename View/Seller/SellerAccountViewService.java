package View.Seller;

import Controller.ControlSeller.SellerAccountController;
import Controller.ControlSeller.SellerAccountControllerService;

public interface SellerAccountViewService {
    void inputSellerDetails(SellerAccountControllerService sellerAccountController);
    void inputSellerDetailsToUpdate(SellerAccountController sellerAccountController);
    void passDetailsToController(SellerAccountControllerService sellerAccountController);

}
