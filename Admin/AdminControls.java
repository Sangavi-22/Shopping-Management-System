package Admin;

import DataStorage.DataSource;
import DataStorage.DataSourceService;
import Inputs.InputsFromUser;

public class AdminControls implements  AdminControlsService{
    private final DataSourceService dataSource= DataSource.getInstance();
    private final InputsFromUser inputsFromUser = new InputsFromUser();
    public int generateId(String input) {
        int memberType, id;
        if(input.equals("guest")) {
            id =dataSource.getIdForCustomer()+1;
        }
        else {
            memberType = inputsFromUser.inputMemberType();
            if (memberType == 1) {
                id =dataSource.getIdForSeller()+1;
            } else if (memberType == 2) {
                id =dataSource.getIdForCustomer()+1;
            } else {
                id =0;
            }
        }
        return id;
    }
    public void removeSellers(String userName){
        dataSource.removeSeller(userName);
    }
    public void removeCustomers(String userName){
        dataSource.removeCustomer(userName);
    }
}
