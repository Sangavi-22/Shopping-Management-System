package Date;

import java.time.LocalDate;

public class DateUtility {
    private LocalDate deliveryDate;
    public void setDeliveryDate(int orderId){
        this.deliveryDate=LocalDate.now().plusDays(orderId-1);
    }
    public LocalDate getDeliveryDate(){
        return this.deliveryDate;
    }
}
