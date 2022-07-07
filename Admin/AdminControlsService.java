package Admin;

public interface AdminControlsService {
    int generateId(String input);
    void removeSellers(String userName);
    void removeCustomers(String userName);
}
