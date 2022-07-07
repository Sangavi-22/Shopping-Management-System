package FileOperations;

import java.util.ArrayList;

public interface StockNotAvailableFileHandlerService {
    void writeToFile(int id);
    ArrayList<Integer>readStockNotAvailableProducts();
    void removePhoneId(int phoneId);
}
