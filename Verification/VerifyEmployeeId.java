package Verification;

import DataStorage.DataSource;
import DataStorage.DataSourceService;

public class VerifyEmployeeId implements VerifyEmployeeIdService{
    private final DataSourceService dataSource= DataSource.getInstance();

    public boolean verifyEmployeeId(String employmentNum){
        return dataSource.containsEmployeeNum(employmentNum);
    }
}
