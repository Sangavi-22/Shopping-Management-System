package FileOperations;

public interface BillAmountFileHandlerService {
    void writeBillAmount(int orderId,int billAmount);
    int readBillAmount(int orderId);
    void removeBillAmount(int orderId);
}
